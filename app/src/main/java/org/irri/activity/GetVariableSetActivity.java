package org.irri.activity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.irri.activity.R;
import org.irri.database.DatabaseMasterTool;
import org.irri.database.StudyManager;
import org.irri.entity.MockData;
import org.irri.entity.ObservationData;
import org.irri.entity.Study;
import org.irri.entity.StudyListModel;
import org.irri.entity.StudyMetadata;
import org.irri.entity.VariableSet;
import org.irri.entity.VariableSetMember;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class GetVariableSetActivity extends AppCompatActivity {

    private String accessToken;
    String studyName;
    Spinner spinnerVariableSet;
    ArrayAdapter<CharSequence> adapterVariableSet;
    String[] spinnerArray;
    HashMap<Integer,Integer> spinnerMap;
    ListView lv;
    int variableSetId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_variable_set);

        Bundle bundle = getIntent().getExtras();
        studyName=bundle.getString("STUDYNAME");
        accessToken=bundle.getString("ACCESSTOKEN");

        populateVariableSet();

    }

    private void populateVariableSet() {

            // TODO: 2015-12-08
        String urlStringStudy="http://api.breeding4rice.irri.org/dev/v1/variable-sets?accessToken="+accessToken;
        new JSONTaskGetVariableSet().execute(urlStringStudy);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_get_variable_set, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void  actionBtnAdd(View v){

        TextView tvVariableSetid= (TextView) findViewById(R.id.tvVariableSetId);
        String variableSetId=tvVariableSetid.getText().toString();
/*        Context context = getApplicationContext();
        CharSequence text = String.valueOf(variableSetId);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();*/

        String urlStringStudy="http://api.breeding4rice.irri.org/dev/v1/variable-sets/"+Integer.valueOf(variableSetId)+"/members?accessToken="+accessToken;
        new JSONTaskGetVariableSetMembers().execute(urlStringStudy);

    }


    public void actionBtnSaveVariable(View v){
        TextView tv= (TextView) findViewById(R.id.tvVariableMembers);
        String variableMembers= tv.getText().toString();
        Context context = getApplicationContext();
        CharSequence text = String.valueOf(variableSetId);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, variableMembers, duration);
        toast.show();
    }

    public class JSONTaskGetVariableSet extends AsyncTask<String,String,String> {

        String studyId;
        int variableSetId;
        String[] spinnerArray;
        HashMap<Integer,Integer> spinnerMap;
        Spinner spinnerVariableSet;
        ArrayAdapter<CharSequence> adapterVariableSet;

        public JSONTaskGetVariableSet() {

        }



        @Override
        protected String doInBackground(String... params) {

            HttpURLConnection con = null;
            BufferedReader reader = null;
            BufferedReader readerData = null;
            String toreturn = null;


            try {

                //get study metadata
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

                toreturn=buffer.toString();
                return toreturn;

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
            Gson gson = new Gson();
            VariableSet variableSet = gson.fromJson(result,VariableSet.class);
            int i=0;
            spinnerArray=new String[variableSet.getData().getItems().size()];
            spinnerMap = new HashMap<Integer, Integer>();
            for(VariableSet.DataEntity.ItemsEntity rec:variableSet.getData().getItems()){
                spinnerMap.put(i, rec.getId());
                spinnerArray[i] = rec.getAbbrev();
                i++;

            }

            spinnerVariableSet = (Spinner) findViewById(R.id.spinnerVariableSet);
            adapterVariableSet = new ArrayAdapter<CharSequence>(GetVariableSetActivity.this,android.R.layout.simple_spinner_item, spinnerArray);
            // ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_plot_field, android.R.layout.simple_spinner_item);
            adapterVariableSet.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerVariableSet.setAdapter(adapterVariableSet);
            spinnerVariableSet.setSelection(0);

            spinnerVariableSet.setOnItemSelectedListener(
                    new AdapterView.OnItemSelectedListener() {
                        public void onItemSelected(
                                AdapterView<?> parent, View view, int position, long id) {
                            try {
                                variableSetId = spinnerMap.get(position);
                                TextView tvVariableSetid= (TextView) findViewById(R.id.tvVariableSetId);
                                tvVariableSetid.setText(String.valueOf(variableSetId));
 ;
                            } catch (Exception e) {

                            }
                        }


                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

        }

    }


    public class JSONTaskGetVariableSetMembers extends AsyncTask<String,String,String> {

        String studyId;
        int variableSetId;


        @Override
        protected String doInBackground(String... params) {

            HttpURLConnection con = null;
            BufferedReader reader = null;
            BufferedReader readerData = null;
            String toreturn = null;


            try {

                //get study metadata
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

                toreturn=buffer.toString();
                return toreturn;

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
            Gson gson = new Gson();
            VariableSetMember variableSetMember = gson.fromJson(result,VariableSetMember.class);
            ListView lv = (ListView) findViewById(R.id.lvVariableSetMember);
            VariableSetMemberListAdapter adapter = new VariableSetMemberListAdapter(getApplicationContext(),R.layout.activity_variable_member_list_row,variableSetMember.getData().getMembers());
            lv.setAdapter(adapter);
            Button btnSaveMember = (Button) findViewById(R.id.btnSaveVariable);
            btnSaveMember.setVisibility(View.VISIBLE);

            TextView tvVariableMembers= (TextView)findViewById(R.id.tvVariableMembers);
            tvVariableMembers.setText(result);
        }

    }

    public class VariableSetMemberListAdapter extends ArrayAdapter{

        public List<VariableSetMember.DataEntity.MembersEntity> variableSetMemberEntity;
        private int resource;
        private LayoutInflater inflater;


        public VariableSetMemberListAdapter(Context context, int resource,List<VariableSetMember.DataEntity.MembersEntity> objects) {
            super(context, resource, objects);
            variableSetMemberEntity=objects;
            this.resource=resource;
            inflater=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView==null){
                convertView = inflater.inflate(resource,null);
            }

            TextView tvAbbrev = (TextView) convertView.findViewById(R.id.tvAbbrev);
            tvAbbrev.setText(variableSetMemberEntity.get(position).getAbbrev());

            TextView tvDisplayName = (TextView) convertView.findViewById(R.id.tvVariableDisplayName);
            tvDisplayName.setText(variableSetMemberEntity.get(position).getDisplay_name());

            return convertView;
        }
    }
}
