package org.irri.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import org.irri.database.DatabaseMasterTool;
import org.irri.database.StudyManager;

import java.util.concurrent.ExecutionException;

public class SettingMainActivity extends AppCompatActivity {

    private int REQUEST_CODE2 = 0X2;

    DatabaseMasterTool dbTool;
    SQLiteDatabase database;
    StudyManager mgr;
    String season="";
    String year="";
    EditText etYear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_main);
        initDatabase();
        populateSettingValues();

        // plot field1 spinner

        initSeasonValue();
        etYear=(EditText) findViewById(R.id.etYear);
        etYear.setText(year);
        etYear.setInputType(InputType.TYPE_CLASS_NUMBER);

    }

    private void initSeasonValue() {
        RadioButton radioWS= (RadioButton) findViewById(R.id.radioButtonWS);
        RadioButton radioDS= (RadioButton) findViewById(R.id.radioButtonDS);

        if(season.equals("Wet")){
            radioWS.setChecked(true);
            radioDS.setChecked(false);
        }else{
            radioWS.setChecked(false);
            radioDS.setChecked(true);
        }

    }


    private void populateSettingValues() {
        Cursor cursorSettings= mgr.getSettingsMaster(database);

        if(cursorSettings != null && cursorSettings.getCount() > 0){

            if (cursorSettings.moveToFirst()) {
                do {
                    try {
                        year = cursorSettings.getString(cursorSettings.getColumnIndex("year"));
                        season = cursorSettings.getString(cursorSettings.getColumnIndex("season"));
                    }catch (Exception e){
                        year="";
                        season="";
                    }
                } while (cursorSettings.moveToNext());
            }
        }

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_plot_order_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    public void initDatabase(){
        dbTool = new DatabaseMasterTool(this);
        database = dbTool.getMasterDatabase();
        mgr = new StudyManager();
    }

    public void actionBtnSave(View v) {
        mgr.updateSettingsMaster(database, etYear.getText().toString(), season);
        setResult(RESULT_OK);
        super.finish();
    }


  @Override
    protected void onDestroy() {
        super.onDestroy();
        dbTool.closeDB(database);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButtonWS:
                if (checked)
                   season="Wet";
                    break;
            case R.id.radioButtonDS:
                if (checked)
                    season="Dry";
                    break;
        }
    }
}
