package org.irri.activity;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.Notification;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TabHost;

import com.google.gson.Gson;

import org.irri.entity.StudyMetadata;

/**
 * Created by ACañeda on 2015-12-09.
 */
public class StudyInfoTabActivity extends TabActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_info_tab);
        Bundle bundle = getIntent().getExtras();
        String name=bundle.getString("NAME");
        String title=bundle.getString("TITLE");
        String program=bundle.getString("PROGRAM");
        String place=bundle.getString("PLACE");
        String phase=bundle.getString("PHASE");
        String year=bundle.getString("YEAR");
        String season=bundle.getString("SEASON");
        String other_metadata=bundle.getString("OTHER_METADATA");

        TabHost tabHost = getTabHost();

        TabHost.TabSpec studyBasicInfoTabHost= tabHost.newTabSpec("studyBasicInfo");
        TabHost.TabSpec studyMetadataTabHost= tabHost.newTabSpec("studyMetadata");

        Intent intentStudyBasicInfo = new Intent(getApplicationContext(), StudyActivity.class);
        intentStudyBasicInfo.putExtra("NAME",name);
        intentStudyBasicInfo.putExtra("TITLE",title);
        intentStudyBasicInfo.putExtra("PROGRAM",program);
        intentStudyBasicInfo.putExtra("PLACE",place);
        intentStudyBasicInfo.putExtra("PHASE",phase);
        intentStudyBasicInfo.putExtra("YEAR", year);
        intentStudyBasicInfo.putExtra("SEASON", season);

        studyBasicInfoTabHost.setIndicator("Study Basic Info").setContent(intentStudyBasicInfo);


        Intent intentStudyMetadata = new Intent(getApplicationContext(), StudyMetadataActivity.class);
        intentStudyMetadata.putExtra("OTHER_METADATA",other_metadata);
        studyMetadataTabHost.setIndicator("Metadata ").setContent(intentStudyMetadata);

        tabHost.addTab(studyBasicInfoTabHost);
        tabHost.addTab(studyMetadataTabHost);

    }

}
