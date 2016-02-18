package org.irri.utility;

import android.os.Environment;

import java.io.File;

/**
 * Created by ACañeda on 2015-12-10.
 */
public class ApplicationPath {

    public static final String APP_PATH = Environment.getExternalStorageDirectory().getAbsolutePath()+"/B4RDataCollector";

    public static String APP_PATH_STUDY=Environment.getExternalStorageDirectory().getAbsolutePath()+"/B4RDataCollector/study/";
    public static String APP_PATH_LOG=Environment.getExternalStorageDirectory().getAbsolutePath()+"/B4RDataCollector/log/";

    public  static String STUDY_FOLDER="study";
}
