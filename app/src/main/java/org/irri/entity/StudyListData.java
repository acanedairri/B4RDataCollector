package org.irri.entity;

/**
 * Created by ACañeda on 2015-12-16.
 */
public class StudyListData {

    String studyname;
    String name;
    String title;
    String dateLastCommited;
    int uncommited;
    int id;

    public String getStudyname() {
        return studyname;
    }

    public void setStudyname(String studyname) {
        this.studyname = studyname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateLastCommited() {
        return dateLastCommited;
    }

    public void setDateLastCommited(String dateLastCommited) {
        this.dateLastCommited = dateLastCommited;
    }

    public int getUncommited() {
        return uncommited;
    }

    public void setUncommited(int uncommited) {
        this.uncommited = uncommited;
    }
}
