package org.irri.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.intermec.aidc.*;

public class BarcodeActivity extends Activity implements BarcodeReadListener{
	
	private com.intermec.aidc.BarcodeReader bcr;
	private ListView barcodeList;
	private EditText etBarcode;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_barcode);	
		
		//set lock the orientation 
		//otherwise, the onDestory will trigger
		//when orientation changes
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		etBarcode = (EditText) findViewById(R.id.etBarcode);
		
		try {
			//get bar code instance from MainActivity
			bcr = SettingBarcodeActivity.getBarcodeObject();
			
			if(bcr != null)
			{
				//enable scanner
				bcr.setScannerEnable(true);
				
				//set listener
				bcr.addBarcodeReadListener(this);	
			}
			
		} catch (BarcodeReaderException e) {			
			e.printStackTrace();
		}
		
		//get initial list
		barcodeList = (ListView) findViewById(R.id.listViewBarcodeData);
	}
	
	@Override
	public void barcodeRead(BarcodeReadEvent aBarcodeReadEvent)
	{

		etBarcode.setText(aBarcodeReadEvent.getBarcodeData());

      	List<String> list = new ArrayList<String>();
      	list.add("Device ID: " + aBarcodeReadEvent.getDeviceId());
      	list.add("Barcode data: " + aBarcodeReadEvent.getBarcodeData());
      	list.add("Symbolgy ID: " + aBarcodeReadEvent.getSymbolgyId());
    	list.add("Symbolgy Name: " + aBarcodeReadEvent.getSymbologyName());
      	list.add("Udsi: " + aBarcodeReadEvent.getUdsi());
      	list.add("Aim: " + aBarcodeReadEvent.getAim());
      	list.add("Code mark: " + aBarcodeReadEvent.getCodeMark());
      	list.add("Timestamp: " + aBarcodeReadEvent.getTimestamp());     	
            	
      	final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
      	  		android.R.layout.simple_list_item_1, list);  
      	
    	//update UI list			
		runOnUiThread(new Runnable() {
			
			@Override
			public void run() {				
				barcodeList.setAdapter(dataAdapter);				 
			}
		});		
	}
}
