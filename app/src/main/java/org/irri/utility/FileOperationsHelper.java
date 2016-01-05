package org.irri.utility;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ACañeda on 2015-12-10.
 */
public class FileOperationsHelper {
    private static FileOperationsHelper ourInstance;

    public static FileOperationsHelper getInstance()
    {
        if(ourInstance == null){
            ourInstance =  new FileOperationsHelper();
        }
        return ourInstance;
    }

    private FileOperationsHelper() {

    }

    public void saveFile(Context context,String fileName,String data) throws IOException {

        FileOutputStream fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
        fileOutputStream.write(data.getBytes());
        fileOutputStream.close();

    }

    public String readFile(Context context,String fileName) throws IOException {

        FileInputStream fileInputStream = context.openFileInput((fileName));
        InputStreamReader inputStreamReader = new InputStreamReader((fileInputStream));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        StringBuffer buffer = new StringBuffer();

        while((line=bufferedReader.readLine())!= null){
            buffer.append(line);

        }


        return buffer.toString();
    }
}
