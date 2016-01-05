package org.irri.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.gson.Gson;

import org.irri.activity.R;
import org.irri.entity.Study;
import org.irri.entity.StudyMetadata;

import java.util.List;

public class StudyActivity extends AppCompatActivity {

    private String program;
    private String name;
    private String title;
    private String place;
    private String phase;
    private String year;
    private String season;
    private EditText etProgram;
    private EditText etName;
    private EditText etTitle;
    private EditText etPlace;
    private EditText etPhase;
    private EditText etYear;
    private EditText etSeason;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        Bundle bundle = getIntent().getExtras();
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        program=bundle.getString("PROGRAM");
        name=bundle.getString("NAME");
        title= bundle.getString("TITLE");
        place=bundle.getString("PLACE");
        phase=bundle.getString("PHASE");
        year=bundle.getString("YEAR");
        season=bundle.getString("SEASON");


        etName = (EditText) findViewById(R.id.etName);
        etName.setText(name);

        etTitle=(EditText) findViewById(R.id.etTitle);
        etTitle.setText(title);

        etProgram=(EditText) findViewById(R.id.etProgram);
        etProgram.setText(program);

        etPlace=(EditText) findViewById(R.id.etPlace);
        etPlace.setText(place);

        etPhase=(EditText) findViewById(R.id.etPhase);
        etPhase.setText(phase);

        etYear=(EditText) findViewById(R.id.etYear);
        etYear.setText(year);

        etSeason=(EditText) findViewById(R.id.etSeason);
        etSeason.setText(season);



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_study, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
