package org.irri.entity;

/**
 * Created by ACañeda on 2016-02-18.
 */
public class UploadHistoryModel {

    int transId;
    String remarks;
    String date_upload;

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDate_upload() {
        return date_upload;
    }

    public void setDate_upload(String date_upload) {
        this.date_upload = date_upload;
    }
}
