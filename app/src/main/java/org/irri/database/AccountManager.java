package org.irri.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ACañeda on 2015-11-27.
 */
public class AccountManager {

    private SQLiteDatabase database;

    public AccountManager(SQLiteDatabase database) {
        this.database = database;
    }

    public void insert(ContentValues values,SQLiteDatabase db) {
        try {
            db.insert(TableData.TABLE_USER, null, values);
        }catch(Exception e){

        }
    }

    public Cursor getAccountList() {

        String sql = "Select * from "+TableData.TABLE_USER;
        Cursor cursor = database.rawQuery(sql, null);

        if (cursor != null)
            cursor.moveToFirst();
        return cursor;
    }

    public Cursor getUserToken(SQLiteDatabase database,String username, String password){
        String sql="Select * from user where username='"+username+"' and password='"+password+"'";
        Cursor cursor = database.rawQuery(sql, null);
        return cursor;
    }


    public Cursor getAllUserToken(SQLiteDatabase database){
        String sql="Select * from user";
        Cursor cursor = database.rawQuery(sql, null);
        return cursor;
    }




}
