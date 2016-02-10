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
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.irri.database.DatabaseMasterTool;
import org.irri.database.StudyManager;
import org.irri.entity.StudyListData;
import org.irri.entity.VariableSet;
import org.irri.expandablelist.ListObject;
import org.irri.expandablelist.SimplerExpandableListAdapter;
import org.irri.expandablelist.TraitMeasuringModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

	Spinner spinnerVariableSet;
	ArrayAdapter<CharSequence> adapterVariableSet;
	String[] spinnerArray;
	HashMap<Integer,Integer> spinnerMap;
	String variableSetName;
	
	public void onCreate(Bundle paramBundle)
	{
		super.onCreate(paramBundle);
		setContentView(R.layout.activity_variable_set);
		traitMeasuringModel = (TraitMeasuringModel) getIntent().getSerializableExtra("TRAIT_MEASURING_MODEL");
		Bundle bundle = getIntent().getExtras();
		studyName=bundle.getString("STUDYNAME");
		btnClearSearch =(ImageView) findViewById(R.id.btnClearSearch);
		populateVariableSet();


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
		btnClearSearch.requestFocus();
		hideSoftKeyboard();
		etFilter.clearFocus();

		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);
	 
	}

	private void populateVariableSet() {
		int i = 0;

		List<String> variableSetNameList= new ArrayList<String>();

		DatabaseMasterTool dbTool = new DatabaseMasterTool(this,studyName);
		dbTool.openStudyDatabase(studyName);
		SQLiteDatabase database = dbTool.getDatabase();
		StudyManager studyMgr = new StudyManager();
		Cursor variableSetList=studyMgr.getVariableSetList(database);

		if(variableSetList != null && variableSetList.getCount() > 0){

			if (variableSetList.moveToFirst()) {
				do {

					String name=variableSetList.getString(variableSetList.getColumnIndex("variable_set_name"));

					variableSetNameList.add(name);
				} while (variableSetList.moveToNext());
			}
		}

		spinnerArray = new String[variableSetNameList.size()];
		spinnerMap = new HashMap<Integer, Integer>();
		for (String rec : variableSetNameList) {
			spinnerArray[i] = rec;
			i++;

		}

		spinnerVariableSet = (Spinner) findViewById(R.id.spinnerVariableSet);
		adapterVariableSet = new ArrayAdapter<CharSequence>(VariableSetActivity.this, android.R.layout.simple_spinner_item, spinnerArray);
		// ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_plot_field, android.R.layout.simple_spinner_item);
		adapterVariableSet.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerVariableSet.setAdapter(adapterVariableSet);
		spinnerVariableSet.setSelection(0);

		spinnerVariableSet.setOnItemSelectedListener(
				new AdapterView.OnItemSelectedListener() {
					public void onItemSelected(
							AdapterView<?> parent, View view, int position, long id) {
						try {
							variableSetName = spinnerVariableSet.getSelectedItem().toString();
							refreshList(null);
						} catch (Exception e) {
						}
					}

					public void onNothingSelected(AdapterView<?> parent) {

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

		if(id==android.R.id.home){

			this.finish();
			return true;
		}

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}else if(id == R.id.action_remove_variable_set){
			viewLogoutConfirmDialog();

		}


		return super.onOptionsItemSelected(item);
	}

	private void removeVariableSet() {

		DatabaseMasterTool dbTool = new DatabaseMasterTool(this,studyName);
		dbTool.openStudyDatabase(studyName);
		SQLiteDatabase database = dbTool.getDatabase();
		StudyManager mgr = new StudyManager();
		mgr.removeVariableSet(database,variableSetName);
		populateVariableSet();
		refreshList(null);
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
			variableSet = mgr.getVariableSet(database,variableSetName);
		}else{
			variableSet = mgr.getVariableSet(database,filter,variableSetName);
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

	/**
	 * Hides the soft keyboard
	 */
	public void hideSoftKeyboard() {
		if(getCurrentFocus()!=null) {
			InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
			inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
		}
	}

	/**
	 * Shows the soft keyboard
	 */
	public void showSoftKeyboard(View view) {
		InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
		view.requestFocus();
		inputMethodManager.showSoftInput(view, 0);
	}


	private void viewLogoutConfirmDialog(){
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(
				VariableSetActivity.this);
		alertDialog.setTitle("Confirm Deletion");
		alertDialog.setMessage("Are you sure you want to delete this variable set?");
		alertDialog.setIcon(R.drawable.info);
		alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// Write your code here to execute after dialog closed
				//Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
				removeVariableSet();
			}
		});
		alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {

			}
		});

		// Showing Alert Message
		alertDialog.show();

	}
}
