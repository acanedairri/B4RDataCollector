package org.irri.activity;

import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.irri.database.AccountManager;
import org.irri.database.DatabaseMasterTool;
import org.irri.database.StudyManager;
import org.irri.entity.MockData;
import org.irri.entity.Study;
import org.irri.entity.StudyMetadata;
import org.irri.entity.StudyMetadataList;

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
        StudyListAdapter adapter = new StudyListAdapter(getApplicationContext(),R.layout.activity_study_list_row,study.getData().getItems());
        lvStudyList.setAdapter(adapter);
        //lvStudyList.setOnItemClickListener(mMessageClickedHandler);
        //lvStudyList.setOnItemLongClickListener(longClickItem);
        registerForContextMenu(lvStudyList);




    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        ListView lv = (ListView) v;
        AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) menuInfo;
        Study.DataEntity.ItemsEntity obj = (Study.DataEntity.ItemsEntity) lv.getItemAtPosition(acmi.position);
        menu.setHeaderTitle(obj.getName());
        menu.add(0, obj.getId(), 0, "Get Study");
        menu.add(1,obj.getId(), 0, "View Info");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle() == "Get Study") {
            // TODO: 2015-12-08
            String urlString="http://api.breeding4rice.irri.org/v1/studies/"+item.getItemId()+"/metadata?accessToken="+accessToken;
            new JSONTaskGetStudy().execute(urlString);
        }else if(item.getTitle() == "View Info") {
            // TODO: 2015-12-08  get study metadata and open to activity
            String urlString="http://api.breeding4rice.irri.org/v1/studies/"+item.getItemId()+"/metadata?accessToken="+accessToken;
            new JSONTaskViewStudy().execute(urlString);

        }else{

            return false;
        }
        return true;

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_help) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



   private void show(int itemId) {
        Toast.makeText(StudyListActivity.this, String.valueOf(itemId), Toast.LENGTH_LONG).show();
    }

    public class StudyListAdapter extends ArrayAdapter{

        public List<Study.DataEntity.ItemsEntity> studyModelEntity;
        private int resource;
        private LayoutInflater inflater;


        public StudyListAdapter(Context context, int resource,  List<Study.DataEntity.ItemsEntity> objects) {
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

        @Override
        protected String doInBackground(String... params) {

            HttpURLConnection con = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                con=(HttpURLConnection) url.openConnection();
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

            return  null;
        }

        protected void onPostExecute(String result){
            super.onPostExecute(result);

            //todo save data to database

            Gson gson = new Gson();
            StudyMetadata studyMetadata = gson.fromJson(result, StudyMetadata.class);
            DatabaseMasterTool dbTool = new DatabaseMasterTool(getApplicationContext());
            dbTool.openDBMaster();
            SQLiteDatabase database = dbTool.getDatabase();
            StudyManager mgr = new StudyManager(database);
            ContentValues studyInfo= new ContentValues();
            studyInfo.put("id", studyMetadata.getData().getId());
            studyInfo.put("name", studyMetadata.getData().getName().toString());
            studyInfo.put("title", studyMetadata.getData().getTitle().toString());
            studyInfo.put("program", studyMetadata.getData().getProgram().toString());
            studyInfo.put("phase", studyMetadata.getData().getPhase().toString());
            studyInfo.put("season", studyMetadata.getData().getSeason().toString());
            mgr.insertRecord(studyInfo);

            // create new study database

            dbTool.createStudyDatabase(studyMetadata.getData().getName().toString());
            dbTool.openStudyDatabase(studyMetadata.getData().getName().toString());
            SQLiteDatabase studyDatabase=dbTool.getDatabase();
            dbTool.createStudyDatabaseTable(studyDatabase);
            StudyManager mgrStudy = new StudyManager(studyDatabase);

            // save study information

            ContentValues context= new ContentValues();
            context.put("id", studyMetadata.getData().getId());
            context.put("name", studyMetadata.getData().getName().toString());
            context.put("title", studyMetadata.getData().getTitle().toString());
            context.put("program", studyMetadata.getData().getProgram().toString());
            context.put("phase", studyMetadata.getData().getPhase().toString());
            context.put("season", studyMetadata.getData().getSeason().toString());
            mgrStudy.insertRecord(context);

            // save study metadata information

            List<StudyMetadata.DataEntity.MetadataEntity> objects=studyMetadata.getData().getMetadata();

            for(StudyMetadata.DataEntity.MetadataEntity rec:objects){
                ContentValues contextMeta= new ContentValues();
                contextMeta.put("variable", rec.getVariable_id().getValue());
                contextMeta.put("value", rec.getValue());
                mgrStudy.insertRecordMetadata(context);
            }






            dbTool.closeDB();
            setResult(RESULT_OK,null) ;

            finish();
        }
    }

    public class JSONTaskViewStudy extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String... params) {

            HttpURLConnection con = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                con=(HttpURLConnection) url.openConnection();
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

            return  null;
        }

        protected void onPostExecute(String result){
            super.onPostExecute(result);
            Intent intent = new Intent(getApplicationContext(), StudyInfoTabActivity.class);

            Gson gson = new Gson();
            StudyMetadata studyMetadata = gson.fromJson(result, StudyMetadata.class);

            intent.putExtra("NAME",studyMetadata.getData().getName());
            intent.putExtra("NAME",studyMetadata.getData().getName());
            intent.putExtra("TITLE",studyMetadata.getData().getTitle());
            intent.putExtra("PROGRAM",studyMetadata.getData().getProgram());
            intent.putExtra("PLACE",studyMetadata.getData().getPlace());
            intent.putExtra("PHASE",studyMetadata.getData().getPhase());
            intent.putExtra("YEAR", String.valueOf(studyMetadata.getData().getYear()));
            intent.putExtra("SEASON", studyMetadata.getData().getSeason());

            // get studymetadata;
            String line="";
            List<StudyMetadata.DataEntity.MetadataEntity> objects=studyMetadata.getData().getMetadata();
            for(StudyMetadata.DataEntity.MetadataEntity rec:objects){
                StudyMetadataList sm= new StudyMetadataList();
                sm.setVariable(rec.getVariable_id().getValue());
                line=line+rec.getVariable_id().getValue()+":"+rec.getValue()+",";

            }

 //           System.out.println(line);
            intent.putExtra("OTHER_METADATA", line);

            startActivity(intent);
        }
    }

}


