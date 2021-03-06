package org.irri.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.intermec.aidc.AidcManager;
import com.intermec.aidc.BarcodeReadEvent;
import com.intermec.aidc.BarcodeReadListener;
import com.intermec.aidc.BarcodeReaderException;
import com.intermec.aidc.VirtualWedge;
import com.intermec.aidc.VirtualWedgeException;

import org.irri.database.DatabaseMasterTool;
import org.irri.database.StudyManager;
import org.irri.entity.PlotData;
import org.irri.entity.ScaleValue;
import org.irri.entity.TraitMeasuring;
import org.irri.utility.ApplicationPath;
import org.irri.utility.DateUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;


import com.intermec.aidc.*;

import static android.graphics.Color.BLACK;

public class DataEntryActivity extends AppCompatActivity implements BarcodeReadListener, AdapterView.OnItemClickListener, View.OnClickListener {

    private static final String TAG = "";
    private String studyName;
    private int REQUEST_CODE = 0X1;
    private int REQUEST_CODE2 = 0X2;
    private static final int PHOTO_CAPTURE = 4;

    private ImageView btnPlotPrev;
    private ImageView btnPlotNext;
    private ImageView btnTraitPrev;
    private ImageView btnTraitNext;
    private ImageView btnScale;
    private ImageView btnDate;
    private ImageView btnClear;
    private TableRow tblRowSearch;
    private TableLayout tblPlotRangeEntry;
    private TableLayout tblPlotSingleEntry;
    private SharedPreferences ep;

    private int plotIndex = 1;
    private int traitIndex = 0;

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
    List<String> scaleValues;
    String currentTraitValue;
    String currentTraitLabel;

    Spinner spinnerTrait;
    ArrayAdapter<CharSequence> adapterTrait;


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
    String display_plot_label;
    String display_meta_label;

    String dataFieldLabel3;
    String dataFieldLabel4;

    private ListView lvScale;
    private ScaleListAdapter scaleAdapter;
    private List<ScaleValue> scaleValueList;
    int searchFlag = 0;
    private int totalPlotRecord;

    //data to save to plot
    private String plotKey;
    private String plotNo;
    private int variable_id;
    private String variable_value;
    private String abbrev;
    String[] spinnerArray;
    HashMap<Integer, Integer> spinnerMap;
    ArrayAdapter<CharSequence> dataAdapterTrait;


    TableRow tblRowDate;
    private boolean withScaleValue = false;
    private String accessToken;
    private int plotEntry = 1;
    private TableLayout tblLayoutMetaData;
    private EditText etPlotNoStart;
    private EditText etPlotNoEnd;
    private final static Pattern LTRIM = Pattern.compile("^\\s+");
    private boolean doSaving = false;
    int countUpdate = 0;
    int countInsert = 0;
    int plotNoTemp = 0;
    int plotEnd = 0;
    String currentAbbrev = "";
    boolean isFinish = false;
    String entryform;
    String dataEntryColor = "light";

    public DataEntryActivity() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Bundle bundle = getIntent().getExtras();
        studyName = bundle.getString("STUDYNAME");
        accessToken = bundle.getString("ACCESSTOKEN");

        initDatabase();
        populateSettingValuesMaster();
        populateSettingValuesStudy();

        if (dataEntryColor.equals("light")) {
            setContentView(R.layout.activity_data_entry);
        } else {
            setContentView(R.layout.activity_data_entry_dark);
        }

        traitMeasuring = new ArrayList<TraitMeasuring>();

        lvScale = (ListView) findViewById(R.id.lvScale);
        scaleValueList = new ArrayList<ScaleValue>();
        lvScale.setOnItemClickListener(this);
        lvScale.setVisibility(View.GONE);

        btnPlotPrev = (ImageView) findViewById(R.id.btnPlotPrev);
        btnPlotNext = (ImageView) findViewById(R.id.btnPlotNext);
        ;
        btnTraitPrev = (ImageView) findViewById(R.id.btnTraitPrev);
        ;
        btnTraitNext = (ImageView) findViewById(R.id.btnTraitNext);
        ;
        //btnScale=(ImageButton) findViewById(R.id.btnScale);
        // btnScale.setVisibility(View.GONE);
        btnDate = (ImageView) findViewById(R.id.btnDate);
        btnDate.setVisibility(View.GONE);

        btnClear = (ImageView) findViewById(R.id.btnClear);


        etSearchPlot = (EditText) findViewById(R.id.etSearchPlot);
        etTrait = (EditText) findViewById(R.id.etTrait);
        etValue = (EditText) findViewById(R.id.etValue);
        tvTraitLabel = (TextView) findViewById(R.id.tvTraitLabel);

