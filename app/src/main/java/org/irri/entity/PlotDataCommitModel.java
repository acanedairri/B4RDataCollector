package org.irri.entity;

/**
 * Created by ACañeda on 2016-02-09.
 */
public class PlotDataCommitModel {

    int variable_id;
    String value;
    String identifier_key;
    String data_unit;
    String remarks;

    public int getVariable_id() {
        return variable_id;
    }

    public void setVariable_id(int variable_id) {
        this.variable_id = variable_id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getData_unit() {
        return data_unit;
    }

    public void setData_unit(String data_unit) {
        this.data_unit = data_unit;
    }

    public String getIdentifier_key() {
        return identifier_key;
    }

    public void setIdentifier_key(String identifier_key) {
        this.identifier_key = identifier_key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
