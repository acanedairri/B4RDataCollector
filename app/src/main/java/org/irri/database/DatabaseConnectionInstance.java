package org.irri.database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class DatabaseConnectionInstance {

	private static final int READ_BLOCK_SIZE = 100;

	public DatabaseConnectionInstance(){

	}

	public String findPath(FileInputStream fIn){

		try
		{
			InputStreamReader isr = new InputStreamReader(fIn);
			char[] inputBuffer = new char[READ_BLOCK_SIZE];
			String s = "";
			int charRead;
			while ((charRead = isr.read(inputBuffer))>0)
			{
				//---convert the chars to a String---
				String readString =
					String.copyValueOf(inputBuffer, 0,
							charRead);
				s += readString;
				inputBuffer = new char[READ_BLOCK_SIZE];
			}
			return s;
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return "";
	}


	public void savePath(FileOutputStream fOut, String databasePath){
		try
		{
			OutputStreamWriter osw = new OutputStreamWriter(fOut);
			osw.write(databasePath);
			osw.flush();
			osw.close();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	
}
