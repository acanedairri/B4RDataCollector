package org.irri.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.irri.database.DatabaseMasterTool;
import org.irri.database.StudyManager;
import org.irri.entity.CommitMessage;
import org.irri.entity.ObservationData;
import org.irri.entity.PlotDataCommitModel;
import org.irri.entity.StudyListData;
import org.irri.entity.StudyMetadata;
import org.irri.utility.ApplicationPath;
import org.irri.utility.ConnectionState;
import org.irri.utility.DateUtil;
import org.irri.utility.RestClient;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpPut;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.protocol.HTTP;

public class StudyMainActivity extends AppCompatActivity {

    String studyName;
    String accessToken;
    TextView tvNofication;
    TableRow tblNotification;
    private static String is_posted;
    private static int transaction_id;
    //int totalUncommitedRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_main);
        Bundle bundle = getIntent().getExtras();
        studyName=bundle.getString("STUDYNAME");
        accessToken = bundle.getString("ACCESSTOKEN");
       // totalUncommitedRec= bundle.getInt("NEWRECORD");

       viewNotification();
        isPosted();


        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            StudyInfoFragment fragment = new StudyInfoFragment(studyName,this);
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        }

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    private void viewNotification() {

        tvNofication= (TextView) findViewById(R.id.tvNotification);
        tblNotification =(TableRow) findViewById(R.id.tblNotification);

       int totalUncommitedRec=getTotalUncommitedRecord(studyName);

        if(totalUncommitedRec > 0){
            tblNotification.setVisibility(View.VISIBLE);
            tvNofication.setText(" " +String.valueOf(totalUncommitedRec));
        }else{
            tblNotification.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_study_main, menu);
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
        if (id == R.id.action_data_entry) {
            Intent intent = new Intent(StudyMainActivity.this, DataEntryActivity.class);
            intent.putExtra("STUDYNAME", studyName);
            intent.putExtra("ACCESSTOKEN", accessToken);
            startActivity(intent);
            return true;
        }else if(id == R.id.action_trait_measuring){
            Intent intent = new Intent(StudyMainActivity.this, TraitMeasuringActivity.class);
            intent.putExtra("STUDYNAME",studyName);
            intent.putExtra("ACCESSTOKEN", accessToken);
            startActivity(intent);
        }else if(id == R.id.action_load_variable_set) {
            Intent intent = new Intent(StudyMainActivity.this, VariableSetStudyActivity.class);
            intent.putExtra("STUDYNAME",studyName);
            intent.putExtra("ACCESSTOKEN", accessToken);
            intent.putExtra("FLAG",0);
            startActivity(intent);
        }else if(id == R.id.action_commit_study) {
            String jsonString=getPlotDataToCommit();
            String postUrl;
            if(is_posted.equals("N")) {
                 postUrl = "http://api.breeding4rice.irri.org/dev/v1/datasets?accessToken=" + accessToken;
            }else{
                postUrl = "http://api.breeding4rice.irri.org/dev/v1/datasets/"+transaction_id+"?accessToken=" + accessToken;
            }
            //String urlStringStudy="http://api.breeding4rice.irri.org/v1/studies/"+item.getItemId()+"/metadata?accessToken="+accessToken;
           // String url="http://api.breeding4rice.irri.org/dev/v1/studies/"+item.getItemId()+"/data-collection?accessToken="+accessToken;
            new JSONTaskCommitStudy().execute(postUrl,jsonString);
        }else if(id == R.id.action_commit_history) {
            Intent intent = new Intent(StudyMainActivity.this, UploadHistoryActivity.class);
            intent.putExtra("STUDYNAME", studyName);
            intent.putExtra("ACCESSTOKEN", accessToken);
            startActivity(intent);
        }else if (id == R.id.action_help) {

                Intent intent = new Intent(getApplicationContext(), HelpActivity.class);
                intent.putExtra("IMAGE", "help_studmain");
                startActivity(intent);
                return true;

        }else if (id == R.id.action_view_photo) {

            Intent i = new Intent(StudyMainActivity.this, ImageListViewActivity.class);
            i.putExtra("FOLDER_PATH", ApplicationPath.APP_PATH_IMAGES);
            i.putExtra("STUDYNAME",studyName );
            startActivity(i);
        }else if (id == R.id.action_settings) {

            Intent i = new Intent(StudyMainActivity.this, SettingDataEntryActivity.class);
            i.putExtra("STUDYNAME", studyName);
            i.putExtra("ACCESSTOKEN", accessToken);
            startActivity(i);
        }



        return super.onOptionsItemSelected(item);
    }

    private String getPlotDataToCommit() {

        DatabaseMasterTool dbToolStudy = new DatabaseMasterTool(getApplicationContext(),studyName);
        SQLiteDatabase studyDatabase=dbToolStudy.getStudyDatabase(studyName);
        StudyManager mgrStudy = new StudyManager();
        Cursor plotData=mgrStudy.getPlotDataToCommit(studyDatabase);

        List<PlotDataCommitModel> plotDataList= new ArrayList<PlotDataCommitModel>();

        if(plotData != null && plotData.getCount() > 0){

            if (plotData.moveToFirst()) {
                do {
                    PlotDataCommitModel plot= new PlotDataCommitModel();
                    String plot_key=plotData.getString(plotData.getColumnIndex("plot_key"));
                    int variable_id=plotData.getInt(plotData.getColumnIndex("variable_id"));
                    String value=plotData.getString(plotData.getColumnIndex("value"));
                    plot.setIdentifier_key(plot_key);
                    plot.setVariable_id(variable_id);
                    plot.setValue(value);
                    plot.setRemarks("");
                    plot.setData_unit("plot");
                    plotDataList.add(plot);
                } while (plotData.moveToNext());
            }
        }

        Gson gson = new Gson();

        dbToolStudy.closeDB(studyDatabase);


        return gson.toJson(plotDataList);
    }

    public void actionSync(View v){

        String jsonString=getPlotDataToCommit();
        String postUrl;
        if(is_posted.equals("N")) {
            postUrl = "http://api.breeding4rice.irri.org/dev/v1/datasets?accessToken=" + accessToken;
        }else{
            postUrl = "http://api.breeding4rice.irri.org/dev/v1/datasets/"+transaction_id+"?accessToken=" + accessToken;
        }

        new JSONTaskCommitStudy().execute(postUrl, jsonString);
    }

    public class JSONTaskCommitStudy extends AsyncTask<String,String,String> {

        String studyId;
        private ProgressDialog Dialog = new ProgressDialog(StudyMainActivity.this);


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Dialog.setMessage(" please wait while processing............");
            Dialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            String response=null;
           try{
               RestClient client = new RestClient(params[0]);
               client.AddHeader("Content-type", "application/json");
               client.AddParam("data",params[1]);


               //client.AddHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");

               try {
                   if(is_posted.equals("N")) {
                       client.Execute(RestClient.RequestMethod.POST);
                       response = client.getResponse();
                   }else{
                      client.Execute(RestClient.RequestMethod.PUT);
                       response = client.getResponse();

                   }
               } catch (Exception e) {
                   e.printStackTrace();
               }
               if(client.getResponseCode()==401){
                   return null;
               }
              /* String response = client.getResponse();*/

               return response;
           }catch (Exception e){
               return null;
           }





        }

        protected void onPostExecute(String result){
            super.onPostExecute(result);

            if(result!=null) {
                //Toast.makeText(StudyMainActivity.this, result, Toast.LENGTH_LONG).show();

                Gson gson = new Gson();
                CommitMessage commitMessage = gson.fromJson(result, CommitMessage.class);
                if(commitMessage.isSuccess()) {
                    updateCommitHistory(commitMessage);
                }
                AlertDialog alertDialog = new AlertDialog.Builder(
                        StudyMainActivity.this).create();
                alertDialog.setTitle("Upload Message");
                alertDialog.setMessage(commitMessage.getData().getMessage());
                alertDialog.setIcon(R.drawable.info);
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog closed
                        //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                    }
                });
                Dialog.dismiss();
                alertDialog.show();


                //setResult(RESULT_OK, null);
               // finish();

            }else{
                AlertDialog alertDialog = new AlertDialog.Builder(
                        StudyMainActivity.this).create();
                alertDialog.setTitle("Upload Error Message");
                alertDialog.setMessage("Error uploading plot data. Please check your internet connection");
                alertDialog.setMessage(result);
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

        private void updateCommitHistory(CommitMessage result) {

            try {
                // create new study database
                String transMsg = result.getData().getMessage().toString();
                String[] s = transMsg.split(" ");

                DatabaseMasterTool dbToolStudy = new DatabaseMasterTool(getApplicationContext(), studyName);
                SQLiteDatabase studyDatabase = dbToolStudy.getStudyDatabase(studyName);
                StudyManager mgrStudy = new StudyManager();
                mgrStudy.updatePlotRecordCommited(studyDatabase);
                if (is_posted.equals("N")) {
                    ContentValues cv = new ContentValues();
                    DateUtil cdate = new DateUtil();
                    cv.put("remarks", result.getData().getMessage());
                    int transaction_id = Integer.valueOf(s[s.length - 1]);
                    cv.put("transaction_id", transaction_id);
                    cv.put("date_commit", cdate.getDate());
                    mgrStudy.insertCommitHistory(studyDatabase, cv);
                    dbToolStudy.closeDB(studyDatabase);

                    // update master list study

                    // insert study record to master table
                    DatabaseMasterTool dbTool = new DatabaseMasterTool(getApplicationContext());
                    SQLiteDatabase database = dbTool.getMasterDatabase();
                    StudyManager mgr = new StudyManager();
                    mgr.updateStudyCommitTranscation(database, studyName, transaction_id);
                    isPosted();
                    dbTool.closeDB(database);
                }
                viewNotification();
                }catch(Exception e){

                }

        }
    }





    public class JSONTaskUpdateStudy extends AsyncTask<String,String,String> {

        String studyId;
        private ProgressDialog Dialog = new ProgressDialog(StudyMainActivity.this);


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Dialog.setMessage(" please wait while processing............");
            Dialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            String response=null;
            try{
                RestClient client = new RestClient(params[0]);
                client.AddHeader("Content-type", "application/json");
                client.AddParam("data",params[1]);


                //client.AddHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");

                try {
                    if(is_posted.equals("N")) {
                        client.Execute(RestClient.RequestMethod.POST);
                        response = client.getResponse();
                    }else{
                        client.Execute(RestClient.RequestMethod.PUT);
                        response = client.getResponse();

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(client.getResponseCode()==401){
                    return null;
                }
              /* String response = client.getResponse();*/

                return response;
            }catch (Exception e){
                return null;
            }





        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                // create new study database
                DatabaseMasterTool dbToolStudy = new DatabaseMasterTool(getApplicationContext(), studyName);
                SQLiteDatabase databaseStudy = dbToolStudy.createStudyDatabase(getApplicationContext(),studyName);
                SQLiteDatabase studyDatabase = dbToolStudy.getStudyDatabase(studyName);
                StudyManager mgrStudy = new StudyManager();
                Gson gsonData = new Gson();
                ObservationData observationData = gsonData.fromJson(result, ObservationData.class);
                DateUtil cdate=new DateUtil();
                int recno = 1;
                // save plot data

                List<ObservationData.DataEntity.ItemsEntity> objectsData = observationData.getData().getItems();

                for (ObservationData.DataEntity.ItemsEntity rec : objectsData) {

                    for (ObservationData.DataEntity.ItemsEntity.ObservationsEntity obj : rec.getObservations()) {

                        ContentValues content = new ContentValues();
                        content.put("plot_key", rec.getPLOT_KEY());
                        content.put("abbrev", obj.getAbbrev());
                        content.put("plotno", rec.getPLOTNO());
                        content.put("variable_id", obj.getVariable().getId());
                        content.put("value", obj.getValue());
                        content.put("timestamp", cdate.getDate());
                        content.put("committed", "Y");
                        mgrStudy.insertPlotRecord(studyDatabase, content);



                        boolean isExistRecord=mgrStudy.isExistRecord(studyDatabase,rec.getPLOTNO(),obj.getVariable().getId());
                        if(isExistRecord){

                                content.put("committed","N");
                                mgrStudy.updatePlotRecord(studyDatabase, obj.getValue(), rec.getPLOTNO(), obj.getVariable().getId(), cdate.getDate());

                        }else{
                            content.put("committed","Y");
                            mgrStudy.insertPlotRecord(studyDatabase, content);
                        }


                    }

                    recno++;

                }
                dbToolStudy.closeDB(databaseStudy);
            }catch(Exception  e){

            }

            }


    }

    private int getTotalUncommitedRecord(String studyName) {
        DatabaseMasterTool dbToolStudy = new DatabaseMasterTool(getApplicationContext(),studyName);
        SQLiteDatabase studyDatabase=dbToolStudy.getStudyDatabase(studyName);
        StudyManager mgrStudy = new StudyManager();
        int toreturn=mgrStudy.getPlotRecordUnCommited(studyDatabase);
        dbToolStudy.closeDB(studyDatabase);
        return toreturn;
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewNotification();
    }


    private void isPosted(){
        DatabaseMasterTool dbTool = new DatabaseMasterTool(getApplicationContext());
        SQLiteDatabase database = dbTool.getMasterDatabase();
        StudyManager mgr = new StudyManager();
        Cursor cursor =mgr.getStudy(database, studyName);

        if(cursor != null && cursor.getCount() > 0){

            if (cursor.moveToFirst()) {
                do {
                    is_posted=cursor.getString(cursor.getColumnIndex("is_posted"));
                    transaction_id=cursor.getInt(cursor.getColumnIndex("transaction_id"));
                } while (cursor.moveToNext());
            }
        }

        dbTool.closeDB(database);


    }
}
