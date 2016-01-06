package org.irri.activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;

import org.irri.database.AccountManager;
import org.irri.database.DatabaseMasterTool;
import org.irri.database.StudyManager;
import org.irri.entity.AccessToken;
import org.irri.entity.Study;
import org.irri.entity.StudyListData;
import org.irri.entity.User;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studies);
        Bundle bundle = getIntent().getExtras();
        accessToken=bundle.getString("ACCESS_TOKEN");
        studyList= getMyStudyList();
        lvStudyList= (ListView) findViewById(R.id.lvStudyList);
        adapter = new MyStudyListAdapter(getApplicationContext(),R.layout.activity_study_list_row,studyList);
        lvStudyList.setAdapter(adapter);
        lvStudyList.setOnItemClickListener(this);

    }

    private List<StudyListData> getMyStudyList() {
        List<StudyListData> toreturn= new ArrayList<StudyListData>();

        DatabaseMasterTool dbTool = new DatabaseMasterTool(this);
        dbTool.openDBMaster();
        SQLiteDatabase database = dbTool.getDatabase();
        StudyManager mgr = new StudyManager(database);

        Cursor cursor = mgr.getAllRecords();
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
                studyList.clear();
                studyList= getMyStudyList();
                adapter = new MyStudyListAdapter(getApplicationContext(),R.layout.activity_study_list_row,studyList);
                adapter.notifyDataSetChanged();
                lvStudyList.setAdapter(adapter);

            }
        }


    }

}
