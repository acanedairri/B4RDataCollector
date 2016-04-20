package org.irri.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by ACañeda on 2016-04-20.
 */
public class SettingTabFragmentAdapter extends FragmentPagerAdapter {
    public SettingTabFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new SettingTabsFragment1();
            case 1:
                return new SettingTabsFragment2();
            case 2:
                return new SettingTabsFragment3();
            default:
                break;
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