        tblRowSearch = (TableRow) findViewById(R.id.tblRowSearch);
        tblRowSearch.setVisibility(View.GONE);

        dbTool = new DatabaseMasterTool(this, studyName);
        database = dbTool.getStudyDatabase(studyName);
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
        if (dataEntryColor.equals("light")) {
            dataAdapterTrait = new ArrayAdapter<CharSequence>(this, R.layout.spinner_layout, spinnerArray);
        } else {
            dataAdapterTrait = new ArrayAdapter<CharSequence>(this, R.layout.spinner_layout_dark, spinnerArray);
        }
        // ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_plot_field, android.R.layout.simple_spinner_item);
        dataAdapterTrait.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTrait.setAdapter(dataAdapterTrait);
        spinnerTrait.setSelection(0);


        spinnerTrait.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        variable_id = spinnerMap.get(position);
                        traitIndex = position;
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
            bcr = DataEntryActivity.getBarcodeObject();// SettingBarcodeActivity.getBarcodeObject();

            if (bcr != null) {
                //enable scanner
                bcr.setScannerEnable(true);

                //set listener
                bcr.addBarcodeReadListener(this);

            }

        } catch (BarcodeReaderException e) {
            e.printStackTrace();
        }


        tblRowDate = (TableRow) findViewById(R.id.tblRowDate);
        tblRowDate.setVisibility(View.GONE);


        InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);

        tblPlotSingleEntry = (TableLayout) findViewById(R.id.tblPlotSingleEntry);
        tblPlotRangeEntry = (TableLayout) findViewById(R.id.tblPlotRangeEntry);
        tblLayoutMetaData = (TableLayout) findViewById(R.id.tblLayoutMetadata);


        etPlotNoStart = (EditText) findViewById(R.id.etPlotNoStart);
        etPlotNoEnd = (EditText) findViewById(R.id.etPlotNoEnd);
        setPlotRecordDisplay(plotIndex);

        etValue.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (withScaleValue) {
                    int i = 0;
                    for (ScaleValue r : scaleValueList) {
                        if (r.getValue().contains(s.toString())) {
                            lvScale.setSelection(i);
                            lvScale.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                            if (dataEntryColor.equals("light")) {
                                lvScale.setSelector(android.R.color.darker_gray);
                            } else {
                                lvScale.setSelector(android.R.color.background_light);

                            }
                            lvScale.setSelected(true);
                        }
                        i++;
                    }
                }
            }
        });
    }

    private void initDatabase() {
        dbTool = new DatabaseMasterTool(this, studyName);
        database = dbTool.getStudyDatabase(studyName);
        studyMgr = new StudyManager();
        totalPlotRecord = studyMgr.getAllPlotRecords(database).getCount();


    }

