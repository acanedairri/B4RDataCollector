/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.irri.activity;


import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.irri.database.DatabaseMasterTool;
import org.irri.database.StudyManager;
import org.irri.entity.StudyListData;
import org.irri.entity.StudyMetadataList;

import java.util.ArrayList;
import java.util.List;


public class StudyInfoFragment extends Fragment {


    String studyName;
    Cursor studyBasicInfo;
    DatabaseMasterTool dbTool;
    Context context;
    private int id;
    private String program;
    private String name;
    private String title;
    private String place;
    private String phase;
    private String year;
    private String season;
    private String studyMetadataValues="";


    /**
     * A custom {@link ViewPager} title strip which looks much like Tabs present in Android v4.0 and
     * above, but is designed to give continuous feedback to the user when scrolling.
     */
    private SlidingTabLayout mSlidingTabLayout;

    /**
     * A {@link ViewPager} which will be used in conjunction with the {@link SlidingTabLayout} above.
     */
    private ViewPager mViewPager;



    public StudyInfoFragment(String studyName,Context context) {

        this.studyName = studyName;
        DatabaseMasterTool dbTool = new DatabaseMasterTool(context,studyName);
        dbTool.openStudyDatabase(studyName);
        SQLiteDatabase database = dbTool.getDatabase();
        StudyManager mgr = new StudyManager();

        Cursor cursor = mgr.getStudyBasicInfo(database);
        if(cursor != null && cursor.getCount() > 0){

            if (cursor.moveToFirst()) {
                do {
                    program=cursor.getString(cursor.getColumnIndex("program"));
                    name=cursor.getString(cursor.getColumnIndex("name"));
                    title=cursor.getString(cursor.getColumnIndex("title"));
                    place=cursor.getString(cursor.getColumnIndex("place"));
                    phase=cursor.getString(cursor.getColumnIndex("phase"));
                    season=cursor.getString(cursor.getColumnIndex("season"));
                    year=cursor.getString(cursor.getColumnIndex("year"));
                    id = cursor.getInt(cursor.getColumnIndex("id"));

                } while (cursor.moveToNext());
            }
        }

        Cursor cursorStudyMetadata = mgr.getStudyMetaData(database);
        if(cursorStudyMetadata != null && cursorStudyMetadata.getCount() > 0){

            if (cursorStudyMetadata.moveToFirst()) {
                do {
                    String variable=cursorStudyMetadata.getString(cursorStudyMetadata.getColumnIndex("variable"));
                    String value=cursorStudyMetadata.getString(cursorStudyMetadata.getColumnIndex("value"));
                    studyMetadataValues=studyMetadataValues+variable+":"+value+",";

                } while (cursorStudyMetadata.moveToNext());
            }
        }


        dbTool.close();


    }

    /**
     * Inflates the {@link View} which will be displayed by this {@link Fragment}, from the app's
     * resources.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        context=container.getContext();
        return inflater.inflate(R.layout.study_fragment, container, false);
    }

    // BEGIN_INCLUDE (fragment_onviewcreated)
    /**
     * This is called after the {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)} has finished.
     * Here we can pick out the {@link View}s we need to configure from the content view.
     *
     * We set the {@link ViewPager}'s adapter to be an instance of {@link SamplePagerAdapter}. The
     * {@link SlidingTabLayout} is then given the {@link ViewPager} so that it can populate itself.
     *
     * @param view View created in {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // BEGIN_INCLUDE (setup_viewpager)
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SamplePagerAdapter());
        // END_INCLUDE (setup_viewpager)

        // BEGIN_INCLUDE (setup_slidingtablayout)
        // Give the SlidingTabLayout the ViewPager, this must be done AFTER the ViewPager has had
        // it's PagerAdapter set.
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);
        // END_INCLUDE (setup_slidingtablayout)
    }
    // END_INCLUDE (fragment_onviewcreated)

    /**
     * The {@link android.support.v4.view.PagerAdapter} used to display pages in this sample.
     * The individual pages are simple and just display two lines of text. The important section of
     * this class is the {@link #getPageTitle(int)} method which controls what is displayed in the
     * {@link SlidingTabLayout}.
     */
    class SamplePagerAdapter extends PagerAdapter {


