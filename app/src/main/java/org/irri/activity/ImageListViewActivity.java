package org.irri.activity;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

import org.irri.adapter.ImageItemListBaseAdapter;
import org.irri.entity.ImagesItemDetails;
import org.irri.utility.ImageManager;

public class ImageListViewActivity extends AppCompatActivity {
	private String folderPath;
//	private String plotName;
	private ListView listView;
	private ImageItemListBaseAdapter imageViewAdapter;
	private ArrayList<ImagesItemDetails> image_details;
	private static final int ACTIVITY_VIEWIMAGE=1;
	private int activePosition;
	private int imageCount=0;
	private ImageManager imageManager;
	private String databaseName;
	private String photoReferenceCode;
	private int currentEditTextId;
	/** Parameters:
	 * folder_path : path of the folder
	 * plot_name: name of the plot
	 * */


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.imagemainview);
		setTitle("View Photos");
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			databaseName = extras != null ? extras.getString("STUDYNAME") : null;
			folderPath = extras != null ? extras.getString("FOLDER_PATH") : null;
			//photoReferenceCode = extras != null ? extras.getString("PHOTOREFERENCECODE") : null;
			//currentEditTextId=extras.getInt("CURRENTTEXTID");
		}
		
		image_details = GetSearchResults(folderPath);
		setTitle("Images:"+folderPath);

		listView = (ListView) findViewById(R.id.listV_main);
		imageViewAdapter = new ImageItemListBaseAdapter(this, image_details,getImagesFromPath(folderPath,databaseName));
		listView.setAdapter(imageViewAdapter);


		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) { 
				Object o = listView.getItemAtPosition(position);
				ImagesItemDetails obj_itemDetails = (ImagesItemDetails)o;
				Intent i = new Intent(ImageListViewActivity.this, ImageZoomActivity.class);
				activePosition=position;
				i.putExtra("image_path", obj_itemDetails.getImagePath());
				startActivityForResult(i, ACTIVITY_VIEWIMAGE);
			}  
		});
		listView.setOnItemLongClickListener(new OnItemLongClickListener(){

			@Override
			public boolean onItemLongClick(AdapterView<?> a, final View v,
					int position, long id) {
				AlertDialog.Builder adb=new AlertDialog.Builder(ImageListViewActivity.this);
				Object o = listView.getItemAtPosition(position);
				final 	ImagesItemDetails obj_itemDetails = (ImagesItemDetails)o; 
				adb.setTitle("Delete?");
				adb.setMessage("Are you sure you want to delete " + obj_itemDetails.getFileName());
				final int positionToRemove = position;
				adb.setNegativeButton("Cancel", null);

				adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						boolean delFile = new File(obj_itemDetails.getImagePath()).delete();
						if(delFile){
							image_details.remove(positionToRemove);
							imageViewAdapter.notifyDataSetChanged();
						}
						v.invalidate();
					}});
				adb.show();

				return true;
			}

		});

		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);


	}

	public ArrayList<String> getImagesFromPath(String path, String databaseName){
		File folder = new File(path);
		ArrayList<String> retVal = new ArrayList<String>();

		for(File img : folder.listFiles()){
			if(img.getName().endsWith(".png") || img.getName().endsWith(".jpg")){
				if(img.getName().contains(databaseName))
					retVal.add(img.getAbsolutePath());
			}
		}

		return retVal;
	}

	
	public ArrayList<ImagesItemDetails> GetSearchResults(String folderPath){
		ArrayList<ImagesItemDetails> results = new ArrayList<ImagesItemDetails>();
		ArrayList<String> imagesFolder = getImagesFromPath(folderPath,databaseName);

		for(int i = 0; i < imagesFolder.size(); i++){
			ImagesItemDetails item_details = new ImagesItemDetails();
			File imageFile = new File(imagesFolder.get(i));
			item_details.setFileName(imageFile.getName());
			item_details.setImageDescription("Something here...");
			item_details.setImagePath(imagesFolder.get(i));
			Date lastModDate = new Date(imageFile.lastModified());
			item_details.setDateCreated(lastModDate.toString());
			item_details.setImageID(i);
			results.add(item_details);
		}

		return results;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);

		   if (resultCode == Activity.RESULT_OK) { 
			Bundle extras = intent.getExtras();
			if(extras!=null){
				if(extras.getBoolean("Delete")){
					image_details.remove(activePosition);
					imageViewAdapter.notifyDataSetChanged();
					listView.invalidate();
				}
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_image_view, menu);
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



		return super.onOptionsItemSelected(item);
	}

}


