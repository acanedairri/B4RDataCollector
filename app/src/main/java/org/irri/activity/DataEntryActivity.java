package org.irri.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.intermec.aidc.AidcManager;
import com.intermec.aidc.BarcodeReadEvent;
import com.intermec.aidc.BarcodeReadListener;
import com.intermec.aidc.BarcodeReaderException;
import com.intermec.aidc.VirtualWedge;
import com.intermec.aidc.VirtualWedgeException;

import org.irri.database.DatabaseMasterTool;
import org.irri.database.StudyManager;
import org.irri.entity.AccessToken;
import org.irri.entity.PlotData;
import org.irri.entity.ScaleValue;
import org.irri.entity.StudyListData;
import org.irri.entity.TraitMeasuring;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import com.intermec.aidc.*;

public class DataEntryActivity extends AppCompatActivity implements BarcodeReadListener,AdapterView.OnItemClickListener, View.OnClickListener {

    private String studyName;
    private int REQUEST_CODE = 0X1;

    private ImageView btnPlotPrev;
    private ImageView btnPlotNext;
    private ImageView btnTraitPrev;
    private ImageView btnTraitNext;
    private ImageButton btnScale;
    private ImageButton btnDate;
    private ImageButton btnClear;
    private TableRow tblRowSearch;

    private int plotIndex=1;
    private int traitIndex=0;

    private EditText etSearchPlot;

    private EditText etDesignation;
    private EditText etTrait;
    private EditText etValue;

    private TextView tvTraitLabel;
    private String currentTrait;

    private ArrayList<PlotData> plotData;
    private ArrayList<TraitMeasuring> traitMeasuring;

    private static com.intermec.aidc.VirtualWedge wedge;
    private static com.intermec.aidc.BarcodeReader bcr;
    public Cursor plotCursor;
    DatabaseMasterTool dbTool;
    SQLiteDatabase database;
    StudyManager studyMgr;

    Spinner spinnerPlotField1;
    Spinner spinnerPlotField2;
    Spinner spinnerPlotField3;
    Spinner spinnerPlotField4;

    ArrayAdapter<CharSequence> adapterPlotField1;
    ArrayAdapter<CharSequence> adapterPlotField2;
    ArrayAdapter<CharSequence> adapterPlotField3;
    ArrayAdapter<CharSequence> adapterPlotField4;

    TextView tvPlotField1;
    TextView tvPlotField2;
    TextView tvPlotField3;
    TextView tvPlotField4;

    String dataField1;
    String dataField2;
    String dataField3;
    String dataField4;

    private ListView lvScale;
    private ScaleListAdapter scaleAdapter;
    private List<ScaleValue> scaleValueList;
    int searchFlag=0;


    public DataEntryActivity(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        Bundle bundle = getIntent().getExtras();
        studyName=bundle.getString("STUDYNAME");
       // initdatabase

        initDatabase();

        populateSettingValues();
        traitMeasuring= new ArrayList<TraitMeasuring>();

        lvScale=(ListView) findViewById(R.id.lvScale);
        scaleValueList= new ArrayList<ScaleValue>();
        lvScale.setOnItemClickListener(this);

        btnPlotPrev= (ImageView) findViewById(R.id.btnPlotPrev);
        btnPlotNext=(ImageView) findViewById(R.id.btnPlotNext);;
        btnTraitPrev=(ImageView) findViewById(R.id.btnTraitPrev);;
        btnTraitNext=(ImageView) findViewById(R.id.btnTraitNext);;
        btnScale=(ImageButton) findViewById(R.id.btnScale);
        btnScale.setVisibility(View.GONE);
        btnDate=(ImageButton) findViewById(R.id.btnDate);
        btnDate.setVisibility(View.GONE);

        btnClear=(ImageButton) findViewById(R.id.btnClear);



        etSearchPlot = (EditText) findViewById(R.id.etSearchPlot);
        etTrait = (EditText) findViewById(R.id.etTrait);
        etValue = (EditText) findViewById(R.id.etValue);
        tvTraitLabel = (TextView) findViewById(R.id.tvTraitLabel);

        tblRowSearch = (TableRow) findViewById(R.id.tblRowSearch);
        tblRowSearch.setVisibility(View.GONE);

        dbTool = new DatabaseMasterTool(this,studyName);
        dbTool.openStudyDatabase(studyName);
        database = dbTool.getDatabase();
        studyMgr = new StudyManager();

        // plot field1 spinner
        spinnerPlotField1 = (Spinner) findViewById(R.id.spinner_plot_field1);
        adapterPlotField1 = ArrayAdapter.createFromResource(this,
                R.array.spinner_plot_field, android.R.layout.simple_spinner_item);

        adapterPlotField1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPlotField1.setAdapter(adapterPlotField1);

        spinnerPlotField1.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        String value=spinnerPlotField1.getSelectedItem().toString();
                        dataField1=value;
                        updateSettingDataField("datafield1",value);
                        setPlotRecordDisplay(plotIndex);
                    }


                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


