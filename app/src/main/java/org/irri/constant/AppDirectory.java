package org.irri.constant;

import android.os.Environment;

/**
 * Created by ACañeda on 2015-11-12.
 */
public class AppDirectory {

    public static String AppPath= Environment.getExternalStorageDirectory().getAbsolutePath()+"/B4R";
    //static String AppPath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/external_sd/B4R";
    public  static String DATABASE_FOLDER   =   AppPath+"/database/";
    public  static String DEFAULT_FOLDER    =   AppPath+"/default/";
    public  static String MAINTENANCE_FOLDER=   AppPath+"/maintenance/";
    public  static String MORPHO_FOLDER     =   AppPath+"/maintenance/Morpho Valid Values/";
    public  static String EXPORT_FOLDER     =   AppPath+"/export data/";
    public  static String IMPORT_FOLDER     =   AppPath+"/import data/";
    public  static String IMAGES_FOLDER     =   AppPath+"/images/";
    public  static String AUDIO_FOLDER      =   AppPath+"/audio/";
    public static String LOG_FOLDER         =   AppPath+"/log/";
    public  static String APPLICATION_PATH  =   AppPath;
    public static String DB_PATH            =   "/data/data/org.irri.b4rdatacollectorapp/database/";
}
