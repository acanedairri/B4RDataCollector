package org.irri.helper;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

/**
 * Created by ACañeda on 2015-11-12.
 */
public class IntentHelper {

    public Intent getIntentExcel(String fileName){
        Intent intent = new Intent();
        intent.setAction(android.content.Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(new File(fileName)), "application/vnd.ms-excel");
        return intent;
    }


    public Intent getIntentPowerpoint(String fileName){
        Intent intent = new Intent();
        intent.setAction(android.content.Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(new File(fileName)), "application/vnd.ms-powerpoint");
        return intent;
    }


    public static Intent openXLS(String filename){

        try {
            IntentHelper  helper = new IntentHelper();
            Intent intent= helper.getIntentExcel(filename);
            return intent;
        }
        catch (ActivityNotFoundException e) {
            // Toast.makeText(OpenPdf.this, "No Application Available to View Excel", Toast.LENGTH_SHORT).show();
        }
        return null;
    }

    public static Intent openPowerpoint(String filename){
        try {
            IntentHelper  helper = new IntentHelper();
            Intent intent= helper.getIntentPowerpoint(filename);
            return intent;
        }
        catch (ActivityNotFoundException e) {
            // Toast.makeText(OpenPdf.this, "No Application Available to View Excel", Toast.LENGTH_SHORT).show();
        }
        return null;
    }
}
