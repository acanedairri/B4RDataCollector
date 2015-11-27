package org.irri.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import org.irri.entity.Study;

import java.util.List;

/**
 * Created by ACañeda on 2015-11-13.
 */
public class StudyManager {

    private SQLiteDatabase database;
    private static String tblName = "study";

    public StudyManager(SQLiteDatabase database) {
        this.database = database;
    }


    public Cursor getAllRecords() {
        try {
            String sql = "SELECT * from study";
            Cursor cursor = database.rawQuery(sql, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        } catch (SQLiteException e) {

        }
        return null;
    }

    public Cursor getRecordByName(String name) {
        try {
            String sql = "SELECT * from study where name ='" + name + "'";
            Cursor cursor = database.rawQuery(sql, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        } catch (SQLiteException e) {

        }
        return null;
    }

    public Cursor getStudyMetaData(int study_id) {
        try {
            String sql = "SELECT * from study_metadata where id =" + study_id;
            Cursor cursor = database.rawQuery(sql, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        } catch (SQLiteException e) {

        }
        return null;
    }

    public void insertRecord(ContentValues cvalues) {
        try {
            database.insert(tblName, null, cvalues);
        } catch (SQLiteException e) {

        }
    }

    public void updateRecord(int id, String field, String value) {
        try {
            ContentValues args = new ContentValues();
            args.put("`" + field + "`", value);
            database.update(tblName, args, "id=" + id, null);
        } catch (SQLiteException e) {

        }
    }

    public void populateRecords(List<Study.DataEntity.ItemsEntity> records){


    }

}
