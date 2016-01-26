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
    private static String tblStudyList = "study_list";
    public StudyManager() {

    }


    public Cursor getAllStudyRecords(SQLiteDatabase database) {
        Cursor cursor = null;
        try {
            String sql = "SELECT * from study";
            cursor = database.rawQuery(sql, null);
            return cursor;
        } catch (SQLiteException e) {

        }
        return cursor;
    }

    public Cursor getSettings(SQLiteDatabase database) {
        Cursor cursor = null;
        try {
            String sql = "SELECT * from settings";
            cursor = database.rawQuery(sql, null);
            return cursor;
        } catch (SQLiteException e) {

        }
        return cursor;
    }

    public Cursor getStudyByName(SQLiteDatabase database,String studyName) {
        Cursor cursor = null;
        try {
            String sql = "SELECT * from study where lower(name) like '%"+studyName.toLowerCase()+"%'";
            cursor = database.rawQuery(sql, null);
            return cursor;
        } catch (SQLiteException e) {

        }
        return cursor;
    }

    public Cursor getPlotRecords(SQLiteDatabase database,int recno) {
        Cursor cursor = null;
        try {
            String sql = "SELECT * from plot where recno="+recno;
            cursor = database.rawQuery(sql, null);
            return cursor;
        } catch (SQLiteException e) {

        }
        return cursor;
    }

    public Cursor getAllPlotRecords(SQLiteDatabase database) {
        Cursor cursor = null;
        try {
            String sql = "SELECT * from plot";
            cursor = database.rawQuery(sql, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        } catch (SQLiteException e) {

        }
        return cursor;
    }

    public Cursor getRecordByName(SQLiteDatabase database,String name) {
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

    public Cursor getStudyMetaData(SQLiteDatabase database,int study_id) {
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

    public Cursor getVariableSet(SQLiteDatabase database) {
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

    public Cursor getVariableSet(SQLiteDatabase database,String filter) {
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

    public Cursor getVariableSetByAbbrev(SQLiteDatabase database,String abbrev) {
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


    public Cursor getStudyBasicInfo(SQLiteDatabase database) {
        try {
            String sql = "SELECT * from study";
            Cursor cursor = database.rawQuery(sql, null);
            return cursor;
        } catch (SQLiteException e) {

        }
        return null;
    }

    public Cursor getStudyMetaData(SQLiteDatabase database) {
        try {
            String sql = "SELECT * from study_metadata";
            Cursor cursor = database.rawQuery(sql, null);
            return cursor;
        } catch (SQLiteException e) {

        }
        return null;
    }

    public void insertStudyBasicInfoRecord(SQLiteDatabase database,ContentValues cvalues) {
        try {
            database.insert(tblName, null, cvalues);
        } catch (SQLiteException e) {

        }
    }


    public void insertStudyMetaData(SQLiteDatabase database,ContentValues cvalues) {
        try {
            database.insert(tblStudyMetadata, null, cvalues);
        } catch (SQLiteException e) {

        }
    }

    public void insertPlotData(SQLiteDatabase database,ContentValues cvalues){
        try {
            //String query="Insert into plot ("+header +") values ("+recno+","+values+")";
            database.insert(tblPlot, null, cvalues);

        } catch (SQLiteException e) {

        }
    }

    public void insertPlot(SQLiteDatabase database,ContentValues cvalues){
        try {
            //String query="Insert into plot ("+header +") values ("+recno+","+values+")";
            database.insert(tblPlot, null, cvalues);

        } catch (SQLiteException e) {
            System.out.println("error");
        }
    }

    public void insertPlotHeader(SQLiteDatabase database, ContentValues cvalues){
        try {
            database.insert(tblPlotHeader, null, cvalues);
        } catch (SQLiteException e) {

        }
    }

    public void insertVariableSet(SQLiteDatabase database,ContentValues cvalues){
        try {
            database.insert(tblVariableSet, null, cvalues);
        } catch (SQLiteException e) {

        }
    }

    public void insertStudyList(SQLiteDatabase database,ContentValues cvalues){
        try {
            database.insert(tblStudyList, null, cvalues);
        } catch (SQLiteException e) {

        }
    }

    public void updateRecord(SQLiteDatabase database,int id, String field, String value) {
        try {
            ContentValues args = new ContentValues();
            args.put("`" + field + "`", value);
            database.update(tblName, args, "id=" + id, null);
        } catch (SQLiteException e) {

        }
    }

    public void updateSettingsDataField(SQLiteDatabase database,String field, String value) {
        try {
            ContentValues args = new ContentValues();
            args.put("`" + field + "`", value);
            database.update("settings", args, null, null);
        } catch (SQLiteException e) {

        }
    }

    public void populateRecords(List<Study.DataEntity.ItemsEntity> records){


    }

    public void updateVariableSet(SQLiteDatabase database,String abbrev, String is_selected) {
        String query="Update variable_set set is_selected='"+is_selected+"' where abbrev='"+abbrev+"'";
        database.execSQL(query);
    }

    public Cursor getVariableSetSelected(SQLiteDatabase database) {
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

    public void deleteStudyList(SQLiteDatabase database) {
        String query="Delete from study_list";
        database.execSQL(query);
    }


    public Cursor getAllStudyList(SQLiteDatabase database) {
        Cursor cursor = null;
        try {
            String sql = "SELECT * from study_list";
            cursor = database.rawQuery(sql, null);
            return cursor;
        } catch (SQLiteException e) {

        }
        return cursor;
    }

    public Cursor getStudyListByName(SQLiteDatabase database,String filter) {
        Cursor cursor = null;
        try {
            String sql = "SELECT * from study_list where name like  '%"+filter+"%'";
            cursor = database.rawQuery(sql, null);
            return cursor;
        } catch (SQLiteException e) {

        }
        return cursor;
    }
}
