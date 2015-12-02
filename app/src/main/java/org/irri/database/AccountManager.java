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

    public void insert(ContentValues values) {
        database.insert(TableData.TABLE_USER, null, values);
    }

    public Cursor getAccountList() {

        String sql = "Select * from "+TableData.TABLE_USER;
        Cursor cursor = database.rawQuery(sql, null);

        if (cursor != null)
            cursor.moveToFirst();
        return cursor;
    }

    public Cursor getUserToken(String username, String password){
        String sql="Select * from "+TableData.TABLE_USER + " where username='"+username+"' and password='"+password+"'";
        Cursor cursor = database.rawQuery(sql, null);
        return cursor;
    }




}
