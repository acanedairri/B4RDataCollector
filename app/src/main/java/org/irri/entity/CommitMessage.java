package org.irri.entity;

/**
 * Created by ACañeda on 2016-02-09.
 */
public class CommitMessage {


    /**
     * success : true
     * data : {"name":"Created","message":"Successfully created dataset. ID of the transaction is 3135","status":201,"moreInfo":""}
     */

    private boolean success;
    /**
     * name : Created
     * message : Successfully created dataset. ID of the transaction is 3135
     * status : 201
     * moreInfo :
     */

    private DataEntity data;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public DataEntity getData() {
        return data;
    }

    public static class DataEntity {
        private String name;
        private String message;
        private int status;
        private String moreInfo;

        public void setName(String name) {
            this.name = name;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public void setMoreInfo(String moreInfo) {
            this.moreInfo = moreInfo;
        }

        public String getName() {
            return name;
        }

        public String getMessage() {
            return message;
        }

        public int getStatus() {
            return status;
        }

        public String getMoreInfo() {
            return moreInfo;
        }
    }
}
