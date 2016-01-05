package org.irri.database;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import org.irri.constant.AppDirectory;

import java.io.File;

/**
 * Created by ACañeda on 2015-12-17.
 */
public class DatabaseContext extends ContextWrapper{

    private static final String DEBUG_CONTEXT = "DatabaseContext";
    public DatabaseContext(Context base) {
        super(base);
    }



    /* this version is called for android devices >= api-11. thank to @damccull for fixing this. */
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        return openOrCreateDatabase(name,mode, factory);
    }

    /* this version is called for android devices < api-11 */
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory)
    {  String myPath = AppDirectory.DATABASE_FOLDER + name;
        SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(myPath, null);
        // SQLiteDatabase result = super.openOrCreateDatabase(name, mode, factory);
        if (Log.isLoggable(DEBUG_CONTEXT, Log.WARN))
        {
            Log.w(DEBUG_CONTEXT,
                    "openOrCreateDatabase(" + name + ",,) = " + result.getPath());
        }
        return result;
    }
}
