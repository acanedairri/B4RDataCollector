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
                "`place` INTEGER," +
                "`phase` INTEGER," +
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

    public static String CREATE_STUDY_NETADATA_TABLE="CREATE TABLE `study_metadata` (" +
            "`_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`id` INTEGER," +
            "`userid` INTEGER," +
            "`transaction_id` TEXT," +
            "`variable` TEXT," +
            "`value` TEXT" +
            ");";


}
