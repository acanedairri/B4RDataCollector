package org.irri.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by ACañeda on 2016-01-12.
 */
public class TraitModel {


    public ArrayList<String> selectedTraitList = new ArrayList<String>();
    private HashMap<String,FieldModel> fieldBookMap = new HashMap<String,FieldModel>();

    public FieldModel getFieldTraitModel(String traitCode){

        return fieldBookMap.get(traitCode);
    }


    public void swapTraitList(String key1, String key2){
        int index1 = selectedTraitList.indexOf(key1);
        int index2 = selectedTraitList.indexOf(key2);

        Collections.swap(selectedTraitList, index1, index2);

    }
}



