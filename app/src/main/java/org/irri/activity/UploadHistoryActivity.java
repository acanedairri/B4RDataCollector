package org.irri.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;

import org.irri.database.DatabaseMasterTool;
import org.irri.database.StudyManager;
import org.irri.entity.CommitMessage;
import org.irri.entity.Study;
import org.irri.entity.StudyListData;
import org.irri.entity.UploadHistoryModel;
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

public class UploadHistoryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String accessToken;
    AsyncHttpClient client;
    User user;
    Gson gson;
    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";
    private Study study;
    private ListView lvCommitHistoryList;
    private int REQUEST_CODE = 0X1;
    List<UploadHistoryModel> commitMessageList;
    MyCommitHistoryListAdapter adapter;
    private TableRow tblRowSearch;
    private EditText etSearchStudy;
    int searchFlag=0;
    private int totalUncommitedRecord;
    private String studyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_history);
        Bundle bundle = getIntent().getExtras();
        accessToken=bundle.getString("ACCESS_TOKEN");

        studyName=bundle.getString("STUDYNAME");

        commitMessageList= getMyCommitHistory(null);
        lvCommitHistoryList= (ListView) findViewById(R.id.lvCommitHistoryList);
        adapter = new MyCommitHistoryListAdapter(getApplicationContext(),R.layout.activity_upload_history_list_row,commitMessageList);
        lvCommitHistoryList.setAdapter(adapter);
        lvCommitHistoryList.setOnItemClickListener(this);

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

                commitMessageList.clear();
                commitMessageList = getMyCommitHistory(etSearchStudy.getText().toString());
                adapter = new MyCommitHistoryListAdapter(getApplicationContext(), R.layout.activity_upload_history_list_row, commitMessageList);
                adapter.notifyDataSetChanged();
                lvCommitHistoryList.setAdapter(adapter);

            }
        });

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    private List<UploadHistoryModel> getMyCommitHistory(String filter) {
        List<UploadHistoryModel> toreturn= new ArrayList<UploadHistoryModel>();

        DatabaseMasterTool dbToolStudy = new DatabaseMasterTool(getApplicationContext(),studyName);
        dbToolStudy.openStudyDatabase(studyName);
        SQLiteDatabase studyDatabase=dbToolStudy.getDatabase();
        StudyManager mgr = new StudyManager();
        Cursor cursor=null;
        if(filter==null){
            cursor = mgr.getAllStudyCommitHistory(studyDatabase);
        }else{
            cursor = mgr.getAllStudyCommitHistory(studyDatabase,filter);
        }

        if(cursor != null && cursor.getCount() > 0){

            if (cursor.moveToFirst()) {
                do {
                    String message=cursor.getString(cursor.getColumnIndex("remarks"));
                    int id=cursor.getInt(cursor.getColumnIndex("transaction_id"));
                    String dtd=cursor.getString(cursor.getColumnIndex("date_commit"));
                    UploadHistoryModel rec = new UploadHistoryModel();
                    rec.setRemarks(message);
                    rec.setTransId(id);
                    rec.setDate_upload(dtd);
                    toreturn.add(rec);
                } while (cursor.moveToNext());
            }
        }

        dbToolStudy.close();
        return toreturn;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_upload_history);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id==android.R.id.home){
           //viewLogoutConfirmDialog();
            finish();
            return true;
        }

        switch (item.getItemId()){
            case R.id.action_loadstudy:
                String urlString="http://api.breeding4rice.irri.org/v1/studies?accessToken="+accessToken+"&limit=-1&sort=name";
                //new JSONTask().execute(urlString);
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
/*        StudyListData study = (StudyListData) adapter.getItem(position);
        Intent intent = new Intent(getApplicationContext(), StudyMainActivity.class);
        intent.putExtra("STUDYNAME", study.getName());
        intent.putExtra("ACCESSTOKEN", accessToken);
        intent.putExtra("NEWRECORD",totalUncommitedRecord);
        startActivity(intent);*/
    }

    public class MyCommitHistoryListAdapter extends ArrayAdapter {

        public List<UploadHistoryModel> commitHistoryModelEntity;
        private int resource;
        private LayoutInflater inflater;
        String studyName;


        public MyCommitHistoryListAdapter(Context context, int resource,  List<UploadHistoryModel> objects) {
            super(context, resource, objects);
            commitHistoryModelEntity=objects;
            this.resource=resource;
            inflater=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView==null){
                convertView = inflater.inflate(resource,null);
            }
            TextView tvTransId;
            TextView tvDateUploaded;
            tvTransId = (TextView) convertView.findViewById(R.id.tvTransId);
            int t=commitHistoryModelEntity.get(position).getTransId();
            tvTransId.setText("Transaction Id: "+String.valueOf(t));

            tvDateUploaded = (TextView) convertView.findViewById(R.id.tvDateUploaded);
            String date=commitHistoryModelEntity.get(position).getDate_upload();
            tvDateUploaded.setText(date);

            return convertView;
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

                commitMessageList.clear();
                commitMessageList= getMyCommitHistory(null);
                adapter = new MyCommitHistoryListAdapter(getApplicationContext(),R.layout.activity_upload_history_list_row,commitMessageList);
                adapter.notifyDataSetChanged();
                lvCommitHistoryList.setAdapter(adapter);

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

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();
        //viewLogoutConfirmDialog();
        finish();

    }

    private void viewLogoutConfirmDialog(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                UploadHistoryActivity.this);
        alertDialog.setTitle("Confirm Logout");
        alertDialog.setMessage("Are you sure you want to Logout?");
        alertDialog.setIcon(R.drawable.info);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed
                //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            } });

        // Showing Alert Message
        alertDialog.show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        commitMessageList.clear();
        commitMessageList= getMyCommitHistory(null);
        adapter = new MyCommitHistoryListAdapter(getApplicationContext(),R.layout.activity_upload_history_list_row,commitMessageList);
        adapter.notifyDataSetChanged();
        lvCommitHistoryList.setAdapter(adapter);
    }
}
