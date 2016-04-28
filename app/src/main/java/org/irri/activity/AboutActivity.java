package org.irri.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class AboutActivity extends Activity {
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
			
	}
	
	
}