package org.irri.entity;

/**
 * Created by ACañeda on 2016-01-18.
 */
public class TraitMeasuring {

    int variable_id;
    String abbrev;
    String display_name;
    String dataType;
    String scaleValue;
    String value;

    public int getVariable_id() {
        return variable_id;
    }

    public void setVariable_id(int variable_id) {
        this.variable_id = variable_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getScaleValue() {
        return scaleValue;
    }

    public void setScaleValue(String scaleValue) {
        this.scaleValue = scaleValue;
    }


}
