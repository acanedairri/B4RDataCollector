package org.irri.utility;

import android.content.res.AssetManager;

import org.irri.constant.AppDirectory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by ACañeda on 2015-11-12.
 */
public class AppSetting {

    public void createAppFolders(AssetManager assets) throws IOException {

        File f = new File(AppDirectory.APPLICATION_PATH);

        if (f.exists() && f.isDirectory()) {
            return;

        } else {
            File FieldLabDirectory = new File(AppDirectory.APPLICATION_PATH);
            FieldLabDirectory.mkdirs();

            File database_folder = new File(AppDirectory.DATABASE_FOLDER);
            database_folder.mkdirs();

            File exportFolder = new File(AppDirectory.EXPORT_FOLDER);
            exportFolder.mkdirs();

            File imagesFolder = new File(AppDirectory.IMAGES_FOLDER);
            imagesFolder.mkdirs();

            File audioFolder = new File(AppDirectory.AUDIO_FOLDER);
            audioFolder.mkdirs();

            File logFolder = new File(AppDirectory.LOG_FOLDER);
            logFolder.mkdirs();

            File fAudioData = new File(AppDirectory.AUDIO_FOLDER);
            fAudioData.mkdirs();

            this.CopyFileFromAssets(assets);
        }
    }

    private void CopyFileFromAssets(AssetManager assets) throws IOException {
        String[] files = null;
        try {
            files = assets.list("");
        } catch (IOException e) {
        }
        try {

            InputStream inFieldLabGuide = assets.open("manual.ppt");
            OutputStream outFieldLabGuide = new FileOutputStream(AppDirectory.MAINTENANCE_FOLDER + "manual.ppt");
            copyFile(inFieldLabGuide, outFieldLabGuide);
            inFieldLabGuide.close();
            outFieldLabGuide.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }
}
