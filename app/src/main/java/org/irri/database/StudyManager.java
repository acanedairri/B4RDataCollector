package org.irri.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import org.irri.entity.Study;
import org.irri.utility.DateUtil;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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


    public Cursor getAllStudyRecords(SQLiteDatabase database,String program) {
        Cursor cursor = null;
        try {
            String sql = "SELECT * from study where program='"+program+"'";
            cursor = database.rawQuery(sql, null);
            return cursor;
        } catch (SQLiteException e) {

        }
        return cursor;
    }

    public Cursor getAllStudyCommitHistory(SQLiteDatabase database) {
        Cursor cursor = null;
        try {
            String sql = "SELECT * from commit_history order by transaction_id desc";
            cursor = database.rawQuery(sql, null);
            return cursor;
        } catch (SQLiteException e) {

        }
        return cursor;
    }

    public Cursor getAllStudyCommitHistory(SQLiteDatabase database,String filter) {
        Cursor cursor = null;
        try {
            String sql = "SELECT * from commit_history";
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

    public Cursor getStudyByName(SQLiteDatabase database,String studyName,String program) {
        Cursor cursor = null;
        try {
            String sql = "SELECT * from study where lower(studyname) like '%"+studyName.toLowerCase()+"%' or lower(name) like '%"+studyName.toLowerCase()+"%' and program='"+program+"'";
            cursor = database.rawQuery(sql, null);
            return cursor;
        } catch (SQLiteException e) {

        }
        return cursor;
    }


    public Cursor getStudy(SQLiteDatabase database,String studyName) {
        Cursor cursor = null;
        try {
            String sql = "SELECT * from study where name='"+studyName+"'" ;
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

    public Cursor getPlotData(SQLiteDatabase database,String plotNo,int variable_id) {
        Cursor cursor = null;
        try {
            String sql = "SELECT * from plot_data where plotno='"+plotNo+"' and variable_id="+variable_id;
            cursor = database.rawQuery(sql, null);
            return cursor;
        } catch (SQLiteException e) {

        }
        return cursor;
    }

    public Cursor getPlotRecordByPlotNo(SQLiteDatabase database,int plotNo) {
        Cursor cursor = null;
        try {
            String sql = "SELECT * from plot where plotno="+plotNo;
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

    public Cursor getVariableSet(SQLiteDatabase database,String  variableSetName) {
        try {
            String sql = "SELECT * from variable_set where variable_set_name='"+variableSetName+"' order by abbrev";
            Cursor cursor = database.rawQuery(sql, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        } catch (SQLiteException e) {

        }
        return null;
    }

    public Cursor getVariableSet(SQLiteDatabase database,String filter,String variableSetName) {
        try {
            String sql = "SELECT * from variable_set where variable_set_name='"+variableSetName+"' and  abbrev like '"+filter+"%' order by abbrev";
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

    public void updateStudyCommitTranscation(SQLiteDatabase database,String studyName,int trans_id) {
        try {
            DateUtil cdate= new DateUtil();
            String sql="update study set is_posted='Y', last_commit='"+cdate.getDate()+"', transaction_id="+trans_id+" where name='"+studyName+"'";
            database.execSQL(sql);
        } catch (SQLiteException e) {
            System.out.println(e);
        }
    }


    public void isPosted(SQLiteDatabase database,String studyName){
        try {

            String sql="select is";
            database.execSQL(sql);
        } catch (SQLiteException e) {
            System.out.println(e);
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
            System.out.println(e);
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

    public void updateSettingsDataField(SQLiteDatabase database, String datafield1,String datafield2,String datafield3,String datafield4) {
        try {
            String sql="Update settings set datafield1='"+datafield1+"', datafield2='"+datafield2+"',datafield3='"+datafield3+"',datafield4='"+datafield4+"'";
           database.execSQL(sql);
        } catch (SQLiteException e) {
            System.out.println(e.toString());
        }
    }

    public void insertPlotRecord(SQLiteDatabase database,ContentValues contentValues) {
        try {
            database.insert("plot_data", null, contentValues);
        } catch (SQLiteException e) {

        }
    }

    public void updatePlotRecord(SQLiteDatabase database,String newValue,int plotNo,int variable_id ,String dateUpdated) {
        try {
            String sql="Update plot_data set value='"+newValue+"',last_modified='"+dateUpdated+"',committed='N' where plotno="+plotNo+" and variable_id="+variable_id;
            database.execSQL(sql);
        }catch (SQLiteException e) {

        }
    }

    public void updatePlotRecordCommited(SQLiteDatabase database) {
        try {
            Date date = new Date();
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long time = date.getTime();
            //Passed the milliseconds to constructor of Timestamp class
            Timestamp ts = new Timestamp(time);
            String dtd=fmt.format(ts);
            String sql="Update plot_data set committed='Y', date_commited='"+dtd+"'";
            database.execSQL(sql);
        }catch (SQLiteException e) {

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

    public Cursor getPlotDataToCommit(SQLiteDatabase database) {

        Cursor cursor = null;
        try {
            String sql = "SELECT * from plot_data where committed='N'";
            cursor = database.rawQuery(sql, null);
            return cursor;
        } catch (SQLiteException e) {

        }
        return cursor;
    }

    public int getPlotRecordUnCommited(SQLiteDatabase database) {

        Cursor cursor = null;
        try {
            String sql = "SELECT count(*) from plot_data where committed='N'";
            cursor = database.rawQuery(sql, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor.getInt(0);
        } catch (SQLiteException e) {

        }
        return 0;
    }

    public Cursor getVariableSetList(SQLiteDatabase database) {

        Cursor cursor = null;
        try {
            String sql = "SELECT distinct variable_set_name from variable_set";
            cursor = database.rawQuery(sql, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        } catch (SQLiteException e) {

        }
        return cursor;
    }

    public void removeVariableSet(SQLiteDatabase database,String variableSetName) {
        try {
           // String sql = "delete from variable_set where lower(variable_set_name)='"+variableSetName.toLowerCase()+"'";
 /*           String sql = "Delete from variable_set";
            database.rawQuery(sql, null);*/

            database.delete("variable_set", "variable_set_name" + "=?",
                    new String[] { variableSetName});

        } catch (SQLiteException e) {
            System.out.println(e);

        }
    }

    public boolean isExistRecord(SQLiteDatabase database, int plotNo, int variable_id) {
        try {
            String sql = "SELECT * from plot_data where plotno="+plotNo+" and variable_id="+variable_id;
            Cursor cursor = database.rawQuery(sql, null);
            if(cursor != null && cursor.getCount() > 0){
                cursor.moveToFirst();
                return true;
            }

        } catch (SQLiteException e) {

        }


        return false;
    }


    public boolean isStudyExist(SQLiteDatabase database,int studyId) {
        try {
            String sql = "SELECT * from study where id="+studyId;
            Cursor cursor = database.rawQuery(sql, null);
            if(cursor != null && cursor.getCount() > 0){
                cursor.moveToFirst();
                return true;
            }

        } catch (SQLiteException e) {

        }


        return false;
    }

    public void insertCommitHistory(SQLiteDatabase database,ContentValues cv) {

        try {
            database.insert("commit_history", null, cv);
        } catch (SQLiteException e) {

        }

    }

    public void updateSettingsLastRow(SQLiteDatabase database, int rec) {
        String sql="Update settings set last_recno="+rec;

        try {
            database.execSQL(sql);
        } catch (SQLiteException e) {
            System.out.println(e.toString());
        }
    }
}
