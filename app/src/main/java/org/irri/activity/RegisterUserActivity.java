package org.irri.activity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;

import org.irri.database.AccountManager;
import org.irri.database.DatabaseMasterTool;
import org.irri.entity.User;
import org.irri.entity.UserTeam;
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

public class RegisterUserActivity extends AppCompatActivity {

    private String accessToken;
    AsyncHttpClient client;
    User user;
    Gson gson;
    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";
    List<UserTeam> userTeam= new ArrayList<UserTeam>();


    TextView txtUser;
    TextView txtProgram;
    EditText txtUsername;
    EditText txtPassword;
    EditText txtConfirmPassword;
    Button btnSave;
    int userid;
    String name;
    String program;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        Bundle bundle = getIntent().getExtras();
        accessToken=bundle.getString("ACCESS_TOKEN");
        String urlString="http://api.breeding4rice.irri.org/v1/users/teams?accessToken="+accessToken;
        txtUser=(TextView) findViewById(R.id.txtUser);
        txtProgram= (TextView) findViewById(R.id.txtPassword);
        txtUsername= (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtConfirmPassword = (EditText) findViewById(R.id.txtConfirmPassword);
        btnSave =(Button) findViewById(R.id.btnSave);
        new JSONTask().execute(urlString);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    public void actionCancel(View view) {
        finish();
    }

    public void actionSave(View view){

        if(txtPassword.getText().toString().equals(txtConfirmPassword.getText().toString())) {

            try {

                DatabaseMasterTool dbTool = new DatabaseMasterTool(this);
                SQLiteDatabase database = dbTool.getMasterDatabase();
                AccountManager mgr = new AccountManager(database);

                String username=txtUsername.getText().toString();
                String password=txtPassword.getText().toString();

                ContentValues values = new ContentValues();
                values.put("display_name", txtUser.getText().toString());
                values.put("program_abbrev", txtProgram.getText().toString());
                values.put("program",program);
                values.put("username", username);
                values.put("password", password);
                values.put("access_token", accessToken);
                values.put("display_name",name);
                values.put("user_id",userid);

                boolean isExist=mgr.isUserExist(userid);

                System.out.println(userTeam.toString());

                if(!isExist) {
                    mgr.insert(values, database);
                }else{
                    mgr.update(database, username, password, userid,accessToken);
                    mgr.deleteUserTeam(userid,database);
                }

                for(UserTeam ut:userTeam){
                    ContentValues c= new ContentValues();
                    c.put("user_id",ut.getUserid());
                    c.put("program_abbrev",ut.getProgramAbbrev());
                    c.put("program_display_name",ut.getProgramName());
                    mgr.insertUserTeam(c,database);
                }


                Cursor cursor = mgr.getAccountList();


                while (cursor.isAfterLast() == false) {
                    String val = cursor.getString(cursor.getColumnIndex("display_name")) + " " + cursor.getString(cursor.getColumnIndex("program_abbrev"));
                    //Toast.makeText(this, "New account for "+val + " registered", Toast.LENGTH_LONG).show();
                    cursor.moveToNext();
                }
                dbTool.closeDB(database);

                finish();
            } catch (Exception e) {
                Toast.makeText(this, "Error getting user information", Toast.LENGTH_LONG).show();
            }
        }else{
            AlertDialog alertDialog = new AlertDialog.Builder(
                    RegisterUserActivity.this).create();
            alertDialog.setTitle("Error Message");
            alertDialog.setMessage("Password does not match the confirm password");
            alertDialog.setIcon(R.drawable.info);
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write your code here to execute after dialog closed
                    //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                }
            });


            // Showing Alert Message
            alertDialog.show();
            txtConfirmPassword.setText("");
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register_user, menu);

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class JSONTask extends AsyncTask<String,String,String>{


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
            gson = new Gson();
            user = gson.fromJson(result, User.class);
            txtUser = (TextView) findViewById(R.id.txtUser);
            txtProgram = (TextView) findViewById(R.id.txtProgram);
            String programLine="";

            txtUser.setText(user.getData().getDisplay_name());
            try {
                //String program = user.getData().getTeams().get(0).getTeam().getName();

                userid=user.getData().getId();
                name=user.getData().getDisplay_name();
                program=user.getData().getTeams().get(0).getTeam().getProgram().getAbbrev();

                for(User.DataEntity.TeamsEntity rec:user.getData().getTeams()){
                    UserTeam team = new UserTeam();
                    team.setUserid(userid);
                    team.setProgramAbbrev(rec.getTeam().getAbbrev());
                    team.setProgramName(rec.getTeam().getName());
                    userTeam.add(team);
                    programLine=programLine+" "+rec.getTeam().getAbbrev()+"\n";
                }

                txtProgram.setText(programLine);

            }catch (Exception e){
                AlertDialog alertDialog = new AlertDialog.Builder(
                        RegisterUserActivity.this).create();
                alertDialog.setTitle("Error Message");
                alertDialog.setMessage("You don't belong to any program. Not allowed to create offline account");
                alertDialog.setIcon(R.drawable.info);
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog closed
                        //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.show();
                btnSave.setEnabled(false);

            }

        }

    }


}


