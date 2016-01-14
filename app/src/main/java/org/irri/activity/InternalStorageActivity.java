package org.irri.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class InternalStorageActivity extends AppCompatActivity {


    private static final String FILE_NAME="myyfile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        final TextView tvData = (TextView) findViewById(R.id.tvData);
        Button btnLoadInternal = (Button) findViewById(R.id.btnLoadPreferences);
        Button btnSaveInternal = (Button) findViewById(R.id.btnSaveInternal);
        final EditText etData= (EditText) findViewById(R.id.etData);


        btnLoadInternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

/*                try {
                   // String data=FileOperationsHelper.getInstance().readFile(getApplicationContext(),FILE_NAME);
                    tvData.setText(data);

                } catch (IOException e) {
                    e.printStackTrace();
                }*/


            }
        });


        btnSaveInternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

/*
                String dataToSave= etData.getText().toString();
                try {
                   // FileOperationsHelper.getInstance().saveFile(getApplicationContext(),FILE_NAME,dataToSave);
                } catch (IOException e) {
                    e.printStackTrace();
                }
*/


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_internal_storage, menu);
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
