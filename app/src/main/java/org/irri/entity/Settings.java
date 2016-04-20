package org.irri.entity;

import android.widget.EditText;

/**
 * Created by ACañeda on 2016-04-13.
 */
public class Settings {

    String year;
    EditText etYear;
    String dataField1;
    String dataField2;
    String dataField3;
    String dataField4;
    String entryform;
    String dataEntryColor;
    int last_recno;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getLast_recno() {
        return last_recno;
    }

    public void setLast_recno(int last_recno) {
        this.last_recno = last_recno;
    }

    public EditText getEtYear() {
        return etYear;
    }

    public void setEtYear(EditText etYear) {
        this.etYear = etYear;
    }

    public String getDataField1() {
        return dataField1;
    }

    public void setDataField1(String dataField1) {
        this.dataField1 = dataField1;
    }

    public String getDataField2() {
        return dataField2;
    }

    public void setDataField2(String dataField2) {
        this.dataField2 = dataField2;
    }

    public String getDataField3() {
        return dataField3;
    }

    public void setDataField3(String dataField3) {
        this.dataField3 = dataField3;
    }

    public String getDataField4() {
        return dataField4;
    }

    public void setDataField4(String dataField4) {
        this.dataField4 = dataField4;
    }

    public String getEntryform() {
        return entryform;
    }

    public void setEntryform(String entryform) {
        this.entryform = entryform;
    }

    public String getDataEntryColor() {
        return dataEntryColor;
    }

    public void setDataEntryColor(String dataEntryColor) {
        this.dataEntryColor = dataEntryColor;
    }
}
