package org.irri.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.irri.constant.AppDirectory;
import org.irri.utility.ApplicationPath;

import java.util.ArrayList;

/**
 * Created by ACañeda on 2015-11-27.
 */
public class DatabaseMasterTool extends SQLiteOpenHelper {

    private  Context context;
    private SQLiteDatabase database;
    private SQLiteDatabase databaseStudy;
    private static final String DBNAME="temp";



    public DatabaseMasterTool(Context context) {
        super(context, DBNAME, null, 1);
        this.context = context;

    }



    public DatabaseMasterTool(Context context, String databaseName )
    {
        super(new DatabaseContext(context), databaseName, null, 1);

    }


    public DatabaseMasterTool(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
        this.context = context;
        Log.d("Database", "Database Created");
    }

    public Context getContext() {
        return context;
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }

    public void setDatabase(SQLiteDatabase database) {
        this.database = database;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void closeDB(SQLiteDatabase database){

        if(database != null && database.isOpen()){
            database.close();
        }

    }

    public SQLiteDatabase createStudyDatabase(Context context,String studyname) {
        SQLiteDatabase database = null;
        boolean dbExist = checkDataBase(studyname);
        String myPath = ApplicationPath.APP_PATH_STUDY+studyname;
        if(!dbExist) {
            //context.deleteDatabase(ApplicationPath.AppFolderStudy +"/"+studyname);
            database = context.openOrCreateDatabase(myPath, Context.MODE_WORLD_WRITEABLE, null);
            createStudyDatabaseTable(database);
        }
        return database;
    }


    public void createMasterDatabase(Context context,String master) {
        SQLiteDatabase database = null;
        boolean dbExist = checkDataBaseMaster(master);
        String myPath = ApplicationPath.APP_PATH_MASTER+"/"+master;
        if(!dbExist) {
            database = context.openOrCreateDatabase(myPath, Context.MODE_WORLD_WRITEABLE, null);
            createMasterTables(database);
        }

    }



    public SQLiteDatabase getStudyDatabase(String databaseName) throws SQLException {

        // Open the database
        String myPath = ApplicationPath.APP_PATH_STUDY+ databaseName;
        SQLiteDatabase database = SQLiteDatabase.openDatabase(myPath, null,
                SQLiteDatabase.OPEN_READWRITE);
        return database;
    }

    public SQLiteDatabase getMasterDatabase() throws SQLException {

        // Open the database
        String myPath = ApplicationPath.APP_PATH_MASTER+"/master";
        SQLiteDatabase database = SQLiteDatabase.openDatabase(myPath, null,
                SQLiteDatabase.OPEN_READWRITE);
        return database;
    }

    public SQLiteDatabase createMasterTables(SQLiteDatabase db) {
        try {
            db.execSQL(TableData.CREATE_USER_TABLE);
            db.execSQL(TableData.CREATE_STUDY_TABLE);
            db.execSQL(TableData.CREATE_STUDY_LIST);
        }catch (Exception e){

        }
        return db;
    }

    public void createStudyDatabaseTable(SQLiteDatabase db){
        try {
            db.execSQL(TableData.CREATE_VARIABLE_SET_TABLE);
            db.execSQL(TableData.CREATE_SETTINGS);
            db.execSQL(TableData.CREATE_STUDY_TABLE);
            db.execSQL(TableData.CREATE_STUDY_METADATA_TABLE);
            db.execSQL(TableData.CREATE_VARIABLE_MEASURING_TABLE);
            db.execSQL(TableData.CREATE_PLOT_TABLE);
            db.execSQL(TableData.CREATE_PLOT_DATA);
            db.execSQL(TableData.CREATE_STUDY_COMMIT_HISTORY);
            populateSettingValues(db);
        }catch (Exception e){

        }
    }

    private void populateSettingValues(SQLiteDatabase db) {
        ContentValues contentSettings = new ContentValues();
        contentSettings.put("datafield1","plotno");
        contentSettings.put("datafield2","rep");
        contentSettings.put("datafield3","entno");
        contentSettings.put("datafield4","designation");
        db.insert("settings", null, contentSettings);

    }



    private boolean checkDataBase(String databaseName) {

        SQLiteDatabase checkDB = null;

        try {
            String myPath =ApplicationPath.APP_PATH_STUDY + databaseName;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            // database does't exist yet.
        }

        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    private boolean checkDataBaseMaster(String databaseName) {

        SQLiteDatabase checkDB = null;

        try {
            String myPath =ApplicationPath.APP_PATH_MASTER+ "/"+ databaseName;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            System.out.println("a");
            return false;
        }

        if (checkDB != null) {
            checkDB.close();
        }
        return true;
    }
}
