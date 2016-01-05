package org.irri.activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;

import org.irri.database.AccountManager;
import org.irri.database.DatabaseMasterTool;
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

public class RegisterUserActivity extends AppCompatActivity {

    private String accessToken;
    AsyncHttpClient client;
    User user;
    Gson gson;
    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";


    TextView txtUser;
    TextView txtProgram;
    EditText txtUsername;
    EditText txtPassword;
    EditText txtConfirmPassword;

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
        new JSONTask().execute(urlString);

    }

    public void actionCancel(View view) {
        finish();
    }

    public void actionSave(View view){

        try {

            DatabaseMasterTool dbTool = new DatabaseMasterTool(this);
            dbTool.openDBMaster();
            SQLiteDatabase database = dbTool.getDatabase();
            AccountManager mgr = new AccountManager(database);

            ContentValues values = new ContentValues();
            values.put("display_name", txtUser.getText().toString());
            values.put("program_abbrev", txtProgram.getText().toString());
            values.put("username", txtUsername.getText().toString());
            values.put("password", txtPassword.getText().toString());
            values.put("access_token", accessToken);

            mgr.insert(values);

            Cursor cursor = mgr.getAccountList();


            while (cursor.isAfterLast() == false) {
                String val = cursor.getString(cursor.getColumnIndex("display_name")) + " " + cursor.getString(cursor.getColumnIndex("program_abbrev"));
                Toast.makeText(this, val, Toast.LENGTH_LONG).show();
                cursor.moveToNext();
            }

        }catch (Exception e){
            Toast.makeText(this, "Error getting user information", Toast.LENGTH_LONG).show();
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

            txtUser.setText(user.getData().getDisplay_name());
            txtProgram.setText(user.getData().getTeams().get(0).getTeam().getName());
        }

    }


}


