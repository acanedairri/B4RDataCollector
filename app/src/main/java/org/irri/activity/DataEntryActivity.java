package org.irri.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.intermec.aidc.AidcManager;
import com.intermec.aidc.BarcodeReadEvent;
import com.intermec.aidc.BarcodeReadListener;
import com.intermec.aidc.BarcodeReaderException;
import com.intermec.aidc.VirtualWedge;
import com.intermec.aidc.VirtualWedgeException;

import org.irri.activity.R;
import org.irri.entity.PlotData;
import org.irri.entity.TraitMeasuring;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import com.intermec.aidc.*;

public class DataEntryActivity extends AppCompatActivity implements BarcodeReadListener {

    private String studyName;

    private Button btnPlotPrev;
    private Button btnPlotNext;
    private Button btnTraitPrev;
    private Button btnTraitNext;
    private ImageButton btnScale;
    private ImageButton btnDate;
    private ImageButton btnClear;

    private int plotIndex=0;
    private int traitIndex=0;

    private EditText etSearchPlot;
    private EditText etPlot;
    private EditText etDesignation;
    private EditText etTrait;
    private EditText etValue;

    private TextView tvTraitLabel;
    private String currentTrait;

    private ArrayList<PlotData> plotData;
    private ArrayList<TraitMeasuring> traitMeasuring;

    private static com.intermec.aidc.VirtualWedge wedge;
    private static com.intermec.aidc.BarcodeReader bcr;

    public DataEntryActivity(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        Bundle bundle = getIntent().getExtras();
        studyName=bundle.getString("STUDYNAME");


        btnPlotPrev= (Button) findViewById(R.id.btnPlotPrev);
        btnPlotNext=(Button) findViewById(R.id.btnPlotNext);;
        btnTraitPrev=(Button) findViewById(R.id.btnTraitPrev);;
        btnTraitNext=(Button) findViewById(R.id.btnTraitNext);;
        btnScale=(ImageButton) findViewById(R.id.btnScale);
        btnScale.setVisibility(View.GONE);
        btnDate=(ImageButton) findViewById(R.id.btnDate);
        btnDate.setVisibility(View.GONE);

        btnClear=(ImageButton) findViewById(R.id.btnClear);



        etSearchPlot = (EditText) findViewById(R.id.etSearchPlot);
        etPlot = (EditText) findViewById(R.id.etPlot);
        etDesignation = (EditText) findViewById(R.id.etDesignation);
        etTrait = (EditText) findViewById(R.id.etTrait);
        etValue = (EditText) findViewById(R.id.etValue);
        tvTraitLabel = (TextView) findViewById(R.id.tvTraitLabel);

        initializedData();
        initRecord();

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

    static BarcodeReader getBarcodeObject()
    {
        return bcr;
    }

    private void initRecord() {
        setPlotRecordDisplay();
        setTraitRecordDisplay();
        etValue.requestFocus();

    }

    private void initializedData() {

        this.plotIndex=0;
        this.traitIndex=0;

        plotData= new ArrayList<PlotData>();
        traitMeasuring = new ArrayList<TraitMeasuring>();

        PlotData plot1= new PlotData();
        plot1.setPlotNo(1);
        plot1.setDesignation("IR 93326:1-B-8-4-7-1RGA-2RGA-1-B");
        this.plotData.add(plot1);

        PlotData plot2= new PlotData();
        plot2.setPlotNo(2);
        plot2.setDesignation("IR 933278:1-B-8-4-7-1RGA-2RGA-1-B");

        PlotData plot3= new PlotData();
        plot3.setPlotNo(3);
        plot3.setDesignation("IR 93326:2-B-8-5-7-1RGA-2RGA-1-B,201325-00002-0003873600");

        PlotData plot4= new PlotData();
        plot4.setPlotNo(4);
        plot4.setDesignation("IR 93326454:5-B-8-1-5-1RGA-2RGA-1-B");

        PlotData plot5= new PlotData();
        plot5.setPlotNo(52);
        plot5.setDesignation("IR 9332645:1-B-8-4-7-1RGA-2RGA-1-B");

        plotData.add(plot1);
        plotData.add(plot2);
        plotData.add(plot3);
        plotData.add(plot4);
        plotData.add(plot5);

        TraitMeasuring trait1= new TraitMeasuring();
        trait1.setAbbrev("FLW");
        trait1.setDisplay_name("Flowering");
        trait1.setDataType("date");
        trait1.setScaleValue("");

        TraitMeasuring trait2= new TraitMeasuring();
        trait2.setAbbrev("YLD");
        trait2.setDisplay_name("Yield");
        trait2.setDataType("float");
        trait2.setScaleValue("");

        TraitMeasuring trait3= new TraitMeasuring();
        trait3.setAbbrev("TILLER");
        trait3.setDisplay_name("Tiller");
        trait3.setDataType("integer");
        trait3.setScaleValue("1=Good\n2=Best");

        traitMeasuring.add(trait1);
        traitMeasuring.add(trait2);
        traitMeasuring.add(trait3);

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
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


    public void actionBtnPlotPrev(View v) {

        if(plotIndex ==0){
            plotIndex=0;
        }else {
            plotIndex--;
        }
        setPlotRecordDisplay();
    }

    public void actionBtnPlotNext(View v) {

        if(plotIndex == plotData.size()-1){
            plotIndex=0;
        }else {
            plotIndex++;
        }
        setPlotRecordDisplay();

    }

    public void actionBtnTraitPrev(View v) {

        if(traitIndex == 0){
            traitIndex=0;
        }else {
            traitIndex--;
        }
        saveTrait();
        setTraitRecordDisplay();
        setHelperBtn();

    }

    public void actionBtnTraitNext(View v) {

        if(traitIndex == traitMeasuring.size()-1){
            traitIndex=0;
        }else {
            traitIndex++;
        }
        saveTrait();
        setTraitRecordDisplay();
        setHelperBtn();

    }

    public void actionBtnClear(View v) {
        etValue.setText("");
    }


    private void saveTrait() {

        traitMeasuring.get(traitIndex).setValue(etValue.getText().toString());
        String s= traitMeasuring.get(traitIndex).getValue();
        int y;
    }


    private void setHelperBtn() {

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


    private void setPlotRecordDisplay() {

        int x=plotIndex;

        etPlot.setText(String.valueOf(plotData.get(plotIndex).getPlotNo()));
        etDesignation.setText(plotData.get(plotIndex).getDesignation());
        etValue.requestFocus();

    }

    private void setTraitRecordDisplay() {

        etTrait.setText(traitMeasuring.get(traitIndex).getAbbrev());
        tvTraitLabel.setText(traitMeasuring.get(traitIndex).getDisplay_name());
        etValue.setText(traitMeasuring.get(traitIndex).getValue());
        setHelperBtn();
        etValue.requestFocus();
        currentTrait=traitMeasuring.get(traitIndex).getAbbrev();

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
        }
        return dialog;
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
        String plotNo=barcodeData[barcodeData.length-1];
        //etSearchPlot.setText(String.valueOf(plotNo));
       // etSearchPlot.requestFocus();
        searchPlot(plotNo);
    }

    public void searchPlot(String plotNo){
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

        int y=plotIndex;
        setPlotRecordDisplay();
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
    }
}
