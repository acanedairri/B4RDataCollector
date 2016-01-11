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
    private static final String DBNAME="master";



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

        db.execSQL(TableData.CREATE_USER_TABLE);
        db.execSQL(TableData.CREATE_STUDY_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDBMaster(){
        database = getWritableDatabase();
    }

    public void openDb(String dbName){
        String myPath = ApplicationPath.AppFolderStudy + dbName;
        database = SQLiteDatabase.openDatabase(myPath, null,
                SQLiteDatabase.OPEN_READWRITE);
        setDatabase(database);
    }

    public void closeDB(){

        if(database != null && database.isOpen()){
            database.close();
        }

    }

    public void createStudyDatabase(String studyname) {
        boolean dbExist = checkDataBase(studyname);
        String myPath = ApplicationPath.AppFolderStudy + studyname;
        if (dbExist) {
            context.deleteDatabase(ApplicationPath.AppFolderStudy + studyname);
            database = context.openOrCreateDatabase(myPath, Context.MODE_WORLD_WRITEABLE, null);
        }else {
            database = context.openOrCreateDatabase(myPath, Context.MODE_WORLD_WRITEABLE, null);
        }
    }

    public void openStudyDatabase(String databaseName) throws SQLException {

        // Open the database
        String myPath = ApplicationPath.AppFolderStudy + databaseName;
        database = SQLiteDatabase.openDatabase(myPath, null,
                SQLiteDatabase.OPEN_READWRITE);
        setDatabase(database);
    }

    public void createStudyDatabaseTable(SQLiteDatabase db){
        db.execSQL(TableData.CREATE_STUDY_TABLE);
        db.execSQL(TableData.CREATE_STUDY_METADATA_TABLE);
        db.execSQL(TableData.CREATE_VARIABLE_SET_TABLE);
        db.execSQL(TableData.CREATE_VARIABLE_MEASURING_TABLE);
        db.execSQL(TableData.CREATE_PLOT_HEADER_TABLE);


    }


    public void createStudyPlotTable(SQLiteDatabase db,String header) {

        try {
            int i;
            String querryString;
            querryString=TableData.CREATE_STUDY_PLOT_TABLE;

            String[] h=header.split(",");

            for(String s:h){
                querryString += ",`"+s;
                querryString +="` TEXT";
            }

            db.execSQL(querryString);

        } catch (SQLException ex) {
            Log.i("CreateDB Exception ",ex.getMessage());
        }
    }


    private boolean checkDataBase(String databaseName) {

        SQLiteDatabase checkDB = null;

        try {
            String myPath =ApplicationPath.AppFolderStudy + databaseName;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            // database does't exist yet.
        }

        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }
}
