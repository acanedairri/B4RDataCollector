package org.irri.activity;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class StudyMainActivity extends AppCompatActivity {

    String studyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_main);
        Bundle bundle = getIntent().getExtras();
        studyName=bundle.getString("STUDYNAME");

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            StudyInfoFragment fragment = new StudyInfoFragment(studyName,this);
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_study_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_data_entry) {

            return true;
        }else if(id == R.id.action_trait_measuring){
            Intent intent = new Intent(StudyMainActivity.this, TraitMeasuringActivity.class);
            intent.putExtra("STUDYNAME",studyName);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }
}