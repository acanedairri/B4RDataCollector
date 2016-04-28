package org.irri.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.irri.entity.MockData;
import org.irri.entity.Variable;

import java.util.List;

import cz.msebera.android.httpclient.Header;

public class VariableActivity extends AppCompatActivity {

    String urlResourceVariable="https://api.breeding4rice.irri.org/v1/variables?accessToken=00a8c82d46cf9f0745d5406478032d1234344";
    Variable responseObj;
    Gson gson;
    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final MockData mockData = new MockData();
        client = new AsyncHttpClient();
        client.get(VariableActivity.this, urlResourceVariable, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    String responseString=new String(responseBody);
                    gson = new Gson();
                    //responseObj = gson.fromJson(responseString, Variable.class);
                     responseObj=gson.fromJson(mockData.getVariable(), Variable.class);
                    List<Variable.DataEntity.ItemsEntity> list=responseObj.getData().getItems();
                    for(Variable.DataEntity.ItemsEntity rec:list){
                        System.out.println(rec.getAbbrev());
                    }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });





        setContentView(R.layout.activity_variable);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_variable, menu);
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
}
