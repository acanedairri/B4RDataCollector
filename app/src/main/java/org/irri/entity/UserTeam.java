package org.irri.entity;

/**
 * Created by ACañeda on 2016-03-29.
 */
public class UserTeam {

    int userid;
    String programAbbrev;
    String programName;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramAbbrev() {
        return programAbbrev;
    }

    public void setProgramAbbrev(String programAbbrev) {
        this.programAbbrev = programAbbrev;
    }

    @Override
    public String toString() {
        return "UserTeam{" +
                "userid=" + userid +
                ", programAbbrev='" + programAbbrev + '\'' +
                ", programName='" + programName + '\'' +
                '}';
    }
}
