package org.irri.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.irri.constant.Authentication;
import org.irri.database.AccountManager;
import org.irri.database.DatabaseStudyHelper;
import org.irri.database.DatabaseMasterTool;
import org.irri.database.StudyManager;
import org.irri.entity.AccessToken;
import org.irri.entity.StudyListData;
import org.irri.utility.ApplicationPath;
import org.irri.utility.FileManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoginActivity extends ActionBarActivity {
    private static String name;
    private int REQUEST_CODE = 0X1;
    private AccessToken accessToken;
    private Gson gson;
    private EditText password;
    private String token = "EWlri8UzqBKnetM52qL3LByrVu92DROQznl5nAbN";
    private String versionName;
    private int versionNum;
    private static int user_id;
    private static String program;
    Spinner spinnerUser;
    ArrayAdapter<CharSequence> adapter;
    String[] spinnerArray;
    private String userName;


    public static int getUser_id() {
        return user_id;
    }

    public static String getProgram() {
        return program;
    }

    public static String getName() {
        return name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupAppFolder();
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.b4rlogo);
        createDirs();
        createMasterDatabase();
        populateUser();


    }

    private void setupAppFolder() {
        FileManager fileManager = new FileManager();
        try {
            fileManager.createAppFolders(getApplicationContext());
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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


    public void onStartOauth(View v) {


        Intent intent = new Intent(this, EasySocialAuthActivity.class);
        intent.putExtra(EasySocialAuthActivity.URL, Authentication.LOGIN_URL);
        intent.putExtra(EasySocialAuthActivity.REDIRECT_URL, Authentication.REDIRECT_URI);
        intent.putExtra(EasySocialAuthActivity.ACCESS_TOKEN, Authentication.ACCESS_TOKEN_URL);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void actionLogin(View v) {

        password = (EditText) findViewById(R.id.txtPassword);
        DatabaseMasterTool dbTool = new DatabaseMasterTool(this);
        SQLiteDatabase database = dbTool.getMasterDatabase();
        AccountManager mgr = new AccountManager(database);

        Cursor cursor = mgr.getUserToken(database, userName, password.getText().toString());


/*        if(cursor != null && cursor.getCount() > 0){

            if (cursor.moveToFirst()) {
                do {
                    String name=cursor.getString(cursor.getColumnIndex("username"));
                    String password=cursor.getString(cursor.getColumnIndex("password"));

                } while (cursor.moveToNext());
            }
        }*/


        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            token = cursor.getString(cursor.getColumnIndex("access_token"));
            user_id = cursor.getInt(cursor.getColumnIndex("user_id"));
            program = cursor.getString(cursor.getColumnIndex("program"));
            name = cursor.getString(cursor.getColumnIndex("display_name"));
            System.out.println(program);
            /*Intent intent = new Intent(getApplicationContext(), StudiesActivity.class);*/
           // Intent intent = new Intent(getApplicationContext(), NavigationMainActivity.class);
            Intent intent = new Intent(getApplicationContext(), StudiesWithNavActivity.class);
            intent.putExtra("ACCESS_TOKEN", token);
            intent.putExtra("USERNAME", name);
            startActivity(intent);

        } else {
            //Toast.makeText(this, "Invalid User", Toast.LENGTH_LONG).show();
/*            Intent intent = new Intent(getApplicationContext(), StudiesActivity.class);
            intent.putExtra("ACCESS_TOKEN", token);
            startActivity(intent);*/


            AlertDialog alertDialog = new AlertDialog.Builder(
                    LoginActivity.this).create();
            alertDialog.setTitle("Error Message");
            alertDialog.setMessage("Invalid User");
            alertDialog.setIcon(R.drawable.info);
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write your code here to execute after dialog closed
                    //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                }
            });
            alertDialog.show();

        }

        dbTool.closeDB(database);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                String accessTokenString = data.getStringExtra("data");
                gson = new Gson();
                accessToken = gson.fromJson(accessTokenString, AccessToken.class);
                String token = accessToken.getAccess_token();
                // _ResponseShowTestView.setText(token);;
                Intent intent = new Intent(this, RegisterUserActivity.class);
                intent.putExtra("ACCESS_TOKEN", token);
                startActivity(intent);

            }
        } else if (resultCode == RESULT_CANCELED) {
            if (requestCode == REQUEST_CODE) {
                //  Toast.makeText(this, data.getIntExtra("Error getting access token", 0) + "", Toast.LENGTH_LONG).show();
            }
        }

    }

    private void createDirs() {
        createDir(ApplicationPath.APP_PATH);
        createDir(ApplicationPath.APP_PATH_STUDY);
        createDir(ApplicationPath.APP_PATH_IMAGES);
    }


    private void createDir(String path) {
        File dir = new File(path);
        File blankFile = new File(path);

        if (!dir.exists()) {
            dir.mkdirs();

/*            try {
                blankFile.getParentFile().mkdirs();
                blankFile.createNewFile();
                scanFile(blankFile);
            } catch (IOException e) {
                //ErrorLog("DirectoryError.txt", "" + e.getMessage());
            }*/
        }
    }

    private void scanFile(File filePath) {
        MediaScannerConnection.scanFile(this, new String[]{filePath.getAbsolutePath()}, null, null);
    }

    private void checkNewVersion() {
        final PackageManager packageManager = this.getPackageManager();

        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(this.getPackageName(), 0);
            versionName = packageInfo.versionName;
            versionNum = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            versionName = null;
        }


    }

    public void createMasterDatabase() {

        try {

            DatabaseMasterTool dbTool = new DatabaseMasterTool(this);
            dbTool.createMasterDatabase(this, "master");

        } catch (Exception e) {
            Toast.makeText(this, "Error getting user information", Toast.LENGTH_LONG).show();
        }
    }


    private void populateUser() {
        int i = 0;

        List<String> list = new ArrayList<String>();

        DatabaseMasterTool dbTool = new DatabaseMasterTool(this);
        SQLiteDatabase database = dbTool.getMasterDatabase();
        AccountManager mgr = new AccountManager(database);
        Cursor cursor = mgr.getAccountList();

        if (cursor != null && cursor.getCount() > 0) {

            if (cursor.moveToFirst()) {
                do {

                    String name = cursor.getString(cursor.getColumnIndex("username"));

                    list.add(name);
                } while (cursor.moveToNext());
            }
        }

        spinnerArray = new String[list.size()];
        for (String rec : list) {
            spinnerArray[i] = rec;
            i++;

        }

        spinnerUser = (Spinner) findViewById(R.id.spinnerUser);
        adapter = new ArrayAdapter<CharSequence>(LoginActivity.this, android.R.layout.simple_spinner_item, spinnerArray);
        // ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_plot_field, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUser.setAdapter(adapter);
        spinnerUser.setSelection(0);

        spinnerUser.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        try {
                            userName = spinnerUser.getSelectedItem().toString();

                        } catch (Exception e) {
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

    }

    @Override
    protected void onResume() {
        super.onResume();
        populateUser();
    }
}
