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
import android.widget.Toast;

import com.google.gson.Gson;

import org.irri.database.DatabaseMasterTool;
import org.irri.database.StudyManager;
import org.irri.entity.CommitMessage;
import org.irri.entity.ObservationData;
import org.irri.entity.PlotDataCommitModel;
import org.irri.entity.StudyListData;
import org.irri.entity.StudyMetadata;
import org.irri.utility.ConnectionState;
import org.irri.utility.RestClient;

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

public class StudyMainActivity extends AppCompatActivity {

    String studyName;
    String accessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_main);
        Bundle bundle = getIntent().getExtras();
        studyName=bundle.getString("STUDYNAME");
        accessToken = bundle.getString("ACCESSTOKEN");

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
            intent.putExtra("STUDYNAME",studyName);
            startActivity(intent);
            return true;
        }else if(id == R.id.action_trait_measuring){
            Intent intent = new Intent(StudyMainActivity.this, TraitMeasuringActivity.class);
            intent.putExtra("STUDYNAME",studyName);
            startActivity(intent);
        }else if(id == R.id.action_load_variable_set) {
            Intent intent = new Intent(StudyMainActivity.this, GetVariableSetActivity.class);
            intent.putExtra("STUDYNAME",studyName);
            intent.putExtra("ACCESSTOKEN", accessToken);
            startActivity(intent);
        }else if(id == R.id.action_commit_study) {
            String jsonString=getPlotDataToCommit();

            String postUrl="http://api.breeding4rice.irri.org/dev/v1/datasets?accessToken="+accessToken;
            //String urlStringStudy="http://api.breeding4rice.irri.org/v1/studies/"+item.getItemId()+"/metadata?accessToken="+accessToken;
           // String url="http://api.breeding4rice.irri.org/dev/v1/studies/"+item.getItemId()+"/data-collection?accessToken="+accessToken;
            new JSONTaskCommitStudy().execute(postUrl,jsonString);
        }


        return super.onOptionsItemSelected(item);
    }

    private String getPlotDataToCommit() {

        DatabaseMasterTool dbToolStudy = new DatabaseMasterTool(getApplicationContext(),studyName);
        dbToolStudy.openStudyDatabase(studyName);
        SQLiteDatabase studyDatabase=dbToolStudy.getDatabase();
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

           try{
               RestClient client = new RestClient(params[0]);
               client.AddHeader("Content-type","application/json");
               client.AddParam("data",params[1]);
               //client.AddHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");

               try {
                   client.Execute(RestClient.RequestMethod.POST);
               } catch (Exception e) {
                   e.printStackTrace();
               }

               String response = client.getResponse();
              // Toast.makeText(StudyMainActivity.this, response, Toast.LENGTH_LONG).show();
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

                updateCommitHistory(commitMessage);

                AlertDialog alertDialog = new AlertDialog.Builder(
                        StudyMainActivity.this).create();
                alertDialog.setTitle("Commit Message");
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
                alertDialog.setTitle("Error Message");
                //alertDialog.setMessage("Error retrieving plot data");
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
            // create new study database
            DatabaseMasterTool dbToolStudy = new DatabaseMasterTool(getApplicationContext(),studyName);
            dbToolStudy.openStudyDatabase(studyName);
            SQLiteDatabase studyDatabase=dbToolStudy.getDatabase();
            StudyManager mgrStudy = new StudyManager();
            mgrStudy.updatePlotRecordCommited(studyDatabase);
            dbToolStudy.closeDB(studyDatabase);

            // update master list study

            // insert study record to master table
            DatabaseMasterTool dbTool = new DatabaseMasterTool(getApplicationContext());
            SQLiteDatabase database = dbTool.openDBMaster();
            StudyManager mgr = new StudyManager();
            mgr.updateStudyCommitTranscation(database,studyName);
            dbTool.closeDB(database);


            }
    }

}
