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


    public void insertUserTeam(ContentValues values,SQLiteDatabase db) {
        try {
            db.insert(TableData.TABLE_USER_TEAM, null, values);
        }catch(Exception e){

        }
    }

    public void deleteUserTeam(int id,SQLiteDatabase db) {
        try {
            String sql="delete from user_team where user_id="+id;
            database.execSQL(sql);
        }catch(Exception e){

        }
    }

    public void update(SQLiteDatabase db,String username,String password,int id,String accessToken) {
        try {
            String sql="update user set username='"+username+"', password='"+password+"',access_token='"+accessToken+"' where user_id="+id;
            database.execSQL(sql);
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


    public Cursor getUserTeamProgram(int userid) {

        String sql = "Select * from user_team where user_id="+userid ;
        Cursor cursor = database.rawQuery(sql, null);

        if (cursor != null)
            cursor.moveToFirst();
        return cursor;
    }


    public boolean isUserExist(int id) {

        String sql = "Select * from "+TableData.TABLE_USER +" where user_id="+id;
        Cursor cursor = database.rawQuery(sql, null);

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            return true;
        }
        return false;
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
