package org.irri.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import org.irri.entity.Settings;

/**
 * Created by ACañeda on 2016-04-20.
 */
public class SettingTabFragmentAdapter extends FragmentPagerAdapter {


    Settings settings;
    SettingTabsFragment1 fs1;
    SettingTabsFragment2 fs2;
    SettingTabsFragment3 fs3;
    public SettingTabFragmentAdapter(FragmentManager fm,Settings settings) {
        super(fm);
        this.settings=settings;

    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                fs1= new SettingTabsFragment1(settings);
                return fs1;
            case 1:
                fs2= new SettingTabsFragment2(settings);
                return fs2;
           /* case 2:
                fs3= new SettingTabsFragment3(settings);
                return fs3;*/
            default:
                break;
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    public SettingTabsFragment1 getFs1() {
        return fs1;
    }

    public SettingTabsFragment2 getFs2() {
        return fs2;
    }

    public SettingTabsFragment3 getFs3() {
        return fs3;
    }
}
