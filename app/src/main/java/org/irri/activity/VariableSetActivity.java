package org.irri.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import org.irri.database.DatabaseMasterTool;
import org.irri.database.StudyManager;
import org.irri.entity.VariableSet;
import org.irri.expandablelist.ListObject;
import org.irri.expandablelist.SimplerExpandableListAdapter;
import org.irri.expandablelist.TraitMeasuringModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class VariableSetActivity extends AppCompatActivity
{
	private ExpandableListView explvlist;
	private TraitMeasuringModel traitMeasuringModel;
	private ArrayList<ListObject> siteTraits = new ArrayList<ListObject>();
	private int RESULT_CODE = -5;
	private SimplerExpandableListAdapter listAdapter;
	private EditText txtFilter;
	private HashMap<String, Boolean> selectedTraits = new HashMap<String,Boolean>();
	private String studyName;
	private ImageView btnClearSearch;
	private EditText etFilter;

	
	public void onCreate(Bundle paramBundle)
	{
		super.onCreate(paramBundle);
		setContentView(R.layout.activity_variable_set);
		traitMeasuringModel = (TraitMeasuringModel) getIntent().getSerializableExtra("TRAIT_MEASURING_MODEL");
		Bundle bundle = getIntent().getExtras();
		studyName=bundle.getString("STUDYNAME");
		btnClearSearch =(ImageView) findViewById(R.id.btnClearSearch);



		refreshList(null);
		etFilter = (EditText) findViewById(R.id.etFilter);
/*		findViewById(R.id.btnCancel).setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				RESULT_CODE = -5;
				finish();      

			}

		});*/
/*		findViewById(R.id.btnSelectTrait).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				txtFilter.setText("");
				RESULT_CODE = RESULT_OK;        
				finish();

			}});*/


		etFilter.addTextChangedListener(new TextWatcher() {

			 public void afterTextChanged(Editable s) {

				 // you can call or do what you want with your EditText here


			 }

			 public void beforeTextChanged(CharSequence s, int start, int count, int after) {


				 for (ListObject lstObj : listAdapter.getItems()) {
					 if (lstObj.isCheckBoxSelected) {
						 selectedTraits.put(lstObj.traitCode, true);

					 } else {
						 selectedTraits.put(lstObj.traitCode, false);
					 }

				 }
			 }

			 public void onTextChanged(CharSequence s, int start, int before, int count) {

				 refreshList(etFilter.getText().toString());
			 }
		 });
	 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_variable_set, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intentdata)
	{

		if(resultCode == RESULT_CANCELED) return;



		ArrayList<ListObject> returnData = (ArrayList<ListObject>) intentdata.getSerializableExtra("CHECKED_DATA");
		traitMeasuringModel = (TraitMeasuringModel) intentdata.getSerializableExtra("FieldBookModel");
		for(ListObject lstObj : returnData){

			//createFieldBookModel.getFieldTraitModel(lstObj.traitCode).visible =lstObj.is_visible;
//			Log.d("DEBUG", "TraitCode: " + lstObj.traitCode + " Visible:" + lstObj.is_visible + " AFTER: " + createFieldBookModel.getFieldTraitModel(lstObj.traitCode).visible);

	
		}
		
		refreshList(null);
		
	}

	public void refreshList(String filter){

		DatabaseMasterTool dbTool = new DatabaseMasterTool(this,studyName);
		dbTool.openStudyDatabase(studyName);
		SQLiteDatabase database = dbTool.getDatabase();
		StudyManager mgr = new StudyManager();
		Cursor variableSet;
		if(filter==null) {
			variableSet = mgr.getVariableSet(database);
		}else{
			variableSet = mgr.getVariableSet(database,filter);
		}


		ArrayList<String> rows = new ArrayList<String>();
		if(variableSet != null && variableSet.getCount() > 0){

			if (variableSet.moveToFirst()) {
				do {
					String abbrev=variableSet.getString(variableSet.getColumnIndex("abbrev"));
					rows.add(abbrev);
				} while (variableSet.moveToNext());
			}
		}
		//rows =new String[]{"PHT","YLD","FLW","PACP","TILLER"};
		//Arrays.sort(rows);
		ArrayList<ListObject> listData = new ArrayList<ListObject>();
		ArrayList<String> listHeader = new ArrayList<String>();
		listHeader.addAll(Arrays.asList(new String[]{"ABBREV", "LABEL", "DATATYPE", "SCALE_VALUE"}));



		for(String traitCode : rows){
			String abbrev ="";
			String label="";
			String datatype="";
			String scaleValue="";
			String is_selected="false";

			//FieldModel data = createFieldBookModel.getFieldTraitModel(traitCode);
			if(true){ //data.visible && !createFieldBookModel.selectedTraitList.contains(data.traitCode)
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


				ListObject tempData = new ListObject();
				tempData.title =traitCode ;
				tempData.traitCode = traitCode;
				if(is_selected.equals("true")){ //data.value instanceof Boolean
                    tempData.isCheckBoxSelected = true;
                }
                else{
                    tempData.isCheckBoxSelected = false;
                }

				ArrayList<String> children = new ArrayList<String>();
				children.add(abbrev);
				children.add(label);
				children.add(datatype);
				children.add(String.valueOf(scaleValue));


				tempData.children = children;
				listData.add(tempData);


			}
			else{
				if(traitCode.equals("sample")){
					//Log.d("DEBUG", data.visible +  " " + !createFieldBookModel.selectedTraitList.contains(data.traitCode));
				}
			}
		}
		
		Log.d("DEBUG", "listData: " + listData.size());

		explvlist = (ExpandableListView) findViewById(R.id.exp_list_view);
		siteTraits = listData;
		listAdapter = new SimplerExpandableListAdapter(this, siteTraits, listHeader,studyName);
		explvlist.setAdapter(listAdapter);
		dbTool.closeDB(database);

	}
	@Override
	public void finish(){
	
		if(RESULT_CODE == -5 ){
			    setResult(RESULT_OK);
				super.finish();
		}
	}


	public void actionBtnClearSearch(View v){
		etFilter.setText("");
		etFilter.requestFocus();
	}

}