/*    private void updateSettingDataField(String field,String value) {
        studyMgr.updateSettingsDataField(database, field, value);
    }*/

    private void populateSettingValuesMaster() {

        DatabaseMasterTool dbToolMaster = new DatabaseMasterTool(this);
        SQLiteDatabase database = dbToolMaster.getMasterDatabase();
        StudyManager mgr = new StudyManager();
        Cursor cursorSettings = mgr.getSettingsMaster(database);

        if (cursorSettings != null && cursorSettings.getCount() > 0) {

            if (cursorSettings.moveToFirst()) {
                do {
                    dataField1 = cursorSettings.getString(cursorSettings.getColumnIndex("datafield1"));
                    dataField2 = cursorSettings.getString(cursorSettings.getColumnIndex("datafield2"));
                    dataField3 = cursorSettings.getString(cursorSettings.getColumnIndex("datafield3"));
                    dataField4 = cursorSettings.getString(cursorSettings.getColumnIndex("datafield4"));
                    entryform = cursorSettings.getString(cursorSettings.getColumnIndex("entryform"));
                    dataEntryColor = cursorSettings.getString(cursorSettings.getColumnIndex("formcolor"));
                    display_meta_label = cursorSettings.getString(cursorSettings.getColumnIndex("display_meta_label"));
                    display_plot_label = cursorSettings.getString(cursorSettings.getColumnIndex("display_plot_label"));

                } while (cursorSettings.moveToNext());
            }
        }

        dbToolMaster.closeDB(database);
    }

    private void populateSettingValuesStudy() {


        Cursor cursorSettings = studyMgr.getSettingsMaster(database);

        if (cursorSettings != null && cursorSettings.getCount() > 0) {

            if (cursorSettings.moveToFirst()) {
                do {

                    int lplot = cursorSettings.getInt(cursorSettings.getColumnIndex("last_recno"));
                    entryform = cursorSettings.getString(cursorSettings.getColumnIndex("entryform"));
                    dataEntryColor = cursorSettings.getString(cursorSettings.getColumnIndex("formcolor"));
                    if (lplot > 0) {
                        plotIndex = lplot;
                    } else {
                        plotIndex = 1;
                    }

                } while (cursorSettings.moveToNext());
            }
        }


    }


    static BarcodeReader getBarcodeObject() {
        return bcr;
    }


    public void getTraitToMeasure() {

        traitMeasuring.clear();
        Cursor cursorTrait = studyMgr.getVariableSetSelected(database);

        if (cursorTrait != null && cursorTrait.getCount() > 0) {

            if (cursorTrait.moveToFirst()) {
                do {
                    String abbrev = cursorTrait.getString(cursorTrait.getColumnIndex("abbrev"));
                    String displayName = cursorTrait.getString(cursorTrait.getColumnIndex("label"));
                    String dataType = cursorTrait.getString(cursorTrait.getColumnIndex("data_type"));
                    String scaleValue = cursorTrait.getString(cursorTrait.getColumnIndex("scale_value"));
                    int variable_id = cursorTrait.getInt(cursorTrait.getColumnIndex("variable_id"));


                    TraitMeasuring trait = new TraitMeasuring();
                    trait.setAbbrev(abbrev);
                    trait.setVariable_id(variable_id);
                    trait.setDisplay_name(displayName);
                    trait.setDataType(dataType);
                    trait.setScaleValue(scaleValue);
                    traitMeasuring.add(trait);

                } while (cursorTrait.moveToNext());
            }
        }


        spinnerArray = new String[traitMeasuring.size()];
        spinnerMap = new HashMap<Integer, Integer>();
        int i = 0;

        if (traitMeasuring.size() > 0) {
            for (TraitMeasuring t : traitMeasuring) {

                spinnerMap.put(i, t.getVariable_id());
                spinnerArray[i] = ltrim(t.getAbbrev());
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

        if (id == android.R.id.home) {

            this.finish();
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_trait_measuring) {
            Intent intent = new Intent(DataEntryActivity.this, TraitMeasuringActivity.class);
            intent.putExtra("STUDYNAME", studyName);
            intent.putExtra("ACCESSTOKEN", accessToken);
            startActivityForResult(intent, REQUEST_CODE);
        } else if (id == R.id.action_settings) {
            Intent intent = new Intent(DataEntryActivity.this, SettingDataEntryActivity.class);
            intent.putExtra("STUDYNAME", studyName);
            startActivityForResult(intent, REQUEST_CODE2);
        } else if (id == R.id.action_search) {
            if (searchFlag == 0) {
                tblRowSearch.setVisibility(View.VISIBLE);
                item.setIcon(R.drawable.search_minus);
                searchFlag = 1;

            } else {
                item.setIcon(R.drawable.search);
                tblRowSearch.setVisibility(View.GONE);
                searchFlag = 0;
            }
            etSearchPlot.requestFocus();
        } else if (id == R.id.action_help) {

            Intent intent = new Intent(getApplicationContext(), HelpActivity.class);
            intent.putExtra("IMAGE", "help_dataentry");
            startActivity(intent);
            return true;

        }
/*        else if (id == R.id.action_single_entry) {

                plotEntry=1;
                tblPlotSingleEntry.setVisibility(View.VISIBLE) ;
                tblPlotRangeEntry.setVisibility(View.GONE);
                tblLayoutMetaData.setVisibility(View.VISIBLE);

            return true;

        }else if (id == R.id.action_range_entry) {

                plotEntry=2;
                etPlotNoStart.setText(String.valueOf(plotIndex));
                tblPlotSingleEntry.setVisibility(View.GONE) ;
                tblPlotRangeEntry.setVisibility(View.VISIBLE);
                tblLayoutMetaData.setVisibility(View.GONE);

            return true;

        }*/

        else if (id == R.id.action_take_photo) {

            Calendar now = GregorianCalendar.getInstance();
            String plotReferenceCode = "abc";
            Intent iPhoto = new Intent(DataEntryActivity.this, PhotoCaptureActivity.class);
            iPhoto.putExtra("DBNAME", studyName);
            String photoName = studyName + "_" + plotNo + "_" + "-var-" + currentTraitLabel;
            iPhoto.putExtra("PHOTO_NAME", photoName);
            startActivityForResult(iPhoto, PHOTO_CAPTURE);

        } else if (id == R.id.action_view_plot_meta) {

            showDialog(1);

        } else if (id == R.id.action_view_photo) {

            Intent i = new Intent(DataEntryActivity.this, ImageListViewActivity.class);
            i.putExtra("FOLDER_PATH", ApplicationPath.APP_PATH_IMAGES);
            i.putExtra("STUDYNAME", studyName);
            startActivity(i);
        }


        return super.onOptionsItemSelected(item);
    }


    public void searchPlotRecord(View v) {
        if (etSearchPlot.getText().toString().length() > 0) {
            savePlotObservation();
            setPlotRecordDisplay(Integer.valueOf(etSearchPlot.getText().toString()));
        }
    }

    public void actionBtnOtherMetadata(View v) {
        showDialog(1);
    }


    public void actionBtnPlotPrev(View v) {
        savePlotObservation();
        if (plotIndex != 1) {
            plotIndex--;
        } else {
            plotIndex = 1;
        }

        setPlotRecordDisplay(plotIndex);


    }

    public void actionBtnPlotNext(View v) {
        savePlotObservation();
        if (plotIndex < totalPlotRecord) {
            plotIndex++;
        } else {
            plotIndex = totalPlotRecord;
        }
        setPlotRecordDisplay(plotIndex);

    }

    public void actionBtnTraitPrev(View v) {
        savePlotObservation();
        if (traitMeasuring.size() > 0) {
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
//        actionBtnSave(v);
        savePlotObservation();
        if (traitMeasuring.size() > 0) {
            if (traitIndex == traitMeasuring.size() - 1) {
                traitIndex = 0;
                spinnerTrait.setSelection(traitIndex);
                actionBtnPlotNext(v);
                setTraitValue();
            } else {
                traitIndex++;
            }

            spinnerTrait.setSelection(traitIndex);
            variable_id = spinnerMap.get(traitIndex);
            setTraitValue();
            setHelperBtn();
        }

    }


    private boolean ifValidSaving() {

        System.out.println(variable_id);
        try {
            String t = spinnerTrait.getItemAtPosition(traitIndex).toString();
            if (etValue.getText().toString().length() > 0) {
                return true;
            }

        } catch (Exception e) {
            return false;
        }

        return false;
    }

    public void actionBtnSave(final View v) {
        boolean toSave = true;
        doSaving = false;
        if (ifValidSaving()) {

            if (!isValidValue() && withScaleValue) {

/*                Toast.makeText(getApplicationContext(),
                        "Invalid value entered", Toast.LENGTH_LONG)
                        .show();*/

                android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(
                        DataEntryActivity.this).create();
                alertDialog.setTitle("Error Input Message");
                alertDialog.setMessage("Invalid value");
                alertDialog.setIcon(R.drawable.info);
                alertDialog.setButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog closed
                        //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.show();

                etValue.setText("");
                toSave = false;
            }

            if (isValidDate()) {

              /*  Toast.makeText(getApplicationContext(),
                        "Invalid value entered for date", Toast.LENGTH_LONG)
                        .show();*/

                android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(
                        DataEntryActivity.this).create();
                alertDialog.setTitle("Error Input Message");
                alertDialog.setMessage("Invalid date format");
                alertDialog.setIcon(R.drawable.info);
                alertDialog.setButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog closed
                        //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.show();
                etValue.setText("");
                toSave = false;
            }

            if (toSave) {

                if (etValue.getText().toString().length() > 0) {

                    if (plotEntry == 1) {

                        boolean isExistRecord = studyMgr.isExistRecord(database, Integer.valueOf(plotNo), variable_id);
                        if (isExistRecord) {

                            String fieldValue = etValue.getText().toString();
                            final String oldValue = currentTraitValue;

                            if (!etValue.getText().toString().equals(currentTraitValue)) {
                                doSaving = false;
                                android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(
                                        DataEntryActivity.this);
                                alertDialog.setTitle("Saving Confirmation");
                                alertDialog.setMessage("Replaced existing value?");
                                alertDialog.setIcon(R.drawable.info);
                                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        doSaving = true;
                                        savePlotObservation();
                                        if (traitIndex == traitMeasuring.size() - 1) {
                                            traitIndex = 0;
                                            spinnerTrait.setSelection(traitIndex);

                                            if (traitMeasuring.size() - 1 > 0) {
                                                showMsgToNextPlot(v);
                                            } else {
                                                actionBtnPlotNext(v);
                                            }
                                            setTraitValue();

                                        } else {
                                            actionBtnTraitNext(v);
                                        }

                                    }
                                });
                                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        etValue.setText(oldValue);

                                    }
                                });

                                // Showing Alert Message
                                alertDialog.show();

                            }
                        } else {
                            doSaving = true;
                            savePlotObservation();
                            if (traitIndex == traitMeasuring.size() - 1) {
                                traitIndex = 0;
                                spinnerTrait.setSelection(traitIndex);

                                if (traitMeasuring.size() - 1 > 0) {
                                    showMsgToNextPlot(v);
                                } else {
                                    actionBtnPlotNext(v);
                                }
                                setTraitValue();

                            } else {
                                actionBtnTraitNext(v);
                            }
                        }


                    } else {
                        savePlotObservationRange();


                    }
                }
            }

        } else {
            Toast.makeText(getApplicationContext(),
                    "Incomplete data, record cannot be save", Toast.LENGTH_LONG);
            etValue.setText("");
        }
    }

    private void showMsgToNextPlot(final View v) {

        android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(
                DataEntryActivity.this);
        alertDialog.setTitle("Info");
        alertDialog.setMessage("Moving to Next Plot?");
        alertDialog.setIcon(R.drawable.info);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                actionBtnPlotNext(v);
            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        // Showing Alert Message
        alertDialog.show();
    }

    private void showMsgUpdateRecord(int countInsert, int countUpdate, final int plotEnd) {

        android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(
                DataEntryActivity.this);
        alertDialog.setTitle("Save Message");
        alertDialog.setMessage("Successfully insert " + countInsert + " record(s) and updated " + countUpdate + " record(s)");
        alertDialog.setIcon(R.drawable.info);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                etPlotNoStart.setText(String.valueOf(plotEnd + 1));
                etPlotNoEnd.setText("");
                etValue.setText("");
            }
        });


        // Showing Alert Message
        alertDialog.show();

    }


    private boolean isValidDate() {
        if (traitMeasuring.get(traitIndex).getDataType().equals("date")) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                String dateInString = etValue.getText().toString();

                try {
                    Date date = formatter.parse(dateInString);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return true;
                }
            } catch (Exception e) {
                return true;
            }


        }

        return false;
    }

    private boolean isValidValue() {

        if (withScaleValue) {
            String val = etValue.getText().toString();

            for (ScaleValue rec : scaleValueList) {
                if (val.equals(rec.getValue())) {
                    return true;
                }
            }
        }


        return false;
    }

    public void actionBtnClear(View v) {
        etValue.setText("");
    }

    public void actionBtnSearchHide(View v) {
        tblRowSearch.setVisibility(View.GONE);
    }


    public void setHelperBtn() {

        if (traitMeasuring.get(traitIndex).getScaleValue().length() > 0) {
            //btnScale.setVisibility(View.VISIBLE);
        } else {
            //btnScale.setVisibility(View.GONE);
        }

        if (traitMeasuring.get(traitIndex).getDataType().equals("date")) {
            btnDate.setVisibility(View.VISIBLE);
            tblRowDate.setVisibility(View.VISIBLE);
        } else {
            btnDate.setVisibility(View.GONE);
            tblRowDate.setVisibility(View.GONE);
        }

        if (traitMeasuring.get(traitIndex).getDataType().equals("integer")) {
            etValue.setInputType(InputType.TYPE_CLASS_NUMBER);
        }
        if (traitMeasuring.get(traitIndex).getDataType().equals("float")) {
            etValue.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        } else {
            etValue.setInputType(InputType.TYPE_CLASS_TEXT);
        }

        if (!traitMeasuring.get(traitIndex).getScaleValue().equals("null") && !traitMeasuring.get(traitIndex).getScaleValue().equals("")) {
            lvScale.setVisibility(View.VISIBLE);
            withScaleValue = true;
            scaleValueList.clear();
            String[] scale = traitMeasuring.get(traitIndex).getScaleValue().split(";");
            for (int i = 0; i < scale.length; i++) {
                ScaleValue sv = new ScaleValue();
                sv.setLabel(ltrim(scale[i].trim()));
                String[] val = scale[i].split("=");
                sv.setValue(ltrim(val[0].trim()));
                scaleValueList.add(sv);

            }

            if (dataEntryColor.equals("light")) {
                scaleAdapter = new ScaleListAdapter(getApplicationContext(), R.layout.activity_scale_row, scaleValueList);
            } else {
                scaleAdapter = new ScaleListAdapter(getApplicationContext(), R.layout.activity_scale_row_dark, scaleValueList);
            }
            lvScale.setAdapter(scaleAdapter);

        } else {
            withScaleValue = false;
            lvScale.setVisibility(View.GONE);
            scaleValueList.clear();

            if (dataEntryColor.equals("light")) {
                scaleAdapter = new ScaleListAdapter(getApplicationContext(), R.layout.activity_scale_row, scaleValueList);
            } else {
                scaleAdapter = new ScaleListAdapter(getApplicationContext(), R.layout.activity_scale_row_dark, scaleValueList);
            }

            lvScale.setAdapter(scaleAdapter);

        }
    }


    private void setTraitValue() {

        Cursor cursor = studyMgr.getPlotData(database, plotNo, variable_id);
        String value = "";
        String traitLabel;
        if (cursor != null && cursor.getCount() > 0) {

            if (cursor.moveToFirst()) {
                do {
                    value = cursor.getString(cursor.getColumnIndex("value"));

                } while (cursor.moveToNext());
            }
        }

        if (traitMeasuring.size() > 0) {
            tvTraitLabel.setText(traitMeasuring.get(traitIndex).getDisplay_name());
            currentTraitLabel = traitMeasuring.get(traitIndex).getAbbrev();

        } else {
            tvTraitLabel.setText("");
        }
        etValue.setText(value);
        currentTraitValue = value;


    }


    private void savePlotObservation() {

        try {
            if (etValue.getText().toString().length() > 0) {
                final DateUtil cdate = new DateUtil();

                final ContentValues content = new ContentValues();
                content.put("plot_key", plotKey);
                content.put("abbrev", abbrev);
                content.put("plotno", plotNo);
                content.put("variable_id", variable_id);
                content.put("value", etValue.getText().toString());
                content.put("timestamp", cdate.getDate());

                boolean isExistRecord = studyMgr.isExistRecord(database, Integer.valueOf(plotNo), variable_id);
                String fieldValue = etValue.getText().toString();

                if (isExistRecord) {
                    if (!etValue.getText().toString().equals(currentTraitValue)) {
                        if (doSaving) {
                            content.put("committed", "N");
                            studyMgr.updatePlotRecord(database, etValue.getText().toString(), Integer.valueOf(plotNo), variable_id, cdate.getDate());
                        }
                    }
                } else {
                    content.put("committed", "N");
                    studyMgr.insertPlotRecord(database, content);
                }

            }

        } catch (Exception e) {

        }

    }

    private void savePlotObservationRange() {

        try {

            int plotStart = Integer.valueOf(etPlotNoStart.getText().toString());
            plotEnd = Integer.valueOf(etPlotNoEnd.getText().toString());


            if (etValue.getText().toString().length() > 0) {
                final DateUtil cdate = new DateUtil();

                if (plotStart > plotEnd) {
                    int temp = plotStart;
                    plotStart = plotEnd;
                    plotEnd = temp;
                } else {
                    plotStart = plotStart;
                    plotEnd = plotEnd;
                }

                for (int start = plotStart; start <= plotEnd; start++) {

                    Cursor plotData = studyMgr.getPlotRecordByPlotNo(database, start);


                    String plotKeyTemp = null;
                    if (plotData != null && plotData.getCount() > 0) {

                        if (plotData.moveToFirst()) {
                            do {
                                plotKeyTemp = plotData.getString(plotData.getColumnIndex("plot_key"));
                                plotNoTemp = plotData.getInt(plotData.getColumnIndex("plotno"));


                            } while (plotData.moveToNext());
                        }
                    }
                    final ContentValues content = new ContentValues();
                    content.put("plot_key", plotKeyTemp);
                    content.put("abbrev", abbrev);
                    content.put("plotno", plotNoTemp);
                    content.put("variable_id", variable_id);
                    content.put("value", etValue.getText().toString());
                    content.put("timestamp", cdate.getDate());

                    boolean isExistRecord = studyMgr.isExistRecord(database, plotNoTemp, variable_id);
                    if (isExistRecord) {
                        if (!etValue.getText().toString().equals(currentTraitValue)) {
                            showDialogConfirmSaving(cdate.getDate());
                            //showMsgUpdateRecord(countInsert,countUpdate,plotEnd);
                        }
                    } else {
                        content.put("committed", "N");
                        studyMgr.insertPlotRecord(database, content);
                        countInsert++;
                    }

                }


            }

            etPlotNoStart.setText(String.valueOf(plotEnd + 1));
            etPlotNoEnd.setText("");
        } catch (Exception e) {

        }

    }

    private void showDialogConfirmSaving(final String date) {

        android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(
                DataEntryActivity.this);
        alertDialog.setTitle("Info");
        alertDialog.setMessage("Plot No. " + plotNoTemp + " with variable " + currentTraitLabel + " has already a value. Would you like to overwrite?");
        alertDialog.setIcon(R.drawable.info);
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                studyMgr.updatePlotRecord(database, etValue.getText().toString(), Integer.valueOf(plotNoTemp), variable_id, date);
                countUpdate++;

            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.create();
        alertDialog.show();


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

        public DatePickerFragment(int month, int year, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
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
            int mon = month + 1;
            String monthLabel;
            String dayLabel;

            if (mon < 10) {
                monthLabel = "0" + String.valueOf(mon);
            } else {
                monthLabel = String.valueOf(mon);
            }

            if (day < 10) {
                dayLabel = "0" + String.valueOf(day);
            } else {
                dayLabel = String.valueOf(day);
            }


            ((EditText) getActivity().findViewById(R.id.etValue)).setText(year + "-" + monthLabel + "-" + dayLabel);
        }
    }

    @Override
    public void barcodeRead(BarcodeReadEvent abarcodeReadEvent) {

        String[] barcodeData = abarcodeReadEvent.getBarcodeData().split(";");
        final String plotCode = barcodeData[barcodeData.length - 1];
        Handler refresh = new Handler(Looper.getMainLooper());
        refresh.post(new Runnable() {
            public void run() {
                Cursor plotCursor = studyMgr.getPlotRecordByPlotCode(database, plotCode);
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


    public void setPlotRecordDisplay(int plotno) {

        Cursor plotCursor = studyMgr.getPlotRecords(database, plotno);
        if (plotCursor != null && plotCursor.getCount() > 0) {

            if (plotCursor.moveToFirst()) {
                do {
                    if (display_plot_label.equals("Y")) {
                        tvFieldOrderLabel1.setText(dataField1);
                        tvFieldOrderLabel2.setText(dataField2);
                    } else {
                        tvFieldOrderLabel1.setVisibility(View.GONE);
                        tvFieldOrderLabel2.setVisibility(View.GONE);
                    }



                    tvFieldOrder1.setText(plotCursor.getString(plotCursor.getColumnIndex(dataField1)));
                    tvFieldOrder2.setText(plotCursor.getString(plotCursor.getColumnIndex(dataField2)));
                    if (!dataField3.equals("")) {
                        if (display_meta_label.equals("Y")) {
                            dataFieldLabel3=dataField3+ ":";
                        } else {
                            dataFieldLabel3="";
                        }

                        plotMeta1 = dataFieldLabel3 +plotCursor.getString(plotCursor.getColumnIndex(dataField3));
                        tvMetadata1.setText(plotMeta1);
                        tblRowMetadata1.setVisibility(View.VISIBLE);
                    } else {
                        tblRowMetadata1.setVisibility(View.GONE);
                    }
                    if (!dataField4.equals("")) {
                        if (display_meta_label.equals("Y")) {
                            dataFieldLabel4=dataField4+ ":";
                        } else {
                            dataFieldLabel4="";
                        }
                        plotMeta2 = dataFieldLabel4 + plotCursor.getString(plotCursor.getColumnIndex(dataField4));
                        tvMetadata2.setText(plotMeta2);
                        tblRowMetadata2.setVisibility(View.VISIBLE);
                    } else {
                        tblRowMetadata2.setVisibility(View.GONE);
                    }

                    plotKey = plotCursor.getString(plotCursor.getColumnIndex("plot_key"));
                    plotNo = plotCursor.getString(plotCursor.getColumnIndex("plotno"));
                    plotIndex = plotCursor.getInt(plotCursor.getColumnIndex("recno"));
                } while (plotCursor.moveToNext());
            }
        }

        etValue.requestFocus();
        setTraitValue();

        if (entryform.equals("single")) {
            tblPlotSingleEntry.setVisibility(View.VISIBLE);
            tblPlotRangeEntry.setVisibility(View.GONE);
            tblLayoutMetaData.setVisibility(View.VISIBLE);
        } else {
            tblPlotSingleEntry.setVisibility(View.GONE);
            tblPlotRangeEntry.setVisibility(View.VISIBLE);
            tblLayoutMetaData.setVisibility(View.GONE);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                getTraitToMeasure();

                if (dataEntryColor.equals("light")) {
                    dataAdapterTrait = new ArrayAdapter<CharSequence>(this, R.layout.spinner_layout, spinnerArray);
                } else {
                    dataAdapterTrait = new ArrayAdapter<CharSequence>(this, R.layout.spinner_layout_dark, spinnerArray);
                }


                dataAdapterTrait.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerTrait.setAdapter(dataAdapterTrait);
                spinnerTrait.setSelection(0);
                setTraitValue();
            } else if (requestCode == REQUEST_CODE2) {
                populateSettingValuesMaster();

                setPlotRecordDisplay(plotIndex);
                tvMetadata1.setText(plotMeta1);
                tvMetadata2.setText(plotMeta2);

             /*   if(dataEntryColor.equals("light")) {
                    setContentView(R.layout.activity_data_entry);

                } else{
                    setContentView(R.layout.activity_data_entry_dark);
                }
*/
                //findViewById(android.R.id.content).invalidate();
            }


        } else if (resultCode == RESULT_CANCELED) {
            if (requestCode == REQUEST_CODE) {

            }
        }

    }

    @Override
    protected void onResume() {

        super.onResume();
        setPlotRecordDisplay(Integer.valueOf(plotNo));
 /*       if(isFinish) {
                    showMsgUpdateRecord(countInsert, countUpdate, 6);
        }*/


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        studyMgr.updateSettingsLastRow(database, plotIndex);
        savePlotObservation();

        try {
            if (wedge != null) {
                wedge.setEnable(true);
                wedge = null;
            }

            if (bcr != null) {
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

    private String getPlotMetadata() {
        String data = "";

        plotCursor = studyMgr.getPlotRecords(database, plotIndex);

        if (plotCursor != null && plotCursor.getCount() > 0) {

            if (plotCursor.moveToFirst()) {
                do {
                    data += "Plot key : " + plotCursor.getString(plotCursor.getColumnIndex("plot_key")) + "\n";
                    data += "Plot No : " + plotCursor.getInt(plotCursor.getColumnIndex("plotno")) + "\n";
                    data += "Plot Code : " + plotCursor.getString(plotCursor.getColumnIndex("plot_code")) + "\n";
                    data += "Rep : " + plotCursor.getInt(plotCursor.getColumnIndex("rep")) + "\n";
                    data += "GID : " + plotCursor.getInt(plotCursor.getColumnIndex("gid")) + "\n";
                    data += "Entry No : " + plotCursor.getInt(plotCursor.getColumnIndex("entno")) + "\n";
                    data += "Entry Code : " + plotCursor.getString(plotCursor.getColumnIndex("entcode")) + "\n";
                    data += "Designation : " + plotCursor.getString(plotCursor.getColumnIndex("designation")) + "\n";
                    data += "Parentage : " + plotCursor.getString(plotCursor.getColumnIndex("parentage")) + "\n";
                    data += "Generation : " + plotCursor.getString(plotCursor.getColumnIndex("generation")) + "\n";
                    data += "QR Code : " + plotCursor.getString(plotCursor.getColumnIndex("qr_code")) + "\n";
                    data += "Field Row : " + plotCursor.getString(plotCursor.getColumnIndex("fldrow_cont")) + "\n";
                    data += "Field Column : " + plotCursor.getString(plotCursor.getColumnIndex("fldcol_cont")) + "\n";

                } while (plotCursor.moveToNext());
            }
        }

        return data;
    }

    public class ScaleListAdapter extends ArrayAdapter {

        public List<ScaleValue> scaleList;
        private int resource;
        private LayoutInflater inflater;


        public ScaleListAdapter(Context context, int resource, List<ScaleValue> objects) {
            super(context, resource, objects);
            scaleList = objects;
            this.resource = resource;
            inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = inflater.inflate(resource, null);
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
        if (getCurrentFocus() != null) {
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

        String dayLabel = "";

        if (day < 10) {
            dayLabel = "0" + String.valueOf(day);
        } else {
            dayLabel = String.valueOf(day);
        }

        if (month < 10) {
            etValue.setText(year + "-0" + (month + 1) + "-" + dayLabel);
        } else {
            etValue.setText(year + "-" + (month + 1) + "-" + dayLabel);
        }

    }

    public void actionBtnDateLess(View v) {
        try {
            String dateString = etValue.getText().toString();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date = format.parse(dateString);
            Date dateBefore = new Date(date.getTime() - 1 * 24 * 3600 * 1000L); //Subtract n days
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateBefore);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            String dayLabel = "";

            if (day < 10) {
                dayLabel = "0" + String.valueOf(day);
            } else {
                dayLabel = String.valueOf(day);
            }

            if (month < 10) {
                etValue.setText(year + "-0" + (month + 1) + "-" + dayLabel);
            } else {
                etValue.setText(year + "-" + (month + 1) + "-" + dayLabel);
            }


        } catch (Exception e) {
            etValue.setText("");
        }

    }

    public void actionBtnDateAdd(View v) throws ParseException {

        try {

            String dateString = etValue.getText().toString();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date = format.parse(dateString);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, 1);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            String dayLabel = "";

            if (day < 10) {
                dayLabel = "0" + String.valueOf(day);
            } else {
                dayLabel = String.valueOf(day);
            }

            if (month < 10) {
                etValue.setText(year + "-0" + (month + 1) + "-" + dayLabel);
            } else {
                etValue.setText(year + "-" + (month + 1) + "-" + dayLabel);
            }


        } catch (Exception e) {
            etValue.setText("");
        }
    }

    public static String ltrim(String s) {
        return LTRIM.matcher(s).replaceAll("");
    }

}