        // plot field2 spinner
        spinnerPlotField2 = (Spinner) findViewById(R.id.spinner_plot_field2);
        adapterPlotField2 = ArrayAdapter.createFromResource(this,
                R.array.spinner_plot_field, android.R.layout.simple_spinner_item);

        adapterPlotField2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPlotField2.setAdapter(adapterPlotField2);

        spinnerPlotField2.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        String value = spinnerPlotField2.getSelectedItem().toString();
                        dataField2 = value;
                        updateSettingDataField("datafield2",value);
                        setPlotRecordDisplay(plotIndex);
                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

        // plot field3 spinner
        spinnerPlotField3 = (Spinner) findViewById(R.id.spinner_plot_field3);
        adapterPlotField3 = ArrayAdapter.createFromResource(this,
                R.array.spinner_plot_field, android.R.layout.simple_spinner_item);

        adapterPlotField3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPlotField3.setAdapter(adapterPlotField3);

        spinnerPlotField3.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        String value = spinnerPlotField3.getSelectedItem().toString();
                        dataField3 = value;
                        updateSettingDataField("datafield3",value);
                        setPlotRecordDisplay(plotIndex);
                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


        // plot field4 spinner
        spinnerPlotField4 = (Spinner) findViewById(R.id.spinner_plot_field4);
        adapterPlotField4 = ArrayAdapter.createFromResource(this,
                R.array.spinner_plot_field, android.R.layout.simple_spinner_item);

        adapterPlotField4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPlotField4.setAdapter(adapterPlotField3);

        spinnerPlotField4.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        String value = spinnerPlotField4.getSelectedItem().toString();
                        dataField4 = value;
                        updateSettingDataField("datafield4",value);
                        setPlotRecordDisplay(plotIndex);
                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

        tvPlotField1 = (TextView) findViewById(R.id.tvPlotField1);
        tvPlotField2 = (TextView) findViewById(R.id.tvPlotField2);
        tvPlotField3 = (TextView) findViewById(R.id.tvPlotField3);
        tvPlotField4 = (TextView) findViewById(R.id.tvPlotField4);

        getTraitToMeasure();
        setPlotRecordDisplay(plotIndex);
        setTraitRecordDisplay();

        AidcManager.connectService(this, new AidcManager.IServiceListener() {
            public void onConnect() {

                // The depended service is connected and it is ready
                // to receive bar code requests and virtual wedge
                try {
                    //Initial bar code reader instance
                    bcr = new BarcodeReader();
                    bcr.setScannerEnable(true);
                    bcr.addBarcodeReadListener(DataEntryActivity.this);
                    //disable virtual wedge
                    wedge = new VirtualWedge();
                    wedge.setEnable(false);

                } catch (BarcodeReaderException e) {
                    e.printStackTrace();
                } catch (VirtualWedgeException e) {
                    e.printStackTrace();
                }

                //set action for other activities

            }

            public void onDisconnect() {
                //add disconnect message/action here
            }

        });

