package org.irri.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;

import org.irri.database.AccountManager;
import org.irri.database.DatabaseMasterTool;
import org.irri.database.StudyManager;
import org.irri.entity.CommitMessage;
import org.irri.entity.PlotDataCommitModel;
import org.irri.entity.Study;
import org.irri.entity.StudyListData;
import org.irri.entity.StudyListModel;
import org.irri.entity.User;
import org.irri.utility.ApplicationPath;
import org.irri.utility.DateUtil;
import org.irri.utility.RestClient;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class StudiesWithNavActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {



    AsyncHttpClient client;
    User user;
    Gson gson;
    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";
    private Study study;
    private ListView lvStudyList;
    private int REQUEST_CODE = 0X1;
    private int REQUEST_CODE_SETTING = 0X2;
    List<StudyListData> studyList;
    MyStudyListAdapter adapter;
    private TableRow tblDeleteStudy;
    private TableRow tblRowSearch;
    private EditText etSearchStudy;
    int searchFlag = 0;
    int deleteFlag = 0;
    private static String is_posted;
    List<StudyListModel> studyToDelete = new ArrayList<StudyListModel>();
    // private int totalUncommitedRecord;

    Spinner spinnerProgam;
    ArrayAdapter<CharSequence> adapterProgram;
    String[] spinnerArray;
    private String programName;
    int programIndex = 0;
    String year = "";
    String season = "";
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    ListView navList;

    ListView mDrawerList;
    RelativeLayout mDrawerPane;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();
    private android.support.v7.app.ActionBar actionBar;

    private String accessToken;
    private String username;
    private String studyName;
    private int transaction_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studies_with_nav);
        Bundle bundle = getIntent().getExtras();
        accessToken = bundle.getString("ACCESS_TOKEN");
        username=bundle.getString("USERNAME");

        TextView tvUser=(TextView) findViewById(R.id.userName);
        tvUser.setText(username);

        studyList = getMyStudyList(null, "");
        lvStudyList = (ListView) findViewById(R.id.lvStudyList);
        adapter = new MyStudyListAdapter(getApplicationContext(), R.layout.activity_studies_list_row, studyList);
        lvStudyList.setAdapter(adapter);
        lvStudyList.setOnItemClickListener(this);

        tblRowSearch = (TableRow) findViewById(R.id.tblRowSearch);
        tblRowSearch.setVisibility(View.GONE);

        tblDeleteStudy = (TableRow) findViewById(R.id.tblDeleteStudy);
        tblDeleteStudy.setVisibility(View.GONE);

        etSearchStudy = (EditText) findViewById(R.id.etSearchStudy);

        etSearchStudy.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                // you can call or do what you want with your EditText here


            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                studyList.clear();
                studyList = getMyStudyList(etSearchStudy.getText().toString(), programName);
                adapter = new MyStudyListAdapter(getApplicationContext(), R.layout.activity_studies_list_row, studyList);
                adapter.notifyDataSetChanged();
                lvStudyList.setAdapter(adapter);

            }
        });





        populateProgam();
        populateSettingValues();



       /* mNavItems.add(new NavItem("Studies", "List of Studies ", R.drawable.study));*/
        mNavItems.add(new NavItem("Variable", "Set Variable", R.drawable.variable));
        mNavItems.add(new NavItem("Settings", "Settings", R.drawable.settings));
        mNavItems.add(new NavItem("Help", "How to use the system", R.drawable.help));
        mNavItems.add(new NavItem("About", "Get to know about us", R.drawable.aboutus));

        // DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);



        // Populate the Navigtion Drawer with options
        // mDrawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
        mDrawerList = (ListView) findViewById(R.id.navList);
        DrawerListAdapter adapter = new DrawerListAdapter(this, mNavItems);
        mDrawerList.setAdapter(adapter);

        // Drawer Item click listeners
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItemFromDrawer(position);
            }
        });



        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        //boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        // menu.findItem(R.id.action_search).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }



    private void selectItemFromDrawer(int position) {

/*        if(position==1){
            Intent intent1 = new Intent(StudiesWithNavActivity.this,StudiesActivity.class);
            intent1.putExtra("ACCESS_TOKEN", accessToken);
            intent1.putExtra("USERNAME", username);
            startActivity(intent1);

        }else */
        if(position==0){
            Intent intent = new Intent(StudiesWithNavActivity.this, VariableSetMasterActivity.class);
            intent.putExtra("ACCESSTOKEN", accessToken);
            intent.putExtra("FLAG", 0);
            startActivity(intent);

        }else if(position==1) {
/*            Intent intentSetting = new Intent(StudiesWithNavActivity.this, SettingMainActivity.class);
            startActivityForResult(intentSetting, REQUEST_CODE_SETTING);*/

            Intent intentSetting = new Intent(StudiesWithNavActivity.this, SettingTabsMainActivity.class);
            startActivity(intentSetting);
        }
        else if(position==3) {
/*            Intent intentSetting = new Intent(StudiesWithNavActivity.this, SettingMainActivity.class);
            startActivityForResult(intentSetting, REQUEST_CODE_SETTING);*/

            Intent intentSetting = new Intent(StudiesWithNavActivity.this, AboutActivity.class);
            startActivity(intentSetting);
        }
    }


    private List<StudyListData> getMyStudyList(String filter, String programName) {
        List<StudyListData> toreturn = new ArrayList<StudyListData>();
        try {
            DatabaseMasterTool dbTool = new DatabaseMasterTool(this);
            SQLiteDatabase database = dbTool.getMasterDatabase();
            StudyManager mgr = new StudyManager();
            Cursor cursor = null;
            if (filter == null) {
                cursor = mgr.getAllStudyRecords(database, programName, year, season);
            } else {
                cursor = mgr.getStudyByName(database, filter, programName, year, season);
            }

            if (cursor != null && cursor.getCount() > 0) {

                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String study = cursor.getString(cursor.getColumnIndex("study"));
                        String title = cursor.getString(cursor.getColumnIndex("title"));
                        String year = cursor.getString(cursor.getColumnIndex("year"));
                        String season = cursor.getString(cursor.getColumnIndex("season"));
                        int id = cursor.getInt(cursor.getColumnIndex("id"));
                        String lastCommit = cursor.getString(cursor.getColumnIndex("last_commit"));
                        int uncommited = cursor.getInt(cursor.getColumnIndex("uncommited"));
                        StudyListData rec = new StudyListData();
                        rec.setId(id);
                        rec.setName(name);
                        rec.setStudy(study);
                        rec.setTitle(title);
                        rec.setDateLastCommited(lastCommit);
                        rec.setUncommited(uncommited);
                        rec.setYear(year);
                        rec.setSeason(season);
                        toreturn.add(rec);
                    } while (cursor.moveToNext());
                }
            }

            dbTool.close();
        } catch (Exception e) {

        }
        return toreturn;
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

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

       if (id == android.R.id.home) {
           /*this.finish();
           return true;*/
         }

        switch (item.getItemId()) {
/*            case android.R.id.home:
                Intent nav = new Intent(StudiesActivity.this, NavItemListActivity.class);
                startActivityForResult(nav, REQUEST_CODE_SETTING);
                break;*/

            case R.id.action_loadstudy:
                String urlString = "https://api.breeding4rice.irri.org/v1/studies?accessToken=" + accessToken + "&limit=-1&sort=name&season=" + season + "&year=" + year;
                new JSONTask().execute(urlString);
                break;
            case R.id.action_search:
                if (searchFlag == 0) {
                    tblRowSearch.setVisibility(View.VISIBLE);
                    item.setIcon(R.drawable.search_minus);
                    searchFlag = 1;

                } else {
                    item.setIcon(R.drawable.search);
                    tblRowSearch.setVisibility(View.GONE);
                    searchFlag = 0;
                }
                break;
            case R.id.action_help:
                Intent intent = new Intent(getApplicationContext(), HelpActivity.class);
                intent.putExtra("IMAGE", "help_studies");
                startActivity(intent);
                break;
            case R.id.action_delete_study:
                deleteFlag = 1;
                studyToDelete.clear();
                tblDeleteStudy.setVisibility(View.VISIBLE);
                studyList = getMyStudyList(null, programName);
                lvStudyList = (ListView) findViewById(R.id.lvStudyList);
                adapter = new MyStudyListAdapter(getApplicationContext(), R.layout.activity_studies_list_row, studyList);
                lvStudyList.setAdapter(adapter);

                break;

/*            case R.id.action_variable:
                Intent intent2 = new Intent(StudiesWithNavActivity.this, VariableSetMasterActivity.class);
                intent2.putExtra("ACCESSTOKEN", accessToken);
                intent2.putExtra("FLAG", 0);
                startActivity(intent2);

                break;

            case R.id.action_settings:
                Intent intentSetting = new Intent(StudiesWithNavActivity.this, SettingMainActivity.class);
                startActivityForResult(intentSetting, REQUEST_CODE_SETTING);

                break;*/
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_loadstudy) {

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        StudyListData study = (StudyListData) adapter.getItem(position);
        Intent intent = new Intent(getApplicationContext(), StudyMainActivity.class);
        intent.putExtra("STUDYNAME", study.getName());
        intent.putExtra("ACCESSTOKEN", accessToken);
        //intent.putExtra("NEWRECORD",totalUncommitedRecord);
        startActivity(intent);
    }

    public class MyStudyListAdapter extends ArrayAdapter {

        public List<StudyListData> studyModelEntity;
        private int resource;
        private LayoutInflater inflater;
        String studyName;


        public MyStudyListAdapter(Context context, int resource, List<StudyListData> objects) {
            super(context, resource, objects);
            studyModelEntity = objects;
            this.resource = resource;
            inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            studyToDelete.clear();

        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            try {

                if (convertView == null) {
                    convertView = inflater.inflate(resource, null);
                }

                final TextView tvStudyName;
                final TextView tvName;
                final TextView tvStudyId;
                TextView tvLastSync;
                TextView tvUncommitRecordLabel;
                TextView tvUncommittedRec;
                Button btnSync;
                final CheckBox checkBox;

                tvStudyName = (TextView) convertView.findViewById(R.id.tvStudyName);
                tvName = (TextView) convertView.findViewById(R.id.tvName);
                tvStudyId = (TextView) convertView.findViewById(R.id.tvStudyId);

                tvStudyName.setText(studyModelEntity.get(position).getName());
                tvStudyId.setText(String.valueOf(studyModelEntity.get(position).getId()));

                tvName.setText(studyModelEntity.get(position).getStudy());

                btnSync= (Button) convertView.findViewById(R.id.btnSync);

               btnSync.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        studyName=studyModelEntity.get(position).getName();
                         //Toast.makeText(getApplicationContext(), tvStudyId.getText().toString()+ " "+String.valueOf(String.valueOf(studyModelEntity.get(position).getId())), Toast.LENGTH_SHORT).show();
                        isPosted(studyName);

                        String jsonString=getPlotDataToCommit(studyName);
                        String postUrl;
                        if(is_posted.equals("N")) {
                            postUrl = "https://api.breeding4rice.irri.org/v1/datasets?accessToken=" + accessToken;
                        }else{
                            postUrl = "https://api.breeding4rice.irri.org/v1/datasets/"+transaction_id+"?accessToken=" + accessToken;
                        }

                        new JSONTaskCommitStudy().execute(postUrl, jsonString,is_posted,studyName);
                    }
                });


                if (studyModelEntity.get(position).getDateLastCommited() != null) {
                    tvLastSync = (TextView) convertView.findViewById(R.id.tvLastSync);
                    tvLastSync.setText("Last Sync : " + studyModelEntity.get(position).getDateLastCommited());
                }

                tvUncommitRecordLabel = (TextView) convertView.findViewById(R.id.tvUncommitRecordLabel);
                tvUncommittedRec = (TextView) convertView.findViewById(R.id.tvUncommittedRec);

                checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
                if (deleteFlag == 1) {
                    checkBox.setVisibility(View.VISIBLE);
                } else {
                    checkBox.setVisibility(View.GONE);
                }


                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {
                        try {
                            if (paramAnonymousBoolean) {
                                StudyListModel s = new StudyListModel();
                                s.setId(Integer.valueOf(tvStudyId.getText().toString()));
                                s.setName(tvStudyName.getText().toString());
                                s.setStudyName(tvName.getText().toString());
                                s.setIs_selected(paramAnonymousBoolean);
                                studyToDelete.add(s);
                            } else {
                                int i = 0;
                                for (StudyListModel r : studyToDelete) {
                                    if (r.getId() == Integer.valueOf(tvStudyId.getText().toString())) {
                                        studyToDelete.remove(i);

                                    }
                                    i++;
                                }
                            }
                        } catch (Exception e) {

                        }


                        // String is_selected=String.valueOf(checkBox.getText());
                        // Toast.makeText(getApplicationContext(), tvStudyId.getText().toString()+ " "+String.valueOf(paramAnonymousBoolean), Toast.LENGTH_SHORT).show();


                    }
                });

                String studyTempName = studyModelEntity.get(position).getName();

                int totalUncommitedRecord = getTotalUncommitedRecord(studyModelEntity.get(position).getName());

                if (totalUncommitedRecord > 0) {

                    tvUncommitRecordLabel.setVisibility(View.VISIBLE);
                    tvUncommittedRec.setVisibility(View.VISIBLE);
                    tvUncommittedRec.setText(String.valueOf(totalUncommitedRecord));
                    tvUncommitRecordLabel.setText("New Records: ");
                    btnSync.setVisibility(View.VISIBLE);
                } else {
                    tvUncommitRecordLabel.setVisibility(View.GONE);
                    tvUncommittedRec.setVisibility(View.GONE);
                    btnSync.setVisibility(View.GONE);
                }



            } catch (Exception e) {

            }
            return convertView;
        }

        private int getTotalUncommitedRecord(String studyName) {
            DatabaseMasterTool dbToolStudy = new DatabaseMasterTool(getApplicationContext(), studyName);
            SQLiteDatabase studyDatabase = dbToolStudy.getStudyDatabase(studyName);
            StudyManager mgrStudy = new StudyManager();
            int toreturn = mgrStudy.getPlotRecordUnCommited(studyDatabase);
            dbToolStudy.closeDB(studyDatabase);
            return toreturn;
        }
    }

    public class JSONTask extends AsyncTask<String, String, String> {

        private ProgressDialog Dialog = new ProgressDialog(StudiesWithNavActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Dialog.setMessage(" Please wait while loading the studies");
            Dialog.show();
        }


        @Override
        protected String doInBackground(String... params) {

            HttpURLConnection con = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                con = (HttpURLConnection) url.openConnection();
                con.connect();


                InputStream stream = con.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line;

                while ((line = reader.readLine()) != null) {
                    if (line.contains("DOCTYPE")) {
                        return null;
                    }
                    buffer.append(line);
                }
                return buffer.toString();

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (ProtocolException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }


        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (result != null) {
                Intent intent = new Intent(getApplicationContext(), StudyListActivity.class);
                intent.putExtra("ACCESS_TOKEN", accessToken);
                intent.putExtra("STUDY", result);
                startActivityForResult(intent, REQUEST_CODE);
            } else {
               /* Dialog dialog = new Dialog(getApplicationContext());
                dialog.setContentView(R.layout.messagedialog);
                TextView tvMessage=(TextView) dialog.findViewById(R.id.tvMessageId);
                tvMessage.setText("Cannot connect to web service, Please check your internet connection");
                dialog.show();*/
                AlertDialog alertDialog = new AlertDialog.Builder(
                        StudiesWithNavActivity.this).create();

                // Setting Dialog Title
                alertDialog.setTitle("Connection Error");

                // Setting Dialog Message
                alertDialog.setMessage("Cannot connect to web service. Please check your internet connection");

                // Setting Icon to Dialog
                alertDialog.setIcon(R.drawable.info);

                // Setting OK Button
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog closed
                        //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();


                    }
                });


                // Showing Alert Message
                alertDialog.show();
            }

            Dialog.dismiss();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                /*Bundle extras = data.getExtras();
                final String dataString =extras.getString("data");

                Handler refresh = new Handler(Looper.getMainLooper());
                refresh.post(new Runnable() {
                    public void run() {
                        populateData(dataString);
                    }
                });*/

                studyList.clear();
                studyList = getMyStudyList(null, programName);
                adapter = new MyStudyListAdapter(getApplicationContext(), R.layout.activity_studies_list_row, studyList);
                adapter.notifyDataSetChanged();
                lvStudyList.setAdapter(adapter);

            }

            if (requestCode == REQUEST_CODE_SETTING) {
                populateSettingValues();
            }
        }


    }


    public void actionBtnSearchHide(View v) {
        tblRowSearch.setVisibility(View.GONE);
    }

    public void actionBtnSearchClear(View v) {
        etSearchStudy.setText("");
        etSearchStudy.requestFocus();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }


    public void actionCancel(View v) {
        tblDeleteStudy.setVisibility(View.GONE);
        deleteFlag = 0;
        studyList = getMyStudyList(null, programName);
        lvStudyList = (ListView) findViewById(R.id.lvStudyList);
        adapter = new MyStudyListAdapter(getApplicationContext(), R.layout.activity_studies_list_row, studyList);
        lvStudyList.setAdapter(adapter);
        studyToDelete.clear();
    }

    public void actionDropStudy(View v) {

        if (studyToDelete.size() > 0) {

            DatabaseMasterTool dbTool = new DatabaseMasterTool(this);
            final SQLiteDatabase database = dbTool.getMasterDatabase();
            final StudyManager mgr = new StudyManager();
            StringBuffer studies = new StringBuffer();
            for (StudyListModel r : studyToDelete) {
                studies.append(r.getName().toString() + "\n");
            }


            AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                    StudiesWithNavActivity.this);
            alertDialog.setTitle("Confirm Deletion");
            alertDialog.setMessage("Are you sure you want to delete the following studies?\n" + studies.toString());
            alertDialog.setIcon(R.drawable.info);
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                    tblRowSearch.setVisibility(View.GONE);
                    deleteFlag = 0;
                    for (StudyListModel r : studyToDelete) {
                        // Toast.makeText(getApplicationContext(), r.getName(), Toast.LENGTH_SHORT).show();
                        mgr.deleteStudy(database, r.getName());
                        String f = ApplicationPath.APP_PATH_IMAGES + r.getName();
                        new File(ApplicationPath.APP_PATH_STUDY + r.getName()).delete();
                        new File(ApplicationPath.APP_PATH_STUDY + r.getName() + "-journal").delete();
                    }
                    tblDeleteStudy.setVisibility(View.GONE);
                    studyList = getMyStudyList(null, programName);
                    lvStudyList = (ListView) findViewById(R.id.lvStudyList);
                    adapter = new MyStudyListAdapter(getApplicationContext(), R.layout.activity_studies_list_row, studyList);
                    lvStudyList.setAdapter(adapter);
                    studyToDelete.clear();

                }
            });
            alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            // Showing Alert Message
            alertDialog.show();


        } else {
            Toast.makeText(getApplicationContext(), "No study to delete", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onBackPressed() {
         //super.onBackPressed();
         viewLogoutConfirmDialog();

    }

    private void viewLogoutConfirmDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                StudiesWithNavActivity.this);
        alertDialog.setTitle("Confirm Logout");
        alertDialog.setMessage("Are you sure you want to Logout?");
        alertDialog.setIcon(R.drawable.info);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed
                //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        // Showing Alert Message
        alertDialog.show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        studyList.clear();
        studyList = getMyStudyList(null, programName);
        adapter = new MyStudyListAdapter(getApplicationContext(), R.layout.activity_studies_list_row, studyList);
        adapter.notifyDataSetChanged();
        lvStudyList.setAdapter(adapter);

    }


    private void populateProgam() {
        int i = 0;

        List<String> list = new ArrayList<String>();

        DatabaseMasterTool dbTool = new DatabaseMasterTool(this);
        SQLiteDatabase database = dbTool.getMasterDatabase();
        AccountManager mgr = new AccountManager(database);
        Cursor cursor = mgr.getUserTeamProgram(LoginActivity.getUser_id());

        if (cursor != null && cursor.getCount() > 0) {

            if (cursor.moveToFirst()) {
                do {

                    String name = cursor.getString(cursor.getColumnIndex("program_abbrev"));

                    list.add(name);
                } while (cursor.moveToNext());
            }
        }

        spinnerArray = new String[list.size()];
        for (String rec : list) {
            spinnerArray[i] = rec;
            i++;

        }

        spinnerProgam = (Spinner) findViewById(R.id.spinnerStudiesProgram);
        adapterProgram = new ArrayAdapter<CharSequence>(StudiesWithNavActivity.this, R.layout.spinner_layout, spinnerArray);
        // ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_plot_field, android.R.layout.simple_spinner_item);
        adapterProgram.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProgam.setAdapter(adapterProgram);
        spinnerProgam.setSelection(0);

        spinnerProgam.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        try {
                            programName = spinnerProgam.getSelectedItem().toString();
                            programIndex = position;

                            studyList.clear();
                            studyList = getMyStudyList(null, programName);
                            adapter = new MyStudyListAdapter(getApplicationContext(), R.layout.activity_studies_list_row, studyList);
                            adapter.notifyDataSetChanged();
                            lvStudyList.setAdapter(adapter);


                        } catch (Exception e) {
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
        dbTool.closeDB(database);
    }

    private void populateSettingValues() {
        DatabaseMasterTool dbTool = new DatabaseMasterTool(this);
        SQLiteDatabase database = dbTool.getMasterDatabase();
        StudyManager mgr = new StudyManager();
        Cursor cursorSettings = mgr.getSettingsMaster(database);

        if (cursorSettings != null && cursorSettings.getCount() > 0) {

            if (cursorSettings.moveToFirst()) {
                do {
                    try {
                        year = cursorSettings.getString(cursorSettings.getColumnIndex("year"));
                        season = cursorSettings.getString(cursorSettings.getColumnIndex("season"));
                    } catch (Exception e) {
                        year = "";
                        season = "";
                    }
                } while (cursorSettings.moveToNext());
            }
        }
        dbTool.closeDB(database);
    }

    class NavItem {
        String mTitle;
        String mSubtitle;
        int mIcon;

        public NavItem(String title, String subtitle, int icon) {
            mTitle = title;
            mSubtitle = subtitle;
            mIcon = icon;
        }
    }

    class DrawerListAdapter extends BaseAdapter {

        Context mContext;
        ArrayList<NavItem> mNavItems;

        public DrawerListAdapter(Context context, ArrayList<NavItem> navItems) {
            mContext = context;
            mNavItems = navItems;
        }

        @Override
        public int getCount() {
            return mNavItems.size();
        }

        @Override
        public Object getItem(int position) {
            return mNavItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.activity_navigation_main_drawer_item, null);
            }
            else {
                view = convertView;
            }

            TextView titleView = (TextView) view.findViewById(R.id.title);
            TextView subtitleView = (TextView) view.findViewById(R.id.subTitle);
            ImageView iconView = (ImageView) view.findViewById(R.id.icon);

            titleView.setText( mNavItems.get(position).mTitle );
            subtitleView.setText( mNavItems.get(position).mSubtitle );
            iconView.setImageResource(mNavItems.get(position).mIcon);

            return view;
        }
    }


    public class JSONTaskCommitStudy extends AsyncTask<String,String,String> {

        String studyId;
        private ProgressDialog Dialog = new ProgressDialog(StudiesWithNavActivity.this);
        String is_posted="N";
        String studyName;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Dialog.setMessage(" please wait while processing............");
            Dialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            String response=null;
            try{
                RestClient client = new RestClient(params[0]);
                client.AddHeader("Content-type", "application/json");
                client.AddParam("data", params[1]);
                client.AddParam("Accept", "application/json");
                is_posted=params[2];
                studyName=params[3];


                //client.AddHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");

                try {
                    if(is_posted.equals("N")) {
                        client.Execute(RestClient.RequestMethod.POST);
                        response = client.getResponse();



                    }else{
                        client.Execute(RestClient.RequestMethod.PUT);
                        response = client.getResponse();

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(client.getResponseCode()==401){
                    return null;
                }
              /* String response = client.getResponse();*/

                return response;
            }catch (Exception e){
                return null;
            }

        }

        protected void onPostExecute(String result){
            super.onPostExecute(result);

            if(result!=null) {
                //Toast.makeText(StudyMainActivity.this, result, Toast.LENGTH_LONG).show();

                Gson gson = new Gson();
                CommitMessage commitMessage = gson.fromJson(result, CommitMessage.class);
                if(commitMessage.isSuccess()) {
                    updateCommitHistory(commitMessage);
                    AlertDialog alertDialog = new AlertDialog.Builder(
                            StudiesWithNavActivity.this).create();
                    alertDialog.setTitle("Upload Message");
                    alertDialog.setMessage(commitMessage.getData().getMessage());
                    alertDialog.setIcon(R.drawable.info);
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog closed
                            //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();

                            studyList.clear();
                            studyList = getMyStudyList(null, programName);
                            adapter = new MyStudyListAdapter(getApplicationContext(), R.layout.activity_studies_list_row, studyList);
                            adapter.notifyDataSetChanged();
                            lvStudyList.setAdapter(adapter);
                        }
                    });
                    Dialog.dismiss();
                    alertDialog.show();

                }else{

                    if(commitMessage.getData().getMessage().contains("Transaction is already committed")){
                        updateCommitHistoryReset(commitMessage,studyName);


                        AlertDialog alertDialog = new AlertDialog.Builder(
                                StudiesWithNavActivity.this).create();
                        alertDialog.setTitle("Upload Message");
                        alertDialog.setMessage(commitMessage.getData().getMessage() + "Create new transaction? ");
                        alertDialog.setIcon(R.drawable.info);
                        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog closed
                                //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                                String jsonString=getPlotDataToCommit(studyName);
                                String postUrl;
                                postUrl = "https://api.breeding4rice.irri.org/v1/datasets?accessToken=" + accessToken;
                                new JSONTaskCommitStudy().execute(postUrl, jsonString,"N",studyName);

                            }
                        });
                        Dialog.dismiss();
                        alertDialog.show();
                    }
                }



                //setResult(RESULT_OK, null);
                // finish();

            }else{
                AlertDialog alertDialog = new AlertDialog.Builder(
                        StudiesWithNavActivity.this).create();
                alertDialog.setTitle("Upload Error Message");
                alertDialog.setMessage("Error uploading plot data. Please check your internet connection");
                alertDialog.setMessage(result);
                alertDialog.setIcon(R.drawable.info);
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog closed
                        //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                    }
                });
                Dialog.dismiss();
                alertDialog.show();
            }
        }

        private void updateCommitHistory(CommitMessage result) {

            try {
                // create new study database
                String transMsg = result.getData().getMessage().toString();
                String[] s = transMsg.split(" ");
                String sname=studyName;

                DatabaseMasterTool dbToolStudy = new DatabaseMasterTool(getApplicationContext(), studyName);
                SQLiteDatabase studyDatabase = dbToolStudy.getStudyDatabase(studyName);
                StudyManager mgrStudy = new StudyManager();
                mgrStudy.updatePlotRecordCommited(studyDatabase);
                if (is_posted.equals("N")) {
                    ContentValues cv = new ContentValues();
                    DateUtil cdate = new DateUtil();
                    cv.put("remarks", result.getData().getMessage());
                    int transaction_id = Integer.valueOf(s[s.length - 1]);
                    cv.put("transaction_id", transaction_id);
                    cv.put("date_commit", cdate.getDate());
                    mgrStudy.insertCommitHistory(studyDatabase, cv);
                    dbToolStudy.closeDB(studyDatabase);

                    // update master list study

                    // insert study record to master table
                    DatabaseMasterTool dbTool = new DatabaseMasterTool(getApplicationContext());
                    SQLiteDatabase database = dbTool.getMasterDatabase();
                    StudyManager mgr = new StudyManager();
                    mgr.updateStudyCommitTranscation(database, studyName, transaction_id);
                    isPosted(studyName);
                    dbTool.closeDB(database);
                }

            }catch(Exception e){

            }

        }
    }

    private void updateCommitHistoryReset(CommitMessage result,String studyName) {

        try {
            // create new study database
            String transMsg = result.getData().getMessage().toString();
            String[] s = transMsg.split(" ");
            String sname=studyName;


            // insert study record to master table
            DatabaseMasterTool dbTool = new DatabaseMasterTool(getApplicationContext());
            SQLiteDatabase database = dbTool.getMasterDatabase();
            StudyManager mgr = new StudyManager();
            mgr.updateStudyCommitTranscationToNo(database, sname, transaction_id);
            isPosted(studyName);
            dbTool.closeDB(database);


        }catch(Exception e){

        }


}

    private void isPosted(String studyName){
        DatabaseMasterTool dbTool = new DatabaseMasterTool(getApplicationContext());
        SQLiteDatabase database = dbTool.getMasterDatabase();
        StudyManager mgr = new StudyManager();
        Cursor cursor =mgr.getStudy(database, studyName);

        if(cursor != null && cursor.getCount() > 0){

            if (cursor.moveToFirst()) {
                do {
                    is_posted=cursor.getString(cursor.getColumnIndex("is_posted"));
                    transaction_id=cursor.getInt(cursor.getColumnIndex("transaction_id"));
                } while (cursor.moveToNext());
            }
        }

        dbTool.closeDB(database);
    }

    private String getPlotDataToCommit(String studyName) {

        DatabaseMasterTool dbToolStudy = new DatabaseMasterTool(getApplicationContext(),studyName);
        SQLiteDatabase studyDatabase=dbToolStudy.getStudyDatabase(studyName);
        StudyManager mgrStudy = new StudyManager();
        Cursor plotData=mgrStudy.getPlotDataToCommit(studyDatabase);

        List<PlotDataCommitModel> plotDataList= new ArrayList<PlotDataCommitModel>();

        if(plotData != null && plotData.getCount() > 0){

            if (plotData.moveToFirst()) {
                do {
                    PlotDataCommitModel plot= new PlotDataCommitModel();
                    String plot_key=plotData.getString(plotData.getColumnIndex("plot_key"));
                    int variable_id=plotData.getInt(plotData.getColumnIndex("variable_id"));
                    String value=plotData.getString(plotData.getColumnIndex("value"));
                    plot.setIdentifier_key(plot_key);
                    plot.setVariable_id(variable_id);
                    plot.setValue(value);
                    plot.setRemarks("");
                    plot.setData_unit("plot");
                    plotDataList.add(plot);
                } while (plotData.moveToNext());
            }
        }

        Gson gson = new Gson();

        dbToolStudy.closeDB(studyDatabase);


        return gson.toJson(plotDataList);
    }

}
