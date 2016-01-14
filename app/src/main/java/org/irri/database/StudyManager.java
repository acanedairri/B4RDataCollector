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
    private static String tblStudyMetadata = "study_metadata";
    private static String tblPlotHeader = "plot_header";
    private static String tblPlot = "plot";
    private static String tblVariableSet = "variable_set";
    public StudyManager(SQLiteDatabase database) {
        this.database = database;
    }


    public Cursor getAllRecords() {
        Cursor cursor = null;
        try {
            String sql = "SELECT * from study";
            cursor = database.rawQuery(sql, null);
            return cursor;
        } catch (SQLiteException e) {

        }
        return cursor;
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

    public Cursor getVariableSet() {
        try {
            String sql = "SELECT * from variable_set";
            Cursor cursor = database.rawQuery(sql, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        } catch (SQLiteException e) {

        }
        return null;
    }

    public Cursor getVariableSet(String filter) {
        try {
            String sql = "SELECT * from variable_set where abbrev like '"+filter+"%'";
            Cursor cursor = database.rawQuery(sql, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        } catch (SQLiteException e) {

        }
        return null;
    }

    public Cursor getVariableSetByAbbrev(String abbrev) {
        try {
            String sql = "SELECT * from variable_set where abbrev='"+abbrev+"'";
            Cursor cursor = database.rawQuery(sql, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        } catch (SQLiteException e) {

        }
        return null;
    }


    public Cursor getStudyBasicInfo() {
        try {
            String sql = "SELECT * from study";
            Cursor cursor = database.rawQuery(sql, null);
            return cursor;
        } catch (SQLiteException e) {

        }
        return null;
    }

    public Cursor getStudyMetaData() {
        try {
            String sql = "SELECT * from study_metadata";
            Cursor cursor = database.rawQuery(sql, null);
            return cursor;
        } catch (SQLiteException e) {

        }
        return null;
    }

    public void insertStudyBasicInfoRecord(ContentValues cvalues) {
        try {
            database.insert(tblName, null, cvalues);
        } catch (SQLiteException e) {

        }
    }


    public void insertStudyMetaData(ContentValues cvalues) {
        try {
            database.insert(tblStudyMetadata, null, cvalues);
        } catch (SQLiteException e) {

        }
    }

    public void insertPlotData(String header,int recno,String values){
        try {
            String query="Insert into plot ("+header +") values ("+recno+","+values+")";
            database.execSQL(query);
        } catch (SQLiteException e) {

        }
    }

    public void insertPlotHeader(ContentValues cvalues){
        try {
            database.insert(tblPlotHeader, null, cvalues);
        } catch (SQLiteException e) {

        }
    }

    public void insertVariableSet(ContentValues cvalues){
        try {
            database.insert(tblVariableSet, null, cvalues);
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

    public void updateVariableSet(String abbrev, String is_selected) {
        String query="Update variable_set set is_selected='"+is_selected+"' where abbrev='"+abbrev+"'";
        database.execSQL(query);
    }

    public Cursor getVariableSetSelected() {
        try {
            String sql = "SELECT * from variable_set where is_selected='true'";
            Cursor cursor = database.rawQuery(sql, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        } catch (SQLiteException e) {

        }
        return null;
    }
}