        try {
            //get bar code instance from MainActivity
            bcr =DataEntryActivity.getBarcodeObject();// SettingBarcodeActivity.getBarcodeObject();

            if(bcr != null)
            {
                //enable scanner
                bcr.setScannerEnable(true);

                //set listener
                bcr.addBarcodeReadListener(this);

            }

        } catch (BarcodeReaderException e) {
            e.printStackTrace();
        }

    }

    private void initDatabase() {
        dbTool = new DatabaseMasterTool(this,studyName);
        dbTool.openStudyDatabase(studyName);
        database = dbTool.getDatabase();
        studyMgr = new StudyManager();
    }

    private void updateSettingDataField(String field,String value) {
        studyMgr.updateSettingsDataField(database, field, value);
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
        dbTool.closeDB(database);

    }

    static BarcodeReader getBarcodeObject()
    {
        return bcr;
    }



    public void getTraitToMeasure() {

        traitMeasuring.clear();
        Cursor cursorTrait=studyMgr.getVariableSetSelected(database);

        if(cursorTrait != null && cursorTrait.getCount() > 0){

            if (cursorTrait.moveToFirst()) {
                do {
                    String abbrev=cursorTrait.getString(cursorTrait.getColumnIndex("abbrev"));
                    String displayName=cursorTrait.getString(cursorTrait.getColumnIndex("display_name"));
                    String dataType=cursorTrait.getString(cursorTrait.getColumnIndex("data_type"));
                    String scaleValue=cursorTrait.getString(cursorTrait.getColumnIndex("scale_value"));

                    TraitMeasuring trait= new TraitMeasuring();
                    trait.setAbbrev(abbrev);
                    trait.setDisplay_name(displayName);
                    trait.setDataType(dataType);
                    trait.setScaleValue(scaleValue);
                    traitMeasuring.add(trait);

                } while (cursorTrait.moveToNext());
            }
        }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_data_entry, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.action_trait_measuring){
            Intent intent = new Intent(DataEntryActivity.this, TraitMeasuringActivity.class);
            intent.putExtra("STUDYNAME",studyName);
            startActivityForResult(intent, REQUEST_CODE);
        }else if(id==R.id.action_search){
            if(searchFlag==0) {
                tblRowSearch.setVisibility(View.VISIBLE);
                item.setIcon(R.drawable.search_minus);
                searchFlag=1;

            }else{
                item.setIcon(R.drawable.search);
                tblRowSearch.setVisibility(View.GONE);
                searchFlag=0;
            }
            etSearchPlot.requestFocus();
        }
        else if(id==R.id.action_summary){
            showDialog(1);
        }

        return super.onOptionsItemSelected(item);
    }

    public void searchPlotRecord(View v) {
        setPlotRecordDisplay(Integer.valueOf(etSearchPlot.getText().toString()));
    }


    public void actionBtnPlotPrev(View v) {

        plotIndex--;
        setPlotRecordDisplay(plotIndex);
    }

    public void actionBtnPlotNext(View v) {
        plotIndex++;
        setPlotRecordDisplay(plotIndex);

    }

    public void actionBtnTraitPrev(View v) {
        if(traitMeasuring.size() > 0) {
            if (traitIndex == 0) {
                traitIndex = 0;
            } else {
                traitIndex--;
            }
            saveTrait();
            setTraitRecordDisplay();
            setHelperBtn();
        }
    }

    public void actionBtnTraitNext(View v) {

        if(traitMeasuring.size() > 0) {
            if (traitIndex == traitMeasuring.size() - 1) {
                traitIndex = 0;
            } else {
                traitIndex++;
            }
            saveTrait();
            setTraitRecordDisplay();
            setHelperBtn();
        }

    }

    public void actionBtnClear(View v) {
        etValue.setText("");
    }

    public void actionBtnSearchHide(View v) {
        tblRowSearch.setVisibility(View.GONE);
    }


    public void saveTrait() {

/*        traitMeasuring.get(traitIndex).setValue(etValue.getText().toString());
        String s= traitMeasuring.get(traitIndex).getValue();
        int y;*/
    }


    public void setHelperBtn() {

        if(traitMeasuring.get(traitIndex).getScaleValue().length()> 0){
            btnScale.setVisibility(View.VISIBLE);
        }else{
            btnScale.setVisibility(View.GONE);
        }

        if(traitMeasuring.get(traitIndex).getDataType().equals("date")){
            btnDate.setVisibility(View.VISIBLE);
        }else{
            btnDate.setVisibility(View.GONE);
        }

        if(traitMeasuring.get(traitIndex).getDataType().equals("integer")){
            etValue.setInputType(InputType.TYPE_CLASS_NUMBER);
        }
        if(traitMeasuring.get(traitIndex).getDataType().equals("float")){
            etValue.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        }
    }



    public void setTraitRecordDisplay() {

        if(traitMeasuring.size() > 0) {

            etTrait.setText(traitMeasuring.get(traitIndex).getAbbrev());
            tvTraitLabel.setText(traitMeasuring.get(traitIndex).getDisplay_name());
            etValue.setText(traitMeasuring.get(traitIndex).getValue());
            setHelperBtn();
            etValue.requestFocus();
            currentTrait = traitMeasuring.get(traitIndex).getAbbrev();
            scaleValueList.clear();

            if(!traitMeasuring.get(traitIndex).getScaleValue().equals("null")){
                String[] scale=traitMeasuring.get(traitIndex).getScaleValue().split(",");
                for(int i=0;i <scale.length ; i++){
                    ScaleValue sv= new ScaleValue();
                    sv.setLabel(scale[i]);
                    String[] val=scale[i].split("=");
                    sv.setValue(val[0]);
                    scaleValueList.add(sv);
                }

                scaleAdapter = new ScaleListAdapter(getApplicationContext(),R.layout.activity_scale_row,scaleValueList);
                lvScale.setAdapter(scaleAdapter);

            }else{
                scaleAdapter = new ScaleListAdapter(getApplicationContext(),R.layout.activity_scale_row,scaleValueList);
                lvScale.setAdapter(scaleAdapter);

            }


        }
    }



    public void actionBtnScale(View v) {
        showDialog(0);
    }

    public void actionBtnDate(View v) {

        DatePickerFragment newFragment;
        int month = 0;
        int year = 2017;
        int day = 15;

        if (month > 0) {
            newFragment = new DatePickerFragment(month, year, day);
        } else {
            final Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);
            newFragment = new DatePickerFragment(month, year, day);
        }
        newFragment.show(getFragmentManager(), "datePicker");

    }


    /*
    Display Scale Value
     */

     protected Dialog onCreateDialog(int id) {

        AlertDialog dialog = null;
        switch (id) {
            case 0:
                String scoring = "1=a\n2=b";
                final String[] items = scoring.split("\n");
                String traitcode = currentTrait;
                return new AlertDialog.Builder(this)
                        .setIcon(R.drawable.info)
                        .setTitle(currentTrait + " Scale Value")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int item) {
                                EditText editText = (EditText) findViewById(R.id.etValue);
                                editText.setText(items[item].split("=")[0].trim());
                                editText.requestFocus();

                            }
                        })
                        .create();
            case 1:

                final String[] plotmeta = getPlotMetadata().split("\n");
                return new AlertDialog.Builder(this)
                        .setIcon(R.drawable.info)
                        .setTitle("Plot Metadata")
                        .setItems(plotmeta, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int item) {

                            }
                        })
                        .create();
        }
        return dialog;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ScaleValue scale = (ScaleValue) scaleAdapter.getItem(position);
        etValue.setText(scale.getValue());
    }

    @Override
    public void onClick(View v) {

    }



    /*
    Date Picker Class
     */

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {


        int year;
        int month;
        int day;
        public DatePickerFragment(int month,int year,int day) {
            this.year=year;
            this.month=month;
            this.day=day;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            ((EditText) getActivity().findViewById(R.id.etValue)).setText(year+"/"+month+1+"/"+day);
        }
    }

    @Override
    public void barcodeRead(BarcodeReadEvent abarcodeReadEvent) {

        String[] barcodeData= abarcodeReadEvent.getBarcodeData().split(";");
        final String plotNo=barcodeData[barcodeData.length-1];
        //etSearchPlot.setText(String.valueOf(plotNo));
       // etSearchPlot.requestFocus();
        searchPlot(plotNo);
        Handler refresh = new Handler(Looper.getMainLooper());
        refresh.post(new Runnable() {
            public void run() {
                int index=0;
                for(PlotData r:plotData){
                    int p= r.getPlotNo();
                    int p1=Integer.valueOf(plotNo);

                    if(p==p1){
                        plotIndex=index;
                        break;
                    }
                    index++;
                }
                setPlotRecordDisplay(plotIndex);
            }
        });
    }

    public void searchPlot(String plotNo){
        /*int index=0;
        for(PlotData r:plotData){
            int p= r.getPlotNo();
            int p1=Integer.valueOf(plotNo);

            if(p==p1){
                plotIndex=index;
                break;
            }
            index++;
        }*/
        setPlotRecordDisplay(plotIndex);


    }


    public  void setPlotRecordDisplay(int plotno) {

        int dataField1Position= adapterPlotField1.getPosition(dataField1);
        spinnerPlotField1.setSelection(dataField1Position);


        int dataField2Position= adapterPlotField2.getPosition(dataField2);
        spinnerPlotField2.setSelection(dataField2Position);

        int dataField3Position= adapterPlotField2.getPosition(dataField3);
        spinnerPlotField3.setSelection(dataField3Position);

        int dataField4Position= adapterPlotField2.getPosition(dataField4);
        spinnerPlotField4.setSelection(dataField4Position);


        plotCursor = studyMgr.getPlotRecords(database,plotno);

        if(plotCursor != null && plotCursor.getCount() > 0){

            if (plotCursor.moveToFirst()) {
                do {
                    tvPlotField1.setText(plotCursor.getString(plotCursor.getColumnIndex(dataField1)));
                    tvPlotField2.setText(plotCursor.getString(plotCursor.getColumnIndex(dataField2)));
                    tvPlotField3.setText(plotCursor.getString(plotCursor.getColumnIndex(dataField3)));
                    tvPlotField4.setText(plotCursor.getString(plotCursor.getColumnIndex(dataField4)));
                } while (plotCursor.moveToNext());
            }
        }

        etValue.requestFocus();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                getTraitToMeasure();
                setTraitRecordDisplay();
            }
        } else if (resultCode == RESULT_CANCELED) {
            if (requestCode == REQUEST_CODE) {

            }
        }

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

        try
        {
            if(wedge != null)
            {
                wedge.setEnable(true);
                wedge = null;
            }

            if(bcr != null)
            {
                bcr.close();
                bcr = null;
            }

        } catch (VirtualWedgeException e) {
            e.printStackTrace();
        }

        //disconnect from data collection service
        AidcManager.disconnectService();
        dbTool.closeDB(database);
    }

    private  String getPlotMetadata() {
        String data="";

        plotCursor = studyMgr.getPlotRecords(database, plotIndex);

        if(plotCursor != null && plotCursor.getCount() > 0){

            if (plotCursor.moveToFirst()) {
                do {
                    data+="Plot key : "+plotCursor.getString(plotCursor.getColumnIndex("plot_key"))+"\n";
                    data+="Rep : "+plotCursor.getString(plotCursor.getColumnIndex("rep"))+"\n";
                    data+="Code : "+plotCursor.getString(plotCursor.getColumnIndex("code"))+"\n";
                    data+="QR Code : "+plotCursor.getString(plotCursor.getColumnIndex("qr_code"))+"\n";
                    data+="Plot No : "+plotCursor.getString(plotCursor.getColumnIndex("plotno"))+"\n";
                    data+="Entry No : "+plotCursor.getString(plotCursor.getColumnIndex("entno"))+"\n";
                    data+="Entry Code : "+plotCursor.getString(plotCursor.getColumnIndex("entcode"))+"\n";
                    data+="Designation : "+plotCursor.getString(plotCursor.getColumnIndex("designation"))+"\n";
                    data+="Parentage : "+plotCursor.getString(plotCursor.getColumnIndex("parentage"))+"\n";
                    data+="Generation : "+plotCursor.getString(plotCursor.getColumnIndex("generation"))+"\n";
                    data+="Field Row : "+plotCursor.getString(plotCursor.getColumnIndex("fldrow_cont"))+"\n";
                    data+="Field Column : "+plotCursor.getString(plotCursor.getColumnIndex("fldcol_cont"))+"\n";

                } while (plotCursor.moveToNext());
            }
        }

return data;
    }

    public class ScaleListAdapter extends ArrayAdapter {

        public List<ScaleValue> scaleList;
        private int resource;
        private LayoutInflater inflater;


        public ScaleListAdapter(Context context, int resource,  List<ScaleValue> objects) {
            super(context, resource, objects);
            scaleList=objects;
            this.resource=resource;
            inflater=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView==null){
                convertView = inflater.inflate(resource,null);
            }
            TextView tvScaleValue;
            tvScaleValue = (TextView) convertView.findViewById(R.id.tvScaleValue);
            tvScaleValue.setText(scaleList.get(position).getLabel());


            return convertView;
        }
    }
}
