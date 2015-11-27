package org.irri.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ACañeda on 2015-11-27.
 */
public class DatabaseTool extends SQLiteOpenHelper {

    private final Context context;
    private SQLiteDatabase database;
    private static final String DBNAME="master";



    public DatabaseTool(Context context) {
        super(context, DBNAME, null, 1);
        this.context = context;

    }

    public DatabaseTool(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDB(){
        database = getWritableDatabase();
    }

    public void closeDB(){

        if(database != null && database.isOpen()){
            database.close();
        }

    }

}
