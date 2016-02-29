package org.irri.activity;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.irri.database.AccountManager;
import org.irri.database.DatabaseMasterTool;
import org.irri.database.StudyManager;
import org.irri.entity.MockData;
import org.irri.entity.ObservationData;
import org.irri.entity.Study;
import org.irri.entity.StudyListData;
import org.irri.entity.StudyListModel;
import org.irri.entity.StudyMetadata;
import org.irri.entity.StudyMetadataList;
import org.irri.entity.VariableSet;
import org.irri.utility.ConnectionState;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StudyListActivity extends AppCompatActivity {

    private String accessToken;
    private ListView lvStudyList;
    private String studyObj;
    private int studyIdSelected;
    private String studyNameSelected;
    protected Object mActionMode;
    public int selectedItem = -1;
    private EditText etSearchStudy;
    StudyListAdapter adapter;
    List<Study.DataEntity.ItemsEntity> studyList;
    List<StudyListModel> studyListModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_list);
        Bundle bundle = getIntent().getExtras();
        accessToken=bundle.getString("ACCESS_TOKEN");
        studyObj=bundle.getString("STUDY");
        lvStudyList= (ListView) findViewById(R.id.lvStudyList);

        Gson gson = new Gson();
        Study study = gson.fromJson(studyObj, Study.class);
        studyListModel=populateStudyList(study.getData().getItems());
        studyList=study.getData().getItems();
        adapter = new StudyListAdapter(getApplicationContext(),R.layout.activity_study_list_row,studyListModel);
        lvStudyList.setAdapter(adapter);
        //lvStudyList.setOnItemClickListener(mMessageClickedHandler);
        //lvStudyList.setOnItemLongClickListener(longClickItem);
        registerForContextMenu(lvStudyList);

        etSearchStudy=(EditText) findViewById(R.id.etSearchStudy);
        etSearchStudy.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                // you can call or do what you want with your EditText here


            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                studyListModel.clear();
                studyListModel = getMyStudyList(etSearchStudy.getText().toString());
                adapter = new StudyListAdapter(getApplicationContext(), R.layout.activity_study_list_row, studyListModel);
                adapter.notifyDataSetChanged();
                lvStudyList.setAdapter(adapter);

            }
        });

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);

    }

    private List<StudyListModel> populateStudyList(List<Study.DataEntity.ItemsEntity>  items) {

        List<StudyListModel> toreturn=new ArrayList<StudyListModel>();
        DatabaseMasterTool dbTool = new DatabaseMasterTool(this);
        SQLiteDatabase database=dbTool.getMasterDatabase();
        StudyManager mgr= new StudyManager();

        mgr.deleteStudyList(database);
        //insert new studylist
        for(Study.DataEntity.ItemsEntity rec:items){
            ContentValues contextValue = new ContentValues();
            contextValue.put("studyid",rec.getId());
            contextValue.put("name",rec.getName());
            mgr.insertStudyList(database,contextValue);
        }

        Cursor studyList= mgr.getAllStudyList(database);

        if(studyList != null && studyList.getCount() > 0){

            if (studyList.moveToFirst()) {
                do {
                    int id=studyList.getInt(studyList.getColumnIndex("studyid"));
                    String name=studyList.getString(studyList.getColumnIndex("name"));

                    StudyListModel rec = new StudyListModel();
                    rec.setId(id);
                    rec.setName(name);

                    toreturn.add(rec);
                } while (studyList.moveToNext());
            }
        }

        dbTool.closeDB(database);

        return toreturn;

    }

    private List<StudyListModel> getMyStudyList(String filter) {
        List<StudyListModel> toreturn=new ArrayList<StudyListModel>();
        DatabaseMasterTool dbTool = new DatabaseMasterTool(this);
        SQLiteDatabase database=dbTool.getMasterDatabase();
        StudyManager mgr= new StudyManager();
        Cursor studyList;
        if(filter.length() > 0) {
            studyList = mgr.getStudyListByName(database,filter);
        }else{

            studyList = mgr.getAllStudyList(database);
        }

        if(studyList != null && studyList.getCount() > 0){

            if (studyList.moveToFirst()) {
                do {
                    int id=studyList.getInt(studyList.getColumnIndex("studyid"));
                    String name=studyList.getString(studyList.getColumnIndex("name"));

                    StudyListModel rec = new StudyListModel();
                    rec.setId(id);
                    rec.setName(name);
                    toreturn.add(rec);
                } while (studyList.moveToNext());
            }
        }

        dbTool.closeDB(database);

        return toreturn;

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        ListView lv = (ListView) v;
        AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) menuInfo;
        StudyListModel obj = (StudyListModel) lv.getItemAtPosition(acmi.position);
        menu.setHeaderTitle(obj.getName());
        menu.add(0, obj.getId(), 0, "Get Study");
        menu.add(1, obj.getId(), 0, "View Info");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle() == "Get Study") {
            // TODO: 2015-12-08

            boolean isStudyExist=isStudyExistCheck(item.getItemId());
            if(!isStudyExist) {
                String urlStringStudy = "http://api.breeding4rice.irri.org/v1/studies/" + item.getItemId() + "/metadata?accessToken=" + accessToken;
                String urlStringObsevationData = "http://api.breeding4rice.irri.org/dev/v1/studies/" + item.getItemId() + "/data-collection?accessToken=" + accessToken + "&sort=plotno&limit=-1";
                new JSONTaskGetStudy().execute(urlStringStudy, urlStringObsevationData);
            }else{

                Toast.makeText(getApplicationContext(), "The study is already exists", Toast.LENGTH_SHORT).show();

            }
        }else if(item.getTitle() == "View Info") {
            // TODO: 2015-12-08  get study metadata and open to activity
            String urlString="http://api.breeding4rice.irri.org/v1/studies/"+item.getItemId()+"/metadata?accessToken="+accessToken;
            new JSONTaskViewStudy().execute(urlString);

        }else{

            return false;
        }
        return true;

    }

    private boolean isStudyExistCheck(int studyId) {

        DatabaseMasterTool dbTool = new DatabaseMasterTool(this);
        SQLiteDatabase database=dbTool.getMasterDatabase();
        StudyManager mgr= new StudyManager();
        boolean toreturn=mgr.isStudyExist(database,studyId);
        return toreturn;
    }

    // Create a message handling object as an anonymous class.
    private AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id)
        {
            Study.DataEntity.ItemsEntity entity =(Study.DataEntity.ItemsEntity) lvStudyList.getAdapter().getItem(position);
            Toast.makeText(getApplicationContext(),
                    "Click ListItem Number " + entity.getName(), Toast.LENGTH_LONG)
                    .show();
            studyIdSelected=entity.getId();
            studyNameSelected=entity.getName();
        }
    };

    private AdapterView.OnItemLongClickListener longClickItem= new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Study.DataEntity.ItemsEntity entity =(Study.DataEntity.ItemsEntity) lvStudyList.getAdapter().getItem(position);

            /*Toast.makeText(getApplicationContext(),
                    "Click ListItem Number " + entity.getName(), Toast.LENGTH_LONG)
                    .show();*/
            studyIdSelected = entity.getId();
            studyNameSelected=entity.getName();
            return true;
        }

    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_study_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if(id==android.R.id.home){

            this.finish();
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_help) {

            Intent intent = new Intent(getApplicationContext(), HelpActivity.class);
            intent.putExtra("IMAGE", "help_studylist");
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



   private void show(int itemId) {
        Toast.makeText(StudyListActivity.this, String.valueOf(itemId), Toast.LENGTH_LONG).show();
    }

    public class StudyListAdapter extends ArrayAdapter{

        public List<StudyListModel> studyModelEntity;
        private int resource;
        private LayoutInflater inflater;


        public StudyListAdapter(Context context, int resource,List<StudyListModel> objects) {
            super(context, resource, objects);
            studyModelEntity=objects;
            this.resource=resource;
            inflater=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView==null){
                convertView = inflater.inflate(resource,null);
            }

            TextView tvStudyName;
            TextView tvStudyId;

            tvStudyName = (TextView) convertView.findViewById(R.id.tvStudyName);
            tvStudyId = (TextView) convertView.findViewById(R.id.tvStudyId);

            tvStudyName.setText(studyModelEntity.get(position).getName());
            tvStudyId.setText(String.valueOf(studyModelEntity.get(position).getId()));

            return convertView;
        }
    }


    public class JSONTaskGetStudy extends AsyncTask<String,String,String> {

        String studyId;
        private ProgressDialog Dialog = new ProgressDialog(StudyListActivity.this);
        String dataRows;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Dialog.setMessage(" please wait while processing............");
            Dialog.show();
        }

        @Override
        protected String doInBackground(String... params) {

            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            ConnectionState conState = new ConnectionState(cm);
            boolean hasCon = conState.haveNetworkConnection();

            if (!hasCon) {
                return null;
            }


            HttpURLConnection con = null;
            HttpURLConnection con2 = null;
            BufferedReader reader = null;
            BufferedReader readerData = null;
            String toreturn = null;


            try {

                //get study metadata
                URL url = new URL(params[0]);
                con = (HttpURLConnection) url.openConnection();
                con.connect();

                InputStream stream = con.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line;

                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                buffer.append("#");


                //get observation
                URL urlData = new URL(params[1]);
                con2 = (HttpURLConnection) urlData.openConnection();
                con2.connect();

                InputStream streamData = con2.getInputStream();
                readerData = new BufferedReader(new InputStreamReader(streamData));

                StringBuffer bufferData = new StringBuffer();
                String lineData;

                while ((lineData = readerData.readLine()) != null) {
                    bufferData.append(lineData);
                }

                Gson gsonData = new Gson();
                try {
                    ObservationData observationData = gsonData.fromJson(bufferData.toString(), ObservationData.class);
                }catch (Exception e){
                    return null;
                }


                toreturn = buffer.toString() + bufferData.toString();
                dataRows=bufferData.toString();

                return toreturn;

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (ProtocolException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }


        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);

/*            Intent data = new Intent();
            data.putExtra("data", result);
            setResult(RESULT_OK, data);*/
            if (result != null) {
                populateData(result);
                setResult(RESULT_OK, null);
                Dialog.dismiss();
                finish();

            } else {
                AlertDialog alertDialog = new AlertDialog.Builder(
                        StudyListActivity.this).create();
                alertDialog.setTitle("Web Service Connection Error");
                alertDialog.setMessage("Error retrieving plot data");
                alertDialog.setIcon(R.drawable.info);
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog closed
                        //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                    }
                });
                Dialog.dismiss();
                alertDialog.show();
            }
        }

        private void populateData(String result) {

            //todo save data to database
            try {

                String[] res = result.split("#");
                String studyName = null;

                Gson gson = new Gson();
                StudyMetadata studyMetadata = gson.fromJson(res[0], StudyMetadata.class);


                // create new study database
                DatabaseMasterTool dbToolStudy = new DatabaseMasterTool(getApplicationContext(), studyMetadata.getData().getName().toString());
                SQLiteDatabase databaseStudy = dbToolStudy.createStudyDatabase(getApplicationContext(), studyMetadata.getData().getName().toString());
                SQLiteDatabase studyDatabase = dbToolStudy.getStudyDatabase(studyMetadata.getData().getName().toString());
                StudyManager mgrStudy = new StudyManager();

                // save study information

                ContentValues context = new ContentValues();
                context.put("id", studyMetadata.getData().getId());
                context.put("name", studyMetadata.getData().getName().toString());
                context.put("title", studyMetadata.getData().getTitle().toString());
                context.put("program", studyMetadata.getData().getProgram().toString());
                context.put("phase", studyMetadata.getData().getPhase().toString());
                context.put("season", studyMetadata.getData().getSeason().toString());
                context.put("place", studyMetadata.getData().getPlace().toString());
                context.put("year", String.valueOf(studyMetadata.getData().getYear()));
                mgrStudy.insertStudyBasicInfoRecord(studyDatabase, context);


                // save study metadata information

                List<StudyMetadata.DataEntity.MetadataEntity> objects = studyMetadata.getData().getMetadata();

                for (StudyMetadata.DataEntity.MetadataEntity rec : objects) {
                    ContentValues contextMeta = new ContentValues();
                    contextMeta.put("variable", rec.getVariable_id().getValue());
                    contextMeta.put("value", rec.getValue());

                    if(rec.getVariable_id().getValue().equals("STUDY")){
                        studyName=  rec.getValue();
                    }
                    mgrStudy.insertStudyMetaData(studyDatabase, contextMeta);
                }

                // create plot table
                Gson gsonData = new Gson();

                ObservationData observationData = gsonData.fromJson(dataRows, ObservationData.class);

                int recno = 1;
                // save plot data

                List<ObservationData.DataEntity.ItemsEntity> objectsData = observationData.getData().getItems();

                for (ObservationData.DataEntity.ItemsEntity rec : objectsData) {

                    ContentValues cv = new ContentValues();
                    cv.put("recno", recno);
                    cv.put("plot_key", rec.getPLOT_KEY());
                    cv.put("rep", Integer.valueOf(rec.getREP()));
                    cv.put("plotno", Integer.valueOf(rec.getPLOTNO()));
                    cv.put("entno", Integer.valueOf(rec.getENTNO()));
                    cv.put("entcode", rec.getENTCODE());
                    cv.put("designation", rec.getDESIGNATION());
                    cv.put("parentage", rec.getPARENTAGE());
                    cv.put("generation", rec.getGENERATION());
                    cv.put("qr_code", String.valueOf(rec.getQR_CODE()));
                    cv.put("fldrow_cont", rec.getFLDROW_CONT());
                    cv.put("fldcol_cont", rec.getFLDCOL_CONT());
                    mgrStudy.insertPlot(studyDatabase, cv);
                    recno++;

                }

/*

            // save variable set
            // mock data
            MockData mockData = new MockData();


            VariableSet variableSet = gson.fromJson(mockData.getVariableSet(), VariableSet.class);

            for(VariableSet.DataEntity.ItemsEntity item:variableSet.getData().getItems()){
                ContentValues contextVariable= new ContentValues();
                contextVariable.put("variable_id", item.getId());
                contextVariable.put("abbrev", item.getAbbrev());
                contextVariable.put("label",item.getLabel());
                contextVariable.put("name", item.getName());
                contextVariable.put("data_type",item.getData_type());
                contextVariable.put("display_name", item.getDisplay_name());
                String scaleValue=String.valueOf(item.getScales().getScale_value());
                contextVariable.put("scale_value", scaleValue);
                contextVariable.put("is_selected","false");
                mgrStudy.insertVariableSet(studyDatabase,contextVariable);
            }*/


                dbToolStudy.closeDB(databaseStudy);

                // insert study record to master table
                DatabaseMasterTool dbTool = new DatabaseMasterTool(getApplicationContext());
                SQLiteDatabase database = dbTool.getMasterDatabase();
                StudyManager mgr = new StudyManager();
                ContentValues studyInfo = new ContentValues();
                studyInfo.put("id", studyMetadata.getData().getId());
                studyInfo.put("name", studyMetadata.getData().getName().toString());
                studyInfo.put("studyname", studyName);
                studyInfo.put("title", studyMetadata.getData().getTitle().toString());
                studyInfo.put("program", studyMetadata.getData().getProgram().toString());
                studyInfo.put("phase", studyMetadata.getData().getPhase().toString());
                studyInfo.put("season", studyMetadata.getData().getSeason().toString());
                mgr.insertStudyBasicInfoRecord(database, studyInfo);
                dbTool.closeDB(database);

            } catch (Exception e) {
                System.out.println("Error");
            }
        }


        protected String addQuoteToSting(String s) {
            String[] line = s.split(",");
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < line.length; i++) {
                sb.append("'" + line[i] + "'" + ",");
            }
            String toreturn = sb.toString().substring(0, sb.length() - 1);
            return toreturn;
        }

    }



    public class JSONTaskViewStudy extends AsyncTask<String,String,String> {


        private ProgressDialog Dialog = new ProgressDialog(StudyListActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Dialog.setMessage(" please wait while loading............");
            Dialog.show();
        }

        @Override
        protected String doInBackground(String... params) {

            HttpURLConnection con = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                con = (HttpURLConnection) url.openConnection();
                con.connect();

                InputStream stream = con.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line;

                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                return buffer.toString();

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Intent intent = new Intent(getApplicationContext(), StudyInfoTabActivity.class);

            Gson gson = new Gson();
            StudyMetadata studyMetadata = gson.fromJson(result, StudyMetadata.class);

            intent.putExtra("NAME", studyMetadata.getData().getName());
            intent.putExtra("NAME", studyMetadata.getData().getName());
            intent.putExtra("TITLE", studyMetadata.getData().getTitle());
            intent.putExtra("PROGRAM", studyMetadata.getData().getProgram());
            intent.putExtra("PLACE", studyMetadata.getData().getPlace());
            intent.putExtra("PHASE", studyMetadata.getData().getPhase());
            intent.putExtra("YEAR", String.valueOf(studyMetadata.getData().getYear()));
            intent.putExtra("SEASON", studyMetadata.getData().getSeason());

            // get studymetadata;
            String line = "";
            List<StudyMetadata.DataEntity.MetadataEntity> objects = studyMetadata.getData().getMetadata();
            for (StudyMetadata.DataEntity.MetadataEntity rec : objects) {
                StudyMetadataList sm = new StudyMetadataList();
                sm.setVariable(rec.getVariable_id().getValue());
                line = line + rec.getVariable_id().getValue() + ":" + rec.getValue() + ",";

            }

            //           System.out.println(line);
            intent.putExtra("OTHER_METADATA", line);

            startActivity(intent);
            Dialog.dismiss();
        }
    }


}


