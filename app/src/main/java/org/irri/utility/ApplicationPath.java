package org.irri.utility;

import android.os.Environment;

/**
 * Created by ACañeda on 2015-12-10.
 */
public class ApplicationPath {

    public static String AppFolder=Environment.getExternalStorageDirectory().getAbsolutePath().toString()+"/B4RDataCollector";
    public static String AppFolderStudy=Environment.getExternalStorageDirectory().getAbsolutePath().toString()+"/B4RDataCollector/study/";

    public  static String STUDY_FOLDER="study";
}
