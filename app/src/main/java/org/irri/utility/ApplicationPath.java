package org.irri.utility;

import android.os.Environment;

import java.io.File;

/**
 * Created by ACañeda on 2015-12-10.
 */
public class ApplicationPath {

/*    public static final String APP_PATH = Environment.getExternalStorageDirectory().getAbsolutePath()+"/B4RDataCollector-V1.0";

    public static String APP_PATH_STUDY=APP_PATH+"/B4RDataCollector/study/";
    public static String APP_PATH_LOG=APP_PATH+"/B4RDataCollector/log/";

    public  static String STUDY_FOLDER="study";*/

    public static final String APP_PATH = Environment.getExternalStorageDirectory().getAbsolutePath()+"/B4RDataCollector-V1.0";
    public static final String APP_PATH_MASTER =Environment.getExternalStorageDirectory().getAbsolutePath()+ "/B4Rtemp";

    public static String APP_PATH_STUDY=APP_PATH+"/study/";
    public static String APP_PATH_LOG=APP_PATH+"/log/";

    public  static String STUDY_FOLDER="study";



}
