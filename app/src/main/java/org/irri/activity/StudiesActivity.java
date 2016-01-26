package org.irri.activity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;

import org.irri.database.AccountManager;
import org.irri.database.DatabaseMasterTool;
import org.irri.database.StudyManager;
import org.irri.entity.AccessToken;
import org.irri.entity.MockData;
import org.irri.entity.PlotData;
import org.irri.entity.Study;
import org.irri.entity.StudyListData;
import org.irri.entity.StudyMetadata;
import org.irri.entity.User;
import org.irri.entity.VariableSet;
import org.irri.expandablelist.ListObject;
import org.json.JSONObject;

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

public class StudiesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String accessToken;
    AsyncHttpClient client;
    User user;
    Gson gson;
    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";
    private Study study;
    private ListView lvStudyList;
    private int REQUEST_CODE = 0X1;
    List<StudyListData> studyList;
    MyStudyListAdapter adapter;
    private TableRow tblRowSearch;
    private EditText etSearchStudy;
    int searchFlag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studies);
        Bundle bundle = getIntent().getExtras();
        accessToken=bundle.getString("ACCESS_TOKEN");
        studyList= getMyStudyList(null);
        lvStudyList= (ListView) findViewById(R.id.lvStudyList);
        adapter = new MyStudyListAdapter(getApplicationContext(),R.layout.activity_study_list_row,studyList);
        lvStudyList.setAdapter(adapter);
        lvStudyList.setOnItemClickListener(this);

        tblRowSearch = (TableRow) findViewById(R.id.tblRowSearch);
        tblRowSearch.setVisibility(View.GONE);

        etSearchStudy=(EditText) findViewById(R.id.etSearchStudy);

        etSearchStudy.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                // you can call or do what you want with your EditText here


            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                studyList.clear();
                studyList= getMyStudyList(etSearchStudy.getText().toString());
                adapter = new MyStudyListAdapter(getApplicationContext(),R.layout.activity_study_list_row,studyList);
                adapter.notifyDataSetChanged();
                lvStudyList.setAdapter(adapter);

            }
        });

    }

    private List<StudyListData> getMyStudyList(String filter) {
        List<StudyListData> toreturn= new ArrayList<StudyListData>();

        DatabaseMasterTool dbTool = new DatabaseMasterTool(this);
        SQLiteDatabase database = dbTool.openDBMaster();
        StudyManager mgr = new StudyManager();
        Cursor cursor=null;
        if(filter==null){
            cursor = mgr.getAllStudyRecords(database);
        }else{
            cursor = mgr.getStudyByName(database,filter);
        }

        if(cursor != null && cursor.getCount() > 0){

            if (cursor.moveToFirst()) {
                do {
                    String name=cursor.getString(cursor.getColumnIndex("name"));
                    String title=cursor.getString(cursor.getColumnIndex("title"));
                    int id = cursor.getInt(cursor.getColumnIndex("id"));
                    StudyListData rec = new StudyListData();
                    rec.setId(id);
                    rec.setName(name);
                    rec.setTitle(title);
                    toreturn.add(rec);
                } while (cursor.moveToNext());
            }
        }

        dbTool.close();
        return toreturn;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_studies, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()){
            case R.id.action_loadstudy:
                String urlString="http://api.breeding4rice.irri.org/v1/studies?accessToken="+accessToken;
                new JSONTask().execute(urlString);
                break;
            case R.id.action_search:
                if(searchFlag==0) {
                    tblRowSearch.setVisibility(View.VISIBLE);
                    item.setIcon(R.drawable.search_minus);
                    searchFlag=1;

                }else{
                    item.setIcon(R.drawable.search);
                    tblRowSearch.setVisibility(View.GONE);
                    searchFlag=0;
                }
                break;
            case R.id.action_help:
                break;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_loadstudy) {

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        StudyListData study = (StudyListData) adapter.getItem(position);
        Intent intent = new Intent(getApplicationContext(), StudyMainActivity.class);
        intent.putExtra("STUDYNAME", study.getName());
        startActivity(intent);
    }

    public class MyStudyListAdapter extends ArrayAdapter {

        public List<StudyListData> studyModelEntity;
        private int resource;
        private LayoutInflater inflater;


        public MyStudyListAdapter(Context context, int resource,  List<StudyListData> objects) {
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

    public class JSONTask extends AsyncTask<String,String,String> {


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
            Intent intent = new Intent(getApplicationContext(), StudyListActivity.class);
            intent.putExtra("ACCESS_TOKEN", accessToken);
            intent.putExtra("STUDY",result);
            startActivityForResult(intent, REQUEST_CODE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                /*Bundle extras = data.getExtras();
                final String dataString =extras.getString("data");

                Handler refresh = new Handler(Looper.getMainLooper());
                refresh.post(new Runnable() {
                    public void run() {
                        populateData(dataString);
                    }
                });*/

                studyList.clear();
                studyList= getMyStudyList(null);
                adapter = new MyStudyListAdapter(getApplicationContext(),R.layout.activity_study_list_row,studyList);
                adapter.notifyDataSetChanged();
                lvStudyList.setAdapter(adapter);

            }
        }


    }



    public void actionBtnSearchHide(View v) {
        tblRowSearch.setVisibility(View.GONE);
    }

    public void actionBtnSearchClear(View v){
        etSearchStudy.setText("");
        etSearchStudy.requestFocus();
    }

}
