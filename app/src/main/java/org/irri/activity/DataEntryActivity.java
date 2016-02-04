package org.irri.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
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
import org.w3c.dom.Text;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;


import com.intermec.aidc.*;

public class DataEntryActivity extends AppCompatActivity implements BarcodeReadListener,AdapterView.OnItemClickListener, View.OnClickListener {

    private String studyName;
    private int REQUEST_CODE = 0X1;
    private int REQUEST_CODE2 = 0X2;

    private ImageView btnPlotPrev;
    private ImageView btnPlotNext;
    private ImageView btnTraitPrev;
    private ImageView btnTraitNext;
    private ImageView btnScale;
    private ImageView btnDate;
    private ImageView btnClear;
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

    Spinner spinnerTrait;
    ArrayAdapter<CharSequence>  adapterTrait;


    TextView tvFieldOrderLabel1;
    TextView tvFieldOrderLabel2;
    TextView tvFieldOrder1;
    TextView tvFieldOrder2;

    TextView tvMetadata1;
    TextView tvMetadata2;
    String plotMeta1;
    String plotMeta2;

    TableRow tblRowMetadata1;
    TableRow tblRowMetadata2;

    String dataField1;
    String dataField2;
    String dataField3;
    String dataField4;

    private ListView lvScale;
    private ScaleListAdapter scaleAdapter;
    private List<ScaleValue> scaleValueList;
    int searchFlag=0;
    private int totalPlotRecord;

    //data to save to plot
    private String plotKey;
    private String plotNo;
    private int variable_id;
    private String variable_value;
    private String abbrev;
    String[] spinnerArray;
    HashMap<Integer,Integer> spinnerMap;
    ArrayAdapter<CharSequence> dataAdapterTrait;


    TableRow tblRowDate;


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
        lvScale.setVisibility(View.GONE);

        btnPlotPrev= (ImageView) findViewById(R.id.btnPlotPrev);
        btnPlotNext=(ImageView) findViewById(R.id.btnPlotNext);;
        btnTraitPrev=(ImageView) findViewById(R.id.btnTraitPrev);;
        btnTraitNext=(ImageView) findViewById(R.id.btnTraitNext);;
        //btnScale=(ImageButton) findViewById(R.id.btnScale);
       // btnScale.setVisibility(View.GONE);
        btnDate=(ImageView) findViewById(R.id.btnDate);
        btnDate.setVisibility(View.GONE);

        btnClear=(ImageView) findViewById(R.id.btnClear);



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

        tvFieldOrderLabel1 = (TextView) findViewById(R.id.tvFieldOrderLabel1);
        tvFieldOrderLabel2 = (TextView) findViewById(R.id.tvFieldOrderLabel2);
        tvFieldOrder1 = (TextView) findViewById(R.id.tvFieldOrder1);
        tvFieldOrder2 = (TextView) findViewById(R.id.tvFieldOrder2);

        tvMetadata1 = (TextView) findViewById(R.id.tvMetadata1);
        tvMetadata2 = (TextView) findViewById(R.id.tvMetadata2);
        tblRowMetadata1 = (TableRow) findViewById(R.id.tblRowMetadata1);
        tblRowMetadata2 = (TableRow) findViewById(R.id.tblRowMetadata2);

        getTraitToMeasure();
        // trait spinner
        spinnerTrait = (Spinner) findViewById(R.id.spinner_trait);
        dataAdapterTrait = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item, spinnerArray);
       // ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_plot_field, android.R.layout.simple_spinner_item);
        dataAdapterTrait.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTrait.setAdapter(dataAdapterTrait);
        spinnerTrait.setSelection(0);


        spinnerTrait.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        variable_id = spinnerMap.get(position);
                        traitIndex=position;
                        setHelperBtn();
                        setTraitValue();
                    }


                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

 //       setPlotRecordDisplay(plotIndex);
 //       setTraitRecordDisplay();

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

        setPlotRecordDisplay(plotIndex);

        tblRowDate=(TableRow) findViewById(R.id.tblRowDate);
        tblRowDate.setVisibility(View.GONE);

    }

    private void initDatabase() {
        dbTool = new DatabaseMasterTool(this,studyName);
        dbTool.openStudyDatabase(studyName);
        database = dbTool.getDatabase();
        studyMgr = new StudyManager();
        totalPlotRecord=studyMgr.getAllPlotRecords(database).getCount();
        System.out.println("a");
    }

