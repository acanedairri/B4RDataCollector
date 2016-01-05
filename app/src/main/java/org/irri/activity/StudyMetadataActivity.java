package org.irri.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.irri.activity.R;
import org.irri.entity.StudyMetadata;
import org.irri.entity.StudyMetadataList;

import java.util.ArrayList;
import java.util.List;

public class StudyMetadataActivity extends AppCompatActivity {

    private ListView lvStudyMetadata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_metadata);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Bundle bundle = getIntent().getExtras();
        String studyMetadataObj = bundle.getString("OTHER_METADATA");

        String[] s = studyMetadataObj.split(",");
        List<StudyMetadataList> smList= new ArrayList<StudyMetadataList>();

        for(String r: s){
            String [] data=r.split(":");
            StudyMetadataList mdata= new StudyMetadataList();
            mdata.setVariable(data[0]);
            mdata.setValue(data[1]);
            smList.add(mdata);
        }


        StudyMetaAdapter adapter = new StudyMetaAdapter(getApplicationContext(),R.layout.activity_study_metadata_row,smList);
        lvStudyMetadata = (ListView) findViewById(R.id.lvStudyMetadata);
        lvStudyMetadata.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_study_metadata, menu);
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


    public class StudyMetaAdapter extends ArrayAdapter {

        public List<StudyMetadataList> studyMetadataModelEntity;
        private int resource;
        private LayoutInflater inflater;

        public StudyMetaAdapter(Context context, int resource,  List<StudyMetadataList> objects) {
            super(context, resource, objects);
            studyMetadataModelEntity=objects;
            this.resource=resource;
            inflater=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView==null){
                convertView = inflater.inflate(resource,null);
            }

            TextView tvVariable;
            TextView tvValue;

            tvVariable = (TextView) convertView.findViewById(R.id.tvVariable);
            tvValue = (TextView) convertView.findViewById(R.id.tvValue);

            tvVariable.setText(studyMetadataModelEntity.get(position).getVariable());
            tvValue.setText(String.valueOf(studyMetadataModelEntity.get(position).getValue()));

            return convertView;
        }
    }
}
