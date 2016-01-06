package org.irri.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.irri.constant.Authentication;
import org.irri.database.AccountManager;
import org.irri.database.DatabaseStudyHelper;
import org.irri.database.DatabaseMasterTool;
import org.irri.entity.AccessToken;
import org.irri.utility.FileManager;

import java.io.IOException;

public class LoginActivity extends Activity {
    private int REQUEST_CODE = 0X1;
    private AccessToken accessToken;
    private Gson gson;
    private EditText username;
    private EditText password;
    private String token="EzfrfXUCo6Klt92nR7djMDgPck9MvhGcHmauoId6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupAppFolder();
    }

    private void setupAppFolder() {
        FileManager fileManager= new FileManager();
        try {
            fileManager.createAppFolders(getApplicationContext());
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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


    public void onStartOauth(View v) {



        Intent intent = new Intent(this, EasySocialAuthActivity.class);
        intent.putExtra(EasySocialAuthActivity.URL, Authentication.LOGIN_URL);
        intent.putExtra(EasySocialAuthActivity.REDIRECT_URL,Authentication.REDIRECT_URI);
        intent.putExtra(EasySocialAuthActivity.ACCESS_TOKEN, Authentication.ACCESS_TOKEN_URL);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void actionLogin(View v) {

        username = (EditText) findViewById(R.id.txtUsername);
        password = (EditText) findViewById(R.id.txtPassword);
        DatabaseMasterTool dbTool = new DatabaseMasterTool(this);
        dbTool.openDBMaster();
        SQLiteDatabase database = dbTool.getDatabase();
        AccountManager mgr = new AccountManager(database);

        Cursor cursor = mgr.getUserToken(username.getText().toString(),password.getText().toString());

        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            //token = cursor.getString(cursor.getColumnIndex("access_token"));
            Intent intent = new Intent(getApplicationContext(), StudiesActivity.class);
            intent.putExtra("ACCESS_TOKEN", token);
            startActivity(intent);
        }else{
            //Toast.makeText(this, "Invalid User", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), StudiesActivity.class);
            intent.putExtra("ACCESS_TOKEN", token);
            startActivity(intent);
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                String accessTokenString = data.getStringExtra("data");
                gson = new Gson();
                accessToken = gson.fromJson(accessTokenString, AccessToken.class);
                String token=accessToken.getAccess_token();
               // _ResponseShowTestView.setText(token);;
                Intent intent = new Intent(this, RegisterUserActivity.class);
                intent.putExtra("ACCESS_TOKEN",token);
                startActivity(intent);

            }
        } else if (resultCode == RESULT_CANCELED) {
            if (requestCode == REQUEST_CODE) {
                Toast.makeText(this, data.getIntExtra("Error getting access token", 0) + "", Toast.LENGTH_LONG).show();
            }
        }

    }


}
