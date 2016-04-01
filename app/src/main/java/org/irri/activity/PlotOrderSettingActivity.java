package org.irri.activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.irri.activity.R;
import org.irri.database.DatabaseMasterTool;
import org.irri.database.StudyManager;

public class PlotOrderSettingActivity extends AppCompatActivity {

    private int REQUEST_CODE2 = 0X2;
    String studyName;

    Spinner spinnerPlotField1;
    Spinner spinnerPlotField2;
    Spinner spinnerPlotField3;
    Spinner spinnerPlotField4;

    ArrayAdapter<CharSequence> adapterPlotField1;
    ArrayAdapter<CharSequence> adapterPlotField2;
    ArrayAdapter<CharSequence> adapterPlotField3;
    ArrayAdapter<CharSequence> adapterPlotField4;

    String dataField1;
    String dataField2;
    String dataField3;
    String dataField4;

    DatabaseMasterTool dbTool;
    SQLiteDatabase database;
    StudyManager studyMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plot_order_setting);

        Bundle bundle = getIntent().getExtras();
        studyName=bundle.getString("STUDYNAME");

        initDatabase();
        populateSettingValues();

        // plot field1 spinner
        spinnerPlotField1 = (Spinner) findViewById(R.id.spinnerPlotField1);
        adapterPlotField1 = ArrayAdapter.createFromResource(this,
                R.array.spinner_plot_field2, R.layout.spinner_layout);

        adapterPlotField1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPlotField1.setAdapter(adapterPlotField1);

        spinnerPlotField1.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        String value=spinnerPlotField1.getSelectedItem().toString();
                        dataField1=value;

                    }


                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


        // plot field2 spinner
        spinnerPlotField2 = (Spinner) findViewById(R.id.spinnerPlotField2);
        adapterPlotField2 = ArrayAdapter.createFromResource(this,
                R.array.spinner_plot_field2, R.layout.spinner_layout);

        adapterPlotField2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPlotField2.setAdapter(adapterPlotField2);

        spinnerPlotField2.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        String value = spinnerPlotField2.getSelectedItem().toString();
                        dataField2 = value;

                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

        // plot field3 spinner
        spinnerPlotField3 = (Spinner) findViewById(R.id.spinnerPlotField3);
        adapterPlotField3 = ArrayAdapter.createFromResource(this,
                R.array.spinner_plot_field, R.layout.spinner_layout);

        adapterPlotField3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPlotField3.setAdapter(adapterPlotField3);

        spinnerPlotField3.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        String value = spinnerPlotField3.getSelectedItem().toString();
                        dataField3 = value;

                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


        // plot field4 spinner
        spinnerPlotField4 = (Spinner) findViewById(R.id.spinnerPlotField4);
        adapterPlotField4 = ArrayAdapter.createFromResource(this,
                R.array.spinner_plot_field, R.layout.spinner_layout);

        adapterPlotField4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPlotField4.setAdapter(adapterPlotField3);

        spinnerPlotField4.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        String value = spinnerPlotField4.getSelectedItem().toString();
                        dataField4 = value;

                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

        initSpinnerValues();

    }

    private void populateSettingValues() {
        Cursor cursorSettings= studyMgr.getSettings(database);

        if(cursorSettings != null && cursorSettings.getCount() > 0){

            if (cursorSettings.moveToFirst()) {
                do {
                    dataField1=cursorSettings.getString(cursorSettings.getColumnIndex("datafield1"));
                    dataField2=cursorSettings.getString(cursorSettings.getColumnIndex("datafield2"));
                    dataField3=cursorSettings.getString(cursorSettings.getColumnIndex("datafield3"));
                    dataField4=cursorSettings.getString(cursorSettings.getColumnIndex("datafield4"));

                } while (cursorSettings.moveToNext());
            }
        }

    }

    private void initSpinnerValues() {

        int dataField1Position= adapterPlotField1.getPosition(dataField1);
        spinnerPlotField1.setSelection(dataField1Position);


        int dataField2Position= adapterPlotField2.getPosition(dataField2);
        spinnerPlotField2.setSelection(dataField2Position);

        int dataField3Position= adapterPlotField2.getPosition(dataField3);
        spinnerPlotField3.setSelection(dataField3Position);

        int dataField4Position= adapterPlotField2.getPosition(dataField4);
        spinnerPlotField4.setSelection(dataField4Position);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initDatabase(){
        dbTool = new DatabaseMasterTool(this,studyName);
        database = dbTool.getStudyDatabase(studyName);
        studyMgr = new StudyManager();
    }

    public void actionBtnSave(View v) {
        studyMgr.updateSettingsDataField(database,dataField1,dataField2,dataField3, dataField4);
        setResult(RESULT_OK);
        super.finish();
    }


  @Override
    protected void onDestroy() {
        super.onDestroy();
        dbTool.closeDB(database);
    }
}
