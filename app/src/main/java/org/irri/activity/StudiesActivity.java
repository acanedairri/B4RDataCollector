package org.irri.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;

import org.irri.entity.User;
import org.json.JSONObject;

import java.io.InputStream;

public class StudiesActivity extends AppCompatActivity {

    private String accessToken;
    AsyncHttpClient client;
    User user;
    Gson gson;
    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studies);
        Bundle bundle = getIntent().getExtras();
        accessToken=bundle.getString("ACCESS_TOKEN");

        TextView txt = (TextView) findViewById(R.id.txtAccessToken);
        txt.setText(accessToken);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_loadstudy) {
            Intent intent = new Intent(getApplicationContext(), StudyListActivity.class);
            intent.putExtra("ACCESS_TOKEN", accessToken);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
