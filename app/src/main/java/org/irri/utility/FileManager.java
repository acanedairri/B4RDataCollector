package org.irri.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;

import org.irri.constant.AppDirectory;

public class FileManager {


	public FileManager(){

	}

	public void createAppFolders(Context context) throws IOException  {
		// TODO Auto-generated method stub

		String tmp= ApplicationPath.APP_PATH;
		String masterDir=ApplicationPath.APP_PATH_MASTER;
		File f = new File(tmp);


		if(!f.exists()){
			File appDirectory = new File(tmp);
			appDirectory.mkdirs();

			File appDirectoryMaster = new File(masterDir);
			appDirectoryMaster.mkdirs();



			File folderStudy = new File(ApplicationPath.APP_PATH_STUDY);
			folderStudy.mkdirs();

			File folderLog = new File(ApplicationPath.APP_PATH_LOG);
			folderLog.mkdirs();

		}

	}
	

	private static void copyFile(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[1024];
		int read;
		while((read = in.read(buffer)) != -1){
			out.write(buffer, 0, read);
		}
	}

	public boolean createNewDatabaseFile(Context context,AssetManager assets,String studyName){

		File f = new File(context.getFilesDir()+"/"+ApplicationPath.STUDY_FOLDER+"/"+studyName);

		if(f.exists()){
			return false;
		}else{

			String[] files = null;
			try {
				files = assets.list("");
			} catch (IOException e) {
				Log.e("tag", e.getMessage());
			}
			for(String filename : files) {
				InputStream in = null;
				OutputStream out = null;
				try {
					in = assets.open(filename);
					if(filename.contains("study")){
						out = new FileOutputStream(context.getFilesDir()+"/"+ApplicationPath.STUDY_FOLDER+"/"+filename);
						copyFile(in, out);
						in.close();
						in = null;
						out.flush();
						out.close();
						out = null;
						break;
					}

				} catch(Exception e) {
					Log.e("tag", e.getMessage());
				}
			}

			//rename the file

			File from = new File(context.getFilesDir()+"/"+ApplicationPath.STUDY_FOLDER+"/","study");
			File to = new File(context.getFilesDir()+"/"+ApplicationPath.STUDY_FOLDER+"/",studyName);
			from.renameTo(to);
			return true;
		}

	}

	
}