        /**
         * @return the number of pages to display
         */
        @Override
        public int getCount() {
            return 2;
        }

        /**
         * @return true if the value returned from {@link #instantiateItem(ViewGroup, int)} is the
         * same object as the {@link View} added to the {@link ViewPager}.
         */
        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        // BEGIN_INCLUDE (pageradapter_getpagetitle)
        /**
         * Return the title of the item at {@code position}. This is important as what this method
         * returns is what is displayed in the {@link SlidingTabLayout}.
         * <p>
         * Here we construct one using the position value, but for real application the title should
         * refer to the item's contents.
         */
        @Override
        public CharSequence getPageTitle(int position) {

                    if(position==0){
                        return "Basic Information";
                    }else{
                        return "Other Metadata";
                    }


        }
        // END_INCLUDE (pageradapter_getpagetitle)

        /**
         * Instantiate the {@link View} which should be displayed at {@code position}. Here we
         * inflate a layout from the apps resources and then change the text view to signify the position.
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = null;
            ListView lvStudyMetadata;
            if(position==0) {

                EditText etProgram;
                EditText etName;
                EditText etTitle;
                EditText etPlace;
                EditText etPhase;
                EditText etYear;
                EditText etSeason;
                // Inflate a new layout from our resources




                 view = getActivity().getLayoutInflater().inflate(R.layout.activity_study,
                        container, false);
                // Add the newly created View to the ViewPager
                container.addView(view);

                // Retrieve a TextView from the inflated View, and update it's text
                etName = (EditText) view.findViewById(R.id.etName);
                etName.setText(name);
                etTitle = (EditText) view.findViewById(R.id.etTitle);
                etTitle.setText(title);
                etProgram = (EditText) view.findViewById(R.id.etProgram);
                etProgram.setText(program);
                etPlace = (EditText) view.findViewById(R.id.etPlace);
                etPlace.setText(place);
                etPhase = (EditText) view.findViewById(R.id.etPhase);
                etPhase.setText(phase);
                etYear = (EditText) view.findViewById(R.id.etYear);
                etYear.setText(year);
                etSeason = (EditText) view.findViewById(R.id.etSeason);
                etSeason.setText(season);

            }else if (position==1){
                String studyMetadataObj=studyMetadataValues;
                List<StudyMetadataList> smList= new ArrayList<StudyMetadataList>();
                String[] s = studyMetadataObj.split(",");

                for(String r: s){
                    String [] data=r.split(":");
                    StudyMetadataList mdata= new StudyMetadataList();
                    mdata.setVariable(data[0]);
                    mdata.setValue(data[1]);
                    smList.add(mdata);
                }

                view = getActivity().getLayoutInflater().inflate(R.layout.activity_study_metadata,
                        container, false);

                StudyMetaAdapter adapter = new StudyMetaAdapter(view.getContext(),R.layout.activity_study_metadata_row,smList);
                lvStudyMetadata = (ListView) view.findViewById(R.id.lvStudyMetadata);
                lvStudyMetadata.setAdapter(adapter);
                container.addView(view);
            }


            // Return the View
            return view;
        }

        /**
         * Destroy the item from the {@link ViewPager}. In our case this is simply removing the
         * {@link View}.
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);

        }



    }

    public class StudyMetaAdapter extends ArrayAdapter {

        public List<StudyMetadataList> studyMetadataModelEntity;
        private int resource;
        private LayoutInflater inflater;

        public StudyMetaAdapter(Context context, int resource,  List<StudyMetadataList> objects) {
            super(context, resource, objects);
            studyMetadataModelEntity=objects;
            this.resource=resource;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

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
