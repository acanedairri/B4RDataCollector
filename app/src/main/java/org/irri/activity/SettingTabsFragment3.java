package org.irri.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.irri.entity.Settings;

public class SettingTabsFragment3 extends Fragment {


    Settings settings;

    public SettingTabsFragment3(Settings settings) {

        settings=settings;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings_tabs_fragment3,container,false);
    }
}
