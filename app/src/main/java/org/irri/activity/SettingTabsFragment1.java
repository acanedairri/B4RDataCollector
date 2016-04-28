package org.irri.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

import org.irri.entity.Settings;


public class SettingTabsFragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    Settings settingsFrame1;

    public SettingTabsFragment1(Settings settings) {

        this.settingsFrame1 = settings;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting_tabs_fragment1, container, false);

        RadioButton radioWS = (RadioButton) view.findViewById(R.id.radioButtonWS);
        RadioButton radioDS = (RadioButton) view.findViewById(R.id.radioButtonDS);


        radioDS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                    settingsFrame1.setSeason("Dry");

            }
        });


        radioWS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                    settingsFrame1.setSeason("Wet");

            }
        });

        // Check which radio button was clicked


        if (settingsFrame1.getSeason().equals("Wet")) {
            radioWS.setChecked(true);
            radioDS.setChecked(false);
        } else {
            radioWS.setChecked(false);
            radioDS.setChecked(true);
        }

        EditText etYear = (EditText) view.findViewById(R.id.etYear);
        etYear.setText(settingsFrame1.getYear());
        etYear.setInputType(InputType.TYPE_CLASS_NUMBER);

        etYear.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                /*settingsFrame1.setYear(s.toString());*/
            }

            @Override
            public void afterTextChanged(Editable s) {
                settingsFrame1.setYear(s.toString());
            }
        });

        return view;

    }


    public Settings getSettingsFrame1() {
        return settingsFrame1;
    }
}
