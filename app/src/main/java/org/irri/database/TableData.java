package org.irri.database;

/**
 * Created by ACañeda on 2015-11-27.
 */
public class TableData {

    public static String TABLE_USER= "user";
    public static String CREATE_USER_TABLE="CREATE TABLE `user` (\n" +
            "        `_id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "        `user_id`\tINTEGER,\n" +
            "        `username`\tTEXT,\n" +
            "        `password`\tTEXT,\n" +
            "        `user_type`\tTEXT,\n" +
            "        `status`\tTEXT,\n" +
            "        `display_name`\tTEXT,\n" +
            "        `program_abbrev`\tTEXT,\n" +
            "        `program_display_name`\tTEXT,\n" +
            "        `valid_start_date`\tINTEGER,\n" +
            "        `valid_end_date`\tINTEGER,\n" +
            "        `creation_timestamp`\tINTEGER,\n" +
            "        `access_token`\tTEXT,\n" +
            "        `access_token_expire`\tTEXT\n" +
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
                "`is_uploaded` TEXT" +
                ");";

    public static String CREATE_STUDY_METADATA_TABLE="CREATE TABLE `study_metadata` (" +
            "`_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`id` INTEGER," +
            "`userid` INTEGER," +
            "`transaction_id` TEXT," +
            "`variable` TEXT," +
            "`value` TEXT" +
            ");";

    public static String CREATE_STUDY_PLOT_TABLE="CREATE TABLE `plot` (" +
            "`_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`recno` INTEGER";

    public static String CREATE_VARIABLE_SET_TABLE="CREATE TABLE `variable_set` (" +
            "`_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`variable_id` INTEGER," +
            "`abbrev` TEXT," +
            "`label` TEXT," +
            "`name` TEXT," +
            "`data_type` TEXT," +
            "`display_name` TEXT," +
            "`scale_value` TEXT" +
            ");";

    public static String CREATE_VARIABLE_MEASURING_TABLE="CREATE TABLE `variable_measuring` (" +
            "`_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`variable_id` INTEGER," +
            "`abbrev` TEXT," +
            "`label` TEXT," +
            "`name` TEXT," +
            "`data_type` TEXT," +
            "`display_name` TEXT," +
            "`scale_value` TEXT" +
            ");";

    public static String CREATE_PLOT_HEADER_TABLE="CREATE TABLE `plot_header` (" +
            "`_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`name` TEXT," +
            "`is_hidden` TEXT"+
            ");";


}
