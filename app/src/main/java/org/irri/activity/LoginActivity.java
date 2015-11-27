package org.irri.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;

import com.google.gson.Gson;

import org.irri.activity.R;
import org.irri.constant.Authentication;
import org.irri.database.DatabaseHelper;
import org.irri.entity.AccessToken;

import java.io.IOException;

public class LoginActivity extends Activity {
    private int REQUEST_CODE = 0X1;
    private AccessToken accessToken;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //setupDatabase();

    }

    private void setupDatabase() {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        try {
            //dbHelper.createDataBase("master");
            dbHelper.createDataBase("account");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String sql = "select * from variable";
        dbHelper.openDatabase("master");
        SQLiteDatabase db = dbHelper.getDataBase();
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
