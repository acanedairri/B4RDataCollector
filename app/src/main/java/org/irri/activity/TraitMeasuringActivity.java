package org.irri.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.irri.database.DatabaseMasterTool;
import org.irri.database.StudyManager;
import org.irri.entity.AccessToken;
import org.irri.expandablelist.ExpandableListActionListener;
import org.irri.expandablelist.ExpandableRadioListAdapter;
import org.irri.expandablelist.ListObject;
import org.irri.expandablelist.TraitMeasuringModel;

import java.util.ArrayList;
import java.util.Arrays;

public class TraitMeasuringActivity extends AppCompatActivity
{
	private ExpandableListView explvlist;
	private TraitMeasuringModel traitMeasuringModel;
	private ArrayList<ListObject> siteTraits = new ArrayList<ListObject>();
	private int REQUEST_CODE = 0X1;
	private String[] rows;
	private EditText txtTrait;
	private ExpandableRadioListAdapter listAdapter;
	private String studyName;
	public void onCreate(Bundle paramBundle)
	{
		super.onCreate(paramBundle);
		setContentView(R.layout.activity_trait_measuring);
		Bundle bundle = getIntent().getExtras();
		studyName=bundle.getString("STUDYNAME");
	
		refreshList();

		findViewById(R.id.btnMoveUp).setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				if(listAdapter.isListEmpty() || listAdapter.getSelectedItem() == null) return;
				Log.d("DEBUG", "SHOULD SWAP!");
				String selectedItem=listAdapter.getSelectedItem().traitCode;
				//if(createFieldBookModel.selectedTraitList.indexOf(listAdapter.getSelectedItem().traitCode) == 0) return;
				Log.d("DEBUG", "SHOULD SWAP!");
				String key1 = listAdapter.getSelectedItem().traitCode;
				int a=traitMeasuringModel.selectedTraitList.indexOf(listAdapter.getSelectedItem().traitCode);
				//String key2 = createFieldBookModel.selectedTraitList.get(createFieldBookModel.selectedTraitList.indexOf(listAdapter.getSelectedItem().traitCode) - 1);
				//createFieldBookModel.swapTraitList(key1, key2);
				refreshList();
				listAdapter.setSelected(key1);

			}

		});
		findViewById(R.id.btnMoveDown).setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				if(listAdapter.isListEmpty() || listAdapter.getSelectedItem() == null) return;
				String selectedItem=listAdapter.getSelectedItem().traitCode;
				//if(createFieldBookModel.selectedTraitList.indexOf(listAdapter.getSelectedItem().traitCode) >= createFieldBookModel.selectedTraitList.size() - 1 ) return;
				//Log.d("DEBUG", "SHOULD SWAP!");
				
				String key1 = listAdapter.getSelectedItem().traitCode;
				String key2 = traitMeasuringModel.selectedTraitList.get(traitMeasuringModel.selectedTraitList.indexOf(listAdapter.getSelectedItem().traitCode) + 1);
				traitMeasuringModel.swapTraitList(key1, key2);
				refreshList();
				listAdapter.setSelected(key1);
			}

		});


		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu){

		getMenuInflater().inflate(R.menu.menu_trait_measuring, menu);
		return true;


	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		int id = item.getItemId();

		if(id==android.R.id.home){

			this.finish();
			return true;
		}

		//noinspection SimplifiableIfStatement
		if(id == R.id.action_add_trait){
			Intent i = new Intent(TraitMeasuringActivity.this, VariableSetActivity.class);
			i.putExtra("STUDYNAME", studyName);
			i.putExtra("TRAIT_MEASURING_MODEL", traitMeasuringModel);
			startActivityForResult(i, REQUEST_CODE );
		}

		return super.onOptionsItemSelected(item);


	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intentdata)
	{
		if (resultCode == RESULT_OK) {
			if (requestCode == REQUEST_CODE) {
				refreshList();
			}
		}
	}

	public void refreshList(){
		ArrayList<ListObject> listData = new ArrayList<ListObject>();
		ArrayList<String> listHeader = new ArrayList<String>();
		ArrayList<String> rows = new ArrayList<String>();

		traitMeasuringModel= (TraitMeasuringModel) getIntent().getSerializableExtra("FieldBookModel");
		//FieldTraitManager fieldManager = new FieldTraitManager(this);

		DatabaseMasterTool dbTool = new DatabaseMasterTool(this,studyName);
		dbTool.openStudyDatabase(studyName);
		SQLiteDatabase database = dbTool.getDatabase();
		StudyManager mgr = new StudyManager();
		Cursor variableSet;

		variableSet = mgr.getVariableSetSelected(database);
		if(variableSet != null && variableSet.getCount() > 0){

			if (variableSet.moveToFirst()) {
				do {
					String abbrev=variableSet.getString(variableSet.getColumnIndex("abbrev"));
					rows.add(abbrev);
				} while (variableSet.moveToNext());
			}
		}

		listHeader.addAll(Arrays.asList(new String[]{"ABBREV", "LABEL", "DATATYPE", "SCALE_VALUE"}));


		for(String traitCode : rows){
			String abbrev ="";
			String label="";
			String datatype="";
			String scaleValue="";
			String is_selected="false";

			Cursor variableSetData=mgr.getVariableSetByAbbrev(database,traitCode);
			//traitData = fieldManager.getDataByTraitCode(traitCode);

			if(variableSetData != null && variableSetData.getCount() > 0){

				if (variableSetData.moveToFirst()) {
					do {
						abbrev=variableSetData.getString(variableSetData.getColumnIndex("abbrev"));
						label=variableSetData.getString(variableSetData.getColumnIndex("label"));
						datatype=variableSetData.getString(variableSetData.getColumnIndex("data_type"));
						scaleValue=variableSetData.getString(variableSetData.getColumnIndex("scale_value"));
						is_selected=variableSetData.getString(variableSetData.getColumnIndex("is_selected"));

					} while (variableSetData.moveToNext());
				}
			}

			//FieldModel data = new FieldModel();
			if(true){
				//FieldTraitModel traitData;

				ListObject tempData = new ListObject();
				tempData.title = traitCode;
				tempData.traitCode = traitCode;
				if(true){
                    tempData.isCheckBoxSelected = false;

                }
                else{
                    tempData.isCheckBoxSelected = true;
                }
				ArrayList<String> children = new ArrayList<String>();
				children.add(abbrev);
				children.add(label);
				children.add(datatype);
				children.add(String.valueOf(scaleValue));
				//children.add("datatype");

				tempData.children = children;
				listData.add(tempData);

			}
		}
		
		Log.d("DEBUG", "listData: " + listData.size());
		siteTraits = listData;
		explvlist = (ExpandableListView) findViewById(R.id.exp_list_view);
		listAdapter = new ExpandableRadioListAdapter(this, siteTraits, listHeader, new ExpandableListActionListener(){
			@Override
			public void deleteRow(ListObject lstObj){
				String abbrev= lstObj.traitCode;
				String is_selected="false";
				unselectTrait(abbrev,is_selected);
				refreshList();
			}

			@Override
			public void modifyRow(ListObject lstObj) {
				// TODO Auto-generated method stub
				
			}
		});
		explvlist.setAdapter(listAdapter);

	}

	private void unselectTrait(String abbrev,String is_selected){
		DatabaseMasterTool dbTool = new DatabaseMasterTool(this,studyName);
		dbTool.openStudyDatabase(studyName);
		SQLiteDatabase database = dbTool.getDatabase();
		StudyManager mgr = new StudyManager();
		mgr.updateVariableSet(database,abbrev,is_selected);
		dbTool.closeDB(database);

	}
/*	@Override
	public void finish(){

		if(RESULT_CODE == -5){ 
			Intent returnIntent = new Intent();

			returnIntent.putExtra("FieldBookModel",traitMeasuringModel);
			setResult(RESULT_CODE,returnIntent);     
			super.finish();
			return;
		}
		
	
		//createFieldBookModel.setSiteTraits(siteTraits);
		ArrayList<String> validationErrorList = new ArrayList<String>();
		if(traitMeasuringModel.selectedTraitList.isEmpty()) validationErrorList.add("Trait list must contain atleast one(1) entry");
		if(!validationErrorList .isEmpty() && RESULT_CODE == RESULT_OK){
*//*			Log.d("DEBUG","VALIDATION !OK");
			Intent intent = new Intent(this, CreateFieldbookFormValidation.class);
			intent.putExtra("ValidationList",validationErrorList);
			startActivity(intent);*//*
		}
		else{
			Intent returnIntent = new Intent();

			returnIntent.putExtra("FieldBookModel",traitMeasuringModel);
			setResult(RESULT_CODE,returnIntent);        
			super.finish();
		}
	}*/

	@Override
	public void finish(){
			setResult(RESULT_OK);
			super.finish();
	}

}
