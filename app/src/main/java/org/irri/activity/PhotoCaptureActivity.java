package org.irri.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import org.irri.utility.ApplicationPath;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PhotoCaptureActivity extends AppCompatActivity
{
	//protected Button btnTakePhoto;
	//private Button btnCloseCamera;
	protected ImageView _image;
	protected TextView _field;
	protected String photoFile;
	protected boolean _taken;
	private String databaseName;
	private String photoName;
	private int currentEditTextId;
	String STUDY_IMAGE_FOLDER;
	Calendar now;
	protected static final String PHOTO_TAKEN	= "photo_taken";
		
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_photocapture);
        Bundle extras = getIntent().getExtras();
		if (extras != null) {
			databaseName = extras != null ? extras.getString("DBNAME") : null;
			photoName = extras != null ? extras.getString("PHOTO_NAME") : null;
			currentEditTextId=extras.getInt("CURRENTTEXTID");
//			SNAME=extras.getString("SNAME");
		}
        
        _image = ( ImageView ) findViewById( R.id.image );
        _field = ( TextView ) findViewById( R.id.field );
/*        btnTakePhoto = ( Button ) findViewById( R.id.button );
        btnTakePhoto.setOnClickListener( new ButtonClickHandler() );*/
    	STUDY_IMAGE_FOLDER= ApplicationPath.APP_PATH_IMAGES;
    	now = GregorianCalendar.getInstance();
        photoFile = STUDY_IMAGE_FOLDER + "/"+photoName+"_"+String.valueOf(now.getTimeInMillis())+".jpg";
        
        File file = new File( photoFile );
    	Uri outputFileUri = Uri.fromFile( file );
    	
    	Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE );
    	intent.putExtra( MediaStore.EXTRA_OUTPUT, outputFileUri );

    	startActivityForResult(intent, 0);

/*    	btnCloseCamera= (Button) findViewById(R.id.btnCloseCamera);
    	btnCloseCamera.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// Perform action on clicks
				Bundle bundle = new Bundle();
				bundle.putInt("CURRENTTEXTID", currentEditTextId);
		    	Intent mIntent = new Intent();
		    	mIntent.putExtras(bundle);
		    	setResult(RESULT_OK, mIntent);
		    	finish();
			}
		});*/


    }

    public class ButtonClickHandler implements View.OnClickListener
    {
    	public void onClick( View view ){
    		Log.i("MakeMachine", "ButtonClickHandler.onClick()" );
    		startCameraActivity();
    	}
    }

    protected void startCameraActivity()
    {
    	Log.i("MakeMachine", "startCameraActivity()" );
    	now = GregorianCalendar.getInstance();
        photoFile = STUDY_IMAGE_FOLDER + "/"+photoName+"_"+String.valueOf(now.getTimeInMillis())+".jpg";
    	File file = new File( photoFile );
    	Uri outputFileUri = Uri.fromFile( file );

    	Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE );
    	intent.putExtra( MediaStore.EXTRA_OUTPUT, outputFileUri );
    	
    	startActivityForResult( intent, 0 );
 
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) 
    {	
    	Log.i("MakeMachine", "resultCode: " + resultCode);
    	switch( resultCode )
    	{
    		case 0:
    			Log.i( "MakeMachine", "User cancelled" );
    			break;
    			
    		case -1:
    			onPhotoTaken();
    			break;
    	}
    	
		Bundle bundle = new Bundle();       	
		bundle.putInt("CURRENTTEXTID", currentEditTextId);
    	Intent mIntent = new Intent();
    	mIntent.putExtras(bundle);
    	setResult(RESULT_OK, mIntent);
    	
    	//finish();
    }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_photo_capture, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		if(id==android.R.id.home){

			this.finish();
			return true;
		}

		//noinspection SimplifiableIfStatement
		if(id == R.id.action_photo) {
			startCameraActivity();

		}else if(id==R.id.action_close){
			Bundle bundle = new Bundle();
			bundle.putInt("CURRENTTEXTID", currentEditTextId);
			Intent mIntent = new Intent();
			mIntent.putExtras(bundle);
			setResult(RESULT_OK, mIntent);
			finish();

		}


		return super.onOptionsItemSelected(item);
	}



	protected void onPhotoTaken()
    {
    	Log.i( "MakeMachine", "onPhotoTaken" );
    	
    	_taken = true;
    	
    	BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4;
    	
    	Bitmap bitmap = BitmapFactory.decodeFile( photoFile, options );
    	
    	_image.setImageBitmap(bitmap);
    	
    	_field.setVisibility( View.GONE );
    }
    
    @Override 
    protected void onRestoreInstanceState( Bundle savedInstanceState){
    	Log.i( "MakeMachine", "onRestoreInstanceState()");
    	if( savedInstanceState.getBoolean( PhotoCaptureActivity.PHOTO_TAKEN ) ) {
    		onPhotoTaken();
    	}
    }
    
    @Override
    protected void onSaveInstanceState( Bundle outState ) {
    	outState.putBoolean( PhotoCaptureActivity.PHOTO_TAKEN, _taken );
    }
}