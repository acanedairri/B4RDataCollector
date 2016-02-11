package org.irri.database;

/**
 * Created by ACañeda on 2015-11-27.
 */
public class TableData {

    public static String TABLE_USER= "user";
    public static String CREATE_USER_TABLE="CREATE TABLE `user` (" +
            "        `_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "        `user_id` INTEGER," +
            "        `username` TEXT," +
            "        `password` TEXT," +
            "        `user_type` TEXT," +
            "        `status` TEXT," +
            "        `display_name` TEXT," +
            "        `program_abbrev` TEXT," +
            "        `program_display_name` TEXT," +
            "        `valid_start_date` TEXT," +
            "        `valid_end_date` TEXT," +
            "        `creation_timestamp` TEXT," +
            "        `access_token` TEXT," +
            "        `access_token_expire` TEXT" +
            "        );";

     public static String TABLE_STUDY="study";

     public static String CREATE_STUDY_TABLE="CREATE TABLE `study` (" +
                "`_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "`id` INTEGER," +
                "`userid` INTEGER," +
                "`transaction_id` TEXT," +
                "`program` TEXT," +
                "`place` TEXT," +
                "`phase` TEXT," +
                "`year` TEXT," +
                "`season` TEXT," +
                "`name` TEXT," +
                "`title` TEXT," +
                "`creation_timestamp` TEXT" +
                "`modification_timestamp` TEXT," +
                "`notes` TEXT," +
                "`key` TEXT," +
                "`number` INTEGER," +
                "`last_commit` TEXT," +
                "`uncommited` INTEGER," +
                "`is_uploaded` TEXT" +
                ");";

    public static String CREATE_STUDY_LIST="CREATE TABLE `study_list` (" +
            "`_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`studyid` INTEGER," +
            "`last_commit` TEXT," +
            "`uncommited` INTEGER," +
            "`name` TEXT" +
            ");";

    public static String CREATE_STUDY_METADATA_TABLE="CREATE TABLE `study_metadata` (" +
            "`_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`id` INTEGER," +
            "`userid` INTEGER," +
            "`transaction_id` TEXT," +
            "`variable` TEXT," +
            "`value` TEXT" +
            ");";

    public static String CREATE_STUDY_COMMIT_HISTORY="CREATE TABLE `commit_history` (" +
            "`_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`id` INTEGER," +
            "`userid` INTEGER," +
            "`transaction_id` INTEGER," +
            "`date_commit` TEXT," +
            "`remarks` TEXT," +
            "`checksum` TEXT" +
            ");";

    public static String CREATE_PLOT_TABLE="CREATE TABLE `plot` (" +
            "`_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`recno` INTEGER,"+
            "`plot_key` TEXT,"+
            "`rep` INTEGER,"+
            "`code` TEXT,"+
            "`plotno` INTEGER,"+
            "`entno` INTEGER,"+
            "`entcode` TEXT,"+
            "`designation` TEXT,"+
            "`parentage` TEXT,"+
            "`generation` TEXT,"+
            "`qr_code` TEXT,"+
            "`fldrow_cont` TEXT,"+
            "`fldcol_cont` TEXT"+
            ");";

    public static String CREATE_PLOT_DATA="CREATE TABLE `plot_data` (" +
            "`_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`plot_key` TEXT," +
            "`plotno` TEXT," +
            "`qr_code` TEXT," +
            "`variable_id` INTEGER," +
            "`abbrev` TEXT," +
            "`value` TEXT," +
            "`userid` TEXT," +
            "`date_commited` TEXT," +
            "`last_modified` TEXT," +
            "`committed` TEXT," +
            "`timestamp` TEXT"+
            ");";

    public static String CREATE_SETTINGS="CREATE TABLE `settings` (" +
            "`_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`datafield1` TEXT," +
            "`datafield2` TEXT," +
            "`datafield3` TEXT," +
            "`datafield4` TEXT," +
            "`last_recno` INTEGER" +
            ");";

    public static String CREATE_VARIABLE_SET_TABLE="CREATE TABLE `variable_set` (" +
            "`_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`variable_set_name` TEXT," +
            "`variable_id` INTEGER," +
            "`abbrev` TEXT," +
            "`label` TEXT," +
            "`name` TEXT," +
            "`data_type` TEXT," +
            "`display_name` TEXT," +
            "`scale_value` TEXT," +
            "`is_selected` TEXT" +
            ");";

    public static String CREATE_VARIABLE_MEASURING_TABLE="CREATE TABLE `variable_measuring` (" +
            "`_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`variable_id` INTEGER," +
            "`abbrev` TEXT," +
            "`label` TEXT," +
            "`name` TEXT," +
            "`data_type` TEXT," +
            "`display_name` TEXT," +
            "`scale_value` TEXT," +
            "`is_selected` TEXT" +
            "`order` INTEGER" +
            ");";

    public static String CREATE_PLOT_HEADER_TABLE="CREATE TABLE `plot_header` (" +
            "`_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`name` TEXT," +
            "`is_hidden` TEXT"+
            ");";


}
