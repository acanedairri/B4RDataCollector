package org.irri.database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


import org.irri.constant.AppDirectory;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

public class DatabaseStudyHelper extends SQLiteOpenHelper {


    // The Android's default system path of your application database.

    // In the Galaxy Tab, the true SD Card path needs to have /external_sd/ to be appended
    private SQLiteDatabase database;
    private final Context myContext;
    private static String DB_NAME;



    /**
     * Constructor Takes and keeps a reference of the passed context in order to
     * access to the application assets and resources.
     *
     * @param context
     * @param dbName
     */

    public DatabaseStudyHelper(Context context, String dbName) {

        super(context, dbName, null, 1);
        this.myContext = context;
        setDB_NAME(dbName);
        //		myDataBase = this.getWritableDatabase();
    }



    public static String getDB_NAME() {

        return DB_NAME;
    }

    public static void setDB_NAME(String dB_NAME)
    {
        DB_NAME = dB_NAME;
    }

    public SQLiteDatabase getDataBase() {

        return database;
    }

    public void setDataBase(SQLiteDatabase database)
    {
        this.database = database;
    }

    public Context getMyContext() {
        return myContext;
    }

    /**
     * Creates a empty database on the system and rewrites it with your own
     * database.
     */
    public void createDataBase(String databaseName) throws IOException {

        boolean dbExist = checkDataBase(databaseName);

        if (dbExist) {
            // Open the database for reading and writing.
            openDatabase(databaseName);
        } else {

            // By calling this method an empty database will be created into
            // the default system path
            // of your application so we are gonna be able to overwrite that
            // database with our database.
            //			this.getReadableDatabase();
            try {
                copyDatabaseMaster(databaseName);
                openDatabase(databaseName);

            } catch (IOException e) {
                throw new Error("Error encountered while copying database!");
            }
        }
    }


    public void createDatabaseMaster(String databaseName) throws IOException {
        //If database not exists copy it from the assets

        boolean mDataBaseExist = checkDataBase(databaseName);
        if (!mDataBaseExist) {
            try {
                //Copy the database from assests
                copyDatabaseMaster(databaseName);
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    /**
     * Check if the database already exist to avoid re-copying the file each
     * time you open the application.
     *
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase(String databaseName) {

        SQLiteDatabase checkDB = null;

        try {
            String myPath =AppDirectory.DB_PATH + databaseName;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            // database does't exist yet.
        }

        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    private void copyDatabaseMaster(String databaseName) throws IOException {
        InputStream mInput = myContext.getAssets().open("master");
        String outFileName = AppDirectory.DB_PATH + databaseName;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    /**
     * Copies your database from your local assets-folder to the just created
     * empty database in the system folder, from where it can be accessed and
     * handled. This is done by transfering bytestream.
     */
    private void copyDataBaseMasterToExternalDrive(String databaseName) throws IOException {

        // Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open("master");

        boolean mExternalStorageAvailable = false;
        boolean mExternalStorageWriteable = false;
        String state = Environment.getExternalStorageState();
        Log.i("SD-STATE", state);

        if (Environment.MEDIA_MOUNTED.equals(state)) {

            // We can read and write the media
            mExternalStorageAvailable = mExternalStorageWriteable = true;

        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            // We can only read the media
            mExternalStorageAvailable = true;
            mExternalStorageWriteable = false;
        } else {
            // Something else is wrong. It may be one of many other states, but all we need
            //  to know is we can neither read nor write
            mExternalStorageAvailable = mExternalStorageWriteable = false;

        }
        String outFileName = "";
        if (mExternalStorageAvailable && mExternalStorageWriteable) {
            // Create the db file in the sd card
            outFileName = AppDirectory.DATABASE_FOLDER + databaseName;

        } else {
            // Path to the system db
            outFileName = AppDirectory.DATABASE_FOLDER + databaseName;
        }

        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        // transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDatabase(String databaseName) throws SQLException {

        // Open the database
        String myPath = AppDirectory.DB_PATH + databaseName;
        database = SQLiteDatabase.openDatabase(myPath, null,
                SQLiteDatabase.OPEN_READWRITE);
        setDataBase(database);
    }


    public void openDatabaseExternal(String myPath,String databaseName) throws SQLException, IOException {

        File dir = new File(AppDirectory.DATABASE_FOLDER);
        if (!dir.exists())
            dir.mkdirs();
        File file = new File(dir, databaseName);
        if (!file.exists())
            file.createNewFile();
        // Open or create the database from the specified path
        database = SQLiteDatabase.openOrCreateDatabase(myPath, null);
        setDataBase(database);

    }

    public void createStudyDatabase(Context context, String databasename){
        String myPath = AppDirectory.DB_PATH + databasename;
        database = context.openOrCreateDatabase(myPath, Context.MODE_WORLD_WRITEABLE, null);
    }

    public void createStudyTables(){

    }


    public void createDynamicDatabase(Context context, String tableName, ArrayList<String> title) {

        try {

            int i;
            String querryString;
            String myPath = AppDirectory.DB_PATH + DB_NAME;
            database = context.openOrCreateDatabase(myPath, Context.MODE_WORLD_WRITEABLE, null);         //Opens database in writable mode.

            //System.out.println("Table Name : "+tableName.get(0));

            querryString = title.get(0) + " TEXT,";
            for (i = 1; i < title.size() - 1; i++) {
                querryString += title.get(i);
                querryString += " TEXT";
                querryString += ",";
            }
            querryString += title.get(i) + " TEXT";
            querryString = "CREATE TABLE IF NOT EXISTS " + tableName + "(" + querryString + ");";

            database.execSQL(querryString);

        } catch (SQLException ex) {
            Log.i("CreateDB Exception ", ex.getMessage());
        }
    }


    @Override
    public synchronized void close() {
        if (database != null)
            database.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