/*    private void updateSettingDataField(String field,String value) {
        studyMgr.updateSettingsDataField(database, field, value);
    }*/

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
                    int variable_id=cursorTrait.getInt(cursorTrait.getColumnIndex("variable_id"));


                    TraitMeasuring trait= new TraitMeasuring();
                    trait.setAbbrev(abbrev);
                    trait.setVariable_id(variable_id);
                    trait.setDisplay_name(displayName);
                    trait.setDataType(dataType);
                    trait.setScaleValue(scaleValue);
                    traitMeasuring.add(trait);

                } while (cursorTrait.moveToNext());
            }
        }


        spinnerArray=new String[traitMeasuring.size()];
        spinnerMap = new HashMap<Integer, Integer>();
        int i=0;

        if(traitMeasuring.size() > 0) {
            for (TraitMeasuring t : traitMeasuring) {

                spinnerMap.put(i, t.getVariable_id());
                spinnerArray[i] = t.getAbbrev();
                i++;


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

        if(id==android.R.id.home){

            this.finish();
            return true;
        }

        //noinspection SimplifiableIfStatement
        if(id == R.id.action_trait_measuring) {
            Intent intent = new Intent(DataEntryActivity.this, TraitMeasuringActivity.class);
            intent.putExtra("STUDYNAME", studyName);
            startActivityForResult(intent, REQUEST_CODE);
        }else if(id==R.id.action_plotorder){
            Intent intent = new Intent(DataEntryActivity.this, PlotOrderSettingActivity.class);
            intent.putExtra("STUDYNAME", studyName);
            startActivityForResult(intent, REQUEST_CODE2);
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


        return super.onOptionsItemSelected(item);
    }



    public void searchPlotRecord(View v) {
        if(etSearchPlot.getText().toString().length() > 0) {
            savePlotObservation();
            setPlotRecordDisplay(Integer.valueOf(etSearchPlot.getText().toString()));
        }
    }

    public void actionBtnOtherMetadata(View v) {
        showDialog(1);
    }


    public void actionBtnPlotPrev(View v) {
        savePlotObservation();
        if(plotIndex!=1) {
            plotIndex--;
        }else{
            plotIndex=1;
        }

        setPlotRecordDisplay(plotIndex);


    }

    public void actionBtnPlotNext(View v) {
        savePlotObservation();
        if(plotIndex < totalPlotRecord) {
            plotIndex++;
        }else{
            plotIndex=totalPlotRecord;
        }
        setPlotRecordDisplay(plotIndex);



    }

    public void actionBtnTraitPrev(View v) {
        savePlotObservation();
        if(traitMeasuring.size() > 0) {
            if (traitIndex == 0) {
                traitIndex = 0;
            } else {
                traitIndex--;
            }
            spinnerTrait.setSelection(traitIndex);
            setTraitValue();
            setHelperBtn();

        }
    }

    public void actionBtnTraitNext(View v) {
        savePlotObservation();
        if(traitMeasuring.size() > 0) {
            if (traitIndex == traitMeasuring.size() - 1) {
                traitIndex = traitMeasuring.size() - 1;
            } else {
                traitIndex++;
            }

            spinnerTrait.setSelection(traitIndex);
            variable_id=spinnerMap.get(traitIndex);
            setTraitValue();
            setHelperBtn();

        }

    }

    public void actionBtnSave(View v) {
        savePlotObservation();
        if(traitIndex==traitMeasuring.size()-1){
            traitIndex=0;
            spinnerTrait.setSelection(traitIndex);
            actionBtnPlotNext(v);
            setTraitValue();

        }else{
            actionBtnTraitNext(v);
        }
    }

    public void actionBtnClear(View v) {
        etValue.setText("");
    }

    public void actionBtnSearchHide(View v) {
        tblRowSearch.setVisibility(View.GONE);
    }



    public void setHelperBtn() {

        if(traitMeasuring.get(traitIndex).getScaleValue().length()> 0){
            //btnScale.setVisibility(View.VISIBLE);
        }else{
            //btnScale.setVisibility(View.GONE);
        }

        if(traitMeasuring.get(traitIndex).getDataType().equals("date")){
            btnDate.setVisibility(View.VISIBLE);
            tblRowDate.setVisibility(View.VISIBLE);
        }else{
            btnDate.setVisibility(View.GONE);
            tblRowDate.setVisibility(View.GONE);
        }

        if(traitMeasuring.get(traitIndex).getDataType().equals("integer")){
            etValue.setInputType(InputType.TYPE_CLASS_NUMBER);
        }
        if(traitMeasuring.get(traitIndex).getDataType().equals("float")){
            etValue.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        }

        if(!traitMeasuring.get(traitIndex).getScaleValue().equals("null")){
            lvScale.setVisibility(View.VISIBLE);
            scaleValueList.clear();
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
            lvScale.setVisibility(View.GONE);
            scaleValueList.clear();
            scaleAdapter = new ScaleListAdapter(getApplicationContext(),R.layout.activity_scale_row,scaleValueList);
            lvScale.setAdapter(scaleAdapter);

        }
    }





    private void setTraitValue() {

        Cursor cursor=studyMgr.getPlotData(database,plotNo,variable_id);
        String value="";
        String traitLabel;
        if(cursor != null && cursor.getCount() > 0){

            if (cursor.moveToFirst()) {
                do {
                    value=cursor.getString(cursor.getColumnIndex("value"));

                } while (cursor.moveToNext());
            }
        }

        tvTraitLabel.setText(traitMeasuring.get(traitIndex).getDisplay_name());
        etValue.setText(value);


    }


    private void savePlotObservation(){

        try {

            Date date= new Date();
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long time = date.getTime();
            //Passed the milliseconds to constructor of Timestamp class
            Timestamp ts = new Timestamp(time);

            ContentValues content = new ContentValues();
            content.put("plot_key", plotKey);
            content.put("abbrev", abbrev);
            content.put("plotno", plotNo);
            content.put("variable_id", variable_id);
            content.put("value", etValue.getText().toString());
            content.put("timestamp", fmt.format(ts));
            String s=fmt.format(ts);
            studyMgr.insertPlotRecord(database, content);
        }catch (Exception e){

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
            int mon=month+1;
            ((EditText) getActivity().findViewById(R.id.etValue)).setText(year+"/"+mon+"/"+day);
        }
    }

    @Override
    public void barcodeRead(BarcodeReadEvent abarcodeReadEvent) {

        String[] barcodeData= abarcodeReadEvent.getBarcodeData().split(";");
        final String plotNo=barcodeData[barcodeData.length-1];
        Handler refresh = new Handler(Looper.getMainLooper());
        refresh.post(new Runnable() {
            public void run() {
                Cursor plotCursor = studyMgr.getPlotRecordByPlotNo(database, plotNo);
                int recordNo = 1;
                if (plotCursor != null && plotCursor.getCount() > 0) {

                    if (plotCursor.moveToFirst()) {
                        do {
                            recordNo = plotCursor.getInt(plotCursor.getColumnIndex("recno"));
                        } while (plotCursor.moveToNext());
                    }
                }
                setPlotRecordDisplay(recordNo);
            }
        });
    }


    public  void setPlotRecordDisplay(int plotno) {

        Cursor plotCursor = studyMgr.getPlotRecords(database, plotno);
        if(plotCursor != null && plotCursor.getCount() > 0){

            if (plotCursor.moveToFirst()) {
                do {
                    tvFieldOrderLabel1.setText(dataField1);
                    tvFieldOrderLabel2.setText(dataField2);
                    tvFieldOrder1.setText(plotCursor.getString(plotCursor.getColumnIndex(dataField1)));
                    tvFieldOrder2.setText(plotCursor.getString(plotCursor.getColumnIndex(dataField2)));
                    if(!dataField3.equals("")) {
                        plotMeta1=dataField3 + " : " + plotCursor.getString(plotCursor.getColumnIndex(dataField3));
                        tvMetadata1.setText(plotMeta1);
                        tblRowMetadata1.setVisibility(View.VISIBLE);
                    }else {
                        tblRowMetadata1.setVisibility(View.GONE);
                    }
                    if(!dataField4.equals("")) {
                        plotMeta2=dataField4 + " : " + plotCursor.getString(plotCursor.getColumnIndex(dataField4));
                        tvMetadata2.setText(plotMeta2);
                        tblRowMetadata2.setVisibility(View.VISIBLE);
                    }else{
                        tblRowMetadata2.setVisibility(View.GONE);
                    }

                    plotKey=plotCursor.getString(plotCursor.getColumnIndex("plot_key"));
                    plotNo=plotCursor.getString(plotCursor.getColumnIndex("plotno"));
                    plotIndex=plotCursor.getInt(plotCursor.getColumnIndex("recno"));
                } while (plotCursor.moveToNext());
            }
        }

        etValue.requestFocus();
        setTraitValue();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                getTraitToMeasure();
                dataAdapterTrait = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item, spinnerArray);
                dataAdapterTrait.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerTrait.setAdapter(dataAdapterTrait);
                spinnerTrait.setSelection(0);
                setTraitValue();
            }else if(requestCode == REQUEST_CODE2){
                populateSettingValues();
                setPlotRecordDisplay(plotIndex);
                tvMetadata1.setText(plotMeta1);
                tvMetadata2.setText(plotMeta2);
            }


        }
        else if (resultCode == RESULT_CANCELED) {
            if (requestCode == REQUEST_CODE) {

            }
        }

    }

    @Override
    protected void onResume() {

        super.onResume();
       setPlotRecordDisplay(Integer.valueOf(plotNo));
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
    /**
     * Hides the soft keyboard
     */
    public void hideSoftKeyboard() {
        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    /**
     * Shows the soft keyboard
     */
    public void showSoftKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, 0);
    }


    @Override
    protected void onPostResume() {
        super.onPostResume();
        tvMetadata1.setText(plotMeta1);
        tvMetadata2.setText(plotMeta2);
    }


    public void actionBtnToday(View v) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        etValue.setText(year+"/"+(month+1)+"/"+day);
    }

    public void actionBtnDateLess(View v) {
        try {
            String dateString = etValue.getText().toString();
            DateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
            Date date = format.parse(dateString);
            Date dateBefore = new Date(date.getTime() - 1 * 24 * 3600 * 1000L ); //Subtract n days
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateBefore);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            etValue.setText(year+"/"+(month+1)+"/"+day);

        }catch (Exception e) {
            etValue.setText("");
        }

    }

    public void actionBtnDateAdd(View v) throws ParseException {

        try {

            String dateString = etValue.getText().toString();
            DateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
            Date date = format.parse(dateString);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, 1);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            etValue.setText(year + "/" + (month + 1) + "/" + day);
        }catch (Exception e){
            etValue.setText("");
        }
    }

}
