package org.irri.activity;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import org.irri.database.DatabaseMasterTool;
import org.irri.database.StudyManager;
import org.irri.entity.Settings;


public class SettingTabsMainActivity extends AppCompatActivity implements android.support.v7.app.ActionBar.TabListener {


    ActionBar actionBar;
    ViewPager viewpager;
    SettingTabFragmentAdapter ft;

    DatabaseMasterTool dbTool;
    SQLiteDatabase database;
    StudyManager mgr;
    String season;
    String year;
    String dataField1;
    String dataField2;
    String dataField3;
    String dataField4;
    String entryform;
    String dataEntryColor;
    String display_plot_label;
    String display_meta_label;
    Settings settings;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_tabs_main);

        initDatabase();
        populateSettingValues();

      /*  actionBar = getActionBar();*/
        viewpager = (ViewPager) findViewById(R.id.pager);
        ft = new SettingTabFragmentAdapter(getSupportFragmentManager(),settings);

        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(android.support.v7.app.ActionBar.NAVIGATION_MODE_TABS);
        viewpager.setAdapter(ft);
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        android.support.v7.app.ActionBar.Tab tab1 = actionBar.newTab();
        tab1.setText("Study");
        tab1.setTabListener(this);

        android.support.v7.app.ActionBar.Tab tab2 = actionBar.newTab();
        tab2.setText("Data Entry");
        tab2.setTabListener(this);

/*        android.support.v7.app.ActionBar.Tab tab3 = actionBar.newTab();
        tab3.setText("Advance");
        tab3.setTabListener(this);*/


        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
/*        actionBar.addTab(tab3);*/

        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);




    }


    public void initDatabase(){
        dbTool = new DatabaseMasterTool(this);
        database = dbTool.getMasterDatabase();
        mgr = new StudyManager();
    }

    private void populateSettingValues() {
        Cursor cursorSettings= mgr.getSettingsMaster(database);

        if(cursorSettings != null && cursorSettings.getCount() > 0){

            if (cursorSettings.moveToFirst()) {
                do {
                    dataField1=cursorSettings.getString(cursorSettings.getColumnIndex("datafield1"));
                    dataField2=cursorSettings.getString(cursorSettings.getColumnIndex("datafield2"));
                    dataField3=cursorSettings.getString(cursorSettings.getColumnIndex("datafield3"));
                    dataField4=cursorSettings.getString(cursorSettings.getColumnIndex("datafield4"));
                    entryform=cursorSettings.getString(cursorSettings.getColumnIndex("entryform"));
                    dataEntryColor=cursorSettings.getString(cursorSettings.getColumnIndex("formcolor"));
                    year = cursorSettings.getString(cursorSettings.getColumnIndex("year"));
                    season = cursorSettings.getString(cursorSettings.getColumnIndex("season"));
                    display_plot_label=cursorSettings.getString(cursorSettings.getColumnIndex("display_plot_label"));
                    display_meta_label=cursorSettings.getString(cursorSettings.getColumnIndex("display_meta_label"));
                } while (cursorSettings.moveToNext());
            }
        }

        settings= new Settings();
        settings.setDataField1(dataField1);
        settings.setDataField2(dataField2);
        settings.setDataField3(dataField3);
        settings.setDataField4(dataField4);
        settings.setYear(year);
        settings.setSeason(season);
        settings.setDisplay_plot_label(display_plot_label);
        settings.setDisplay_meta_label(display_plot_label);
        settings.setEntryform(entryform);
        settings.setDataEntryColor(dataEntryColor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_setting_tabs_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id==android.R.id.home){

            Settings s1 = ft.getFs1().getSettingsFrame1();
            Settings s2 = ft.getFs2().getSettingsFrame2();
            mgr.updateSettingsMaster(database, s1.getYear(), s1.getSeason(), s2.getDataField1(), s2.getDataField2(), s2.getDataField3(), s2.getDataField4(), s2.getEntryform(), s2.getDataEntryColor(), s2.getDisplay_meta_label(), s2.getDisplay_plot_label());
            dbTool.closeDB(database);
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Settings s1 = ft.getFs1().getSettingsFrame1();
        Settings s2 = ft.getFs2().getSettingsFrame2();
        mgr.updateSettingsMaster(database, s1.getYear(), s1.getSeason(), s2.getDataField1(), s2.getDataField2(), s2.getDataField3(), s2.getDataField4(), s2.getEntryform(), s2.getDataEntryColor(), s2.getDisplay_meta_label(), s2.getDisplay_plot_label());
        dbTool.closeDB(database);

    }

    @Override
    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

        viewpager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }
}
