package org.irri.expandablelist;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TraitMeasuringModel implements Serializable{
	//study description


/*	private String templateName;
	
	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}*/



/*	private HashMap<String,FieldModel> fieldBookMap = new HashMap<String,FieldModel>();*/
	public ArrayList<String> selectedTraitList = new ArrayList<String>();

/*	public FieldModel getFieldTraitModel(String traitCode){
		
		return fieldBookMap.get(traitCode);
	}*/
	
/*	public void changeKeyTo(String oldKey, String newKey){
		
		FieldModel oldModel = fieldBookMap.get(oldKey);
		oldModel.traitCode = oldKey;
		fieldBookMap.remove(oldKey);
		fieldBookMap.put(newKey, oldModel);
		
	}*/
	
/*	public ArrayList<FieldModel> getFieldModelsByCategory(String cat){
		
		ArrayList<FieldModel> returnVal = new ArrayList<FieldModel>();
		
		for(FieldModel field:fieldBookMap.values()){
			if(field.category.equals(cat)) returnVal.add(field);
			
				}
		return returnVal;
	}*/
	
	public void swapTraitList(String key1, String key2){
		int index1 = selectedTraitList.indexOf(key1);
		int index2 = selectedTraitList.indexOf(key2);
		
		Collections.swap(selectedTraitList,  index1, index2);
		
	}
	
	
	
/*	public HashMap<String, FieldModel> getFieldBookMap() {
		return fieldBookMap;
	}
	public void setFieldBookMap(HashMap<String, FieldModel> fieldBookMap) {
		this.fieldBookMap = fieldBookMap;
	}*/

/*
	public ArrayList<FieldModel> getFieldModels(String[] keys){
		ArrayList<FieldModel> returnVal = new ArrayList<FieldModel>();
		for(String key : keys){
			returnVal.add(getFieldTraitModel(key));
		}
		return returnVal;
	}
*/



	private HashMap<String,String> metaData = new HashMap<String, String>();
	private String metaFilePath = "";



	/*private HashMap<String,ArrayList<TableObject>> fieldBookModelMap = new HashMap<String, ArrayList<TableObject>>();*/




	public HashMap<String, String> getMetaData() {
		return metaData;
	}
	public String getMetaData(String key, boolean delete){

		if(!metaData.containsKey(key)) return "";

		String returnVal  = metaData.get(key);


		if(delete) metaData.remove(key);
		return returnVal;

	}
/*
	public void setMetaData(HashMap<String, String> metaData) {
		this.metaData = metaData;
	}

	public String getMetaFilePath() {
		return metaFilePath;
	}

	public void setMetaFilePath(String metaFilePath) {
		this.metaFilePath = metaFilePath;
	}*/

/*	private ArrayList<ListObject> siteTraits ;*/

/*	private String excelLayoutPath;
	private String excelGenotypePath;*/




/*	public ArrayList<TableObject> getFieldBookModelList(String key){
		if(fieldBookModelMap.containsKey(key))
			return fieldBookModelMap.get(key);
		else
			return new ArrayList<TableObject>();
	}*/
/*
	public void setFieldBookModelList(String key, ArrayList<TableObject> value){
		fieldBookModelMap.put(key, value);
	}
*/


	/*public HashMap<String, TableObject> getValuesToHashMap(){

		HashMap<String, TableObject> returnValue = new HashMap<String, TableObject>();

		for(ArrayList<TableObject> arrayTableObject : fieldBookModelMap.values()){
			for(int i = 0; i < arrayTableObject.size(); i++){
				returnValue.put(arrayTableObject.get(i).formModel.getTraitCode(), arrayTableObject.get(i));
			}
		}


		return returnValue;

	}*/






	/*public String getExcelLayoutPath() {
		return (excelLayoutPath == null) ? "" : excelLayoutPath;
	}



	public void setExcelLayoutPath(String excelLayoutPath) {
		this.excelLayoutPath = (excelLayoutPath == null) ? "" : excelLayoutPath;
	}



	public String getExcelGenotypePath() {
		return (excelGenotypePath == null) ? "" : excelGenotypePath;
	}



	public void setExcelGenotypePath(String excelGenotypePath) {
		this.excelGenotypePath = (excelGenotypePath == null) ? ""
				: excelGenotypePath;
	}

*/

	public TraitMeasuringModel(){
		Log.d("DEBUG","Model Created");
	}



/*	public ArrayList<ListObject> getSiteTraits(){
		return siteTraits;
	}
	public boolean isSiteTraitsEmpty(ArrayList<ListObject> siteTraits){
		for(int i = 0; i < siteTraits.size(); i++){
			if(siteTraits.get(i).isCheckBoxSelected) return false;
		}
		return true;
	}

	public void setSiteTraits(ArrayList<ListObject> traits){
		
		for(ListObject trait : traits){
			fieldBookMap.get(trait.traitCode).value = trait.isCheckBoxSelected;
		}
		
	}*/









}
