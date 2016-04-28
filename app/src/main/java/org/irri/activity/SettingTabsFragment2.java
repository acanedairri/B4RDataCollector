package org.irri.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;

import org.irri.entity.Settings;


public class SettingTabsFragment2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    Settings settingsFrame2;
    Spinner spinnerPlotField1;
    Spinner spinnerPlotField2;
    Spinner spinnerPlotField3;
    Spinner spinnerPlotField4;

    String dataField1;
    String dataField2;
    String dataField3;
    String dataField4;
    String entryform;
    String dataEntryColor = "light";
    String display_plot_label;
    String display_meta_label;


    ArrayAdapter<CharSequence> adapterPlotField1;
    ArrayAdapter<CharSequence> adapterPlotField2;
    ArrayAdapter<CharSequence> adapterPlotField3;
    ArrayAdapter<CharSequence> adapterPlotField4;
    private CheckBox checkBoxDisplayPlotMetaLabel;
    private CheckBox checkBoxDisplayPlotOrderLabel;

    public SettingTabsFragment2(Settings settings) {

        this.settingsFrame2 = settings;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting_tabs_fragment2, container, false);


        // plot field1 spinner
        spinnerPlotField1 = (Spinner) view.findViewById(R.id.spinnerPlotField1);
        adapterPlotField1 = ArrayAdapter.createFromResource(getContext(),
                R.array.spinner_plot_field2, R.layout.spinner_layout);

        adapterPlotField1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPlotField1.setAdapter(adapterPlotField1);

        spinnerPlotField1.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        String value = spinnerPlotField1.getSelectedItem().toString();
                        dataField1 = value;
                        settingsFrame2.setDataField1(value);

                    }


                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


        // plot field2 spinner
        spinnerPlotField2 = (Spinner) view.findViewById(R.id.spinnerPlotField2);
        adapterPlotField2 = ArrayAdapter.createFromResource(getContext(),
                R.array.spinner_plot_field2, R.layout.spinner_layout);

        adapterPlotField2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPlotField2.setAdapter(adapterPlotField2);

        spinnerPlotField2.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        String value = spinnerPlotField2.getSelectedItem().toString();
                        dataField2 = value;
                        settingsFrame2.setDataField2(value);

                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

        // plot field3 spinner
        spinnerPlotField3 = (Spinner) view.findViewById(R.id.spinnerPlotField3);
        adapterPlotField3 = ArrayAdapter.createFromResource(getContext(),
                R.array.spinner_plot_field, R.layout.spinner_layout);

        adapterPlotField3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPlotField3.setAdapter(adapterPlotField3);

        spinnerPlotField3.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        String value = spinnerPlotField3.getSelectedItem().toString();
                        dataField3 = value;
                        settingsFrame2.setDataField3(value);
                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


        // plot field4 spinner
        spinnerPlotField4 = (Spinner) view.findViewById(R.id.spinnerPlotField4);
        adapterPlotField4 = ArrayAdapter.createFromResource(getContext(),
                R.array.spinner_plot_field, R.layout.spinner_layout);

        adapterPlotField4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPlotField4.setAdapter(adapterPlotField3);

        spinnerPlotField4.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        String value = spinnerPlotField4.getSelectedItem().toString();
                        dataField4 = value;
                        settingsFrame2.setDataField4(value);
                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });




        RadioButton radioSingle = (RadioButton) view.findViewById(R.id.radioButtonSingle);
        RadioButton radioRange = (RadioButton) view.findViewById(R.id.radioButtonRange);

        radioRange.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                    settingsFrame2.setEntryform("batch");

            }
        });

        radioSingle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                    settingsFrame2.setEntryform("single");

            }
        });


        RadioButton radioLight = (RadioButton) view.findViewById(R.id.radioButtonLight);
        RadioButton radioDark = (RadioButton) view.findViewById(R.id.radioButtonDark);


        radioLight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                    settingsFrame2.setDataEntryColor("light");

            }
        });

        radioDark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                    settingsFrame2.setDataEntryColor("dark");

            }
        });

        checkBoxDisplayPlotOrderLabel = (CheckBox) view.findViewById(R.id.checkBoxDisplayPlotOrderLabel);
        checkBoxDisplayPlotOrderLabel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    settingsFrame2.setDisplay_plot_label("Y");
                } else {
                    settingsFrame2.setDisplay_plot_label("N");
                }
            }
        });

        checkBoxDisplayPlotMetaLabel = (CheckBox) view.findViewById(R.id.checkBoxDisplayPlotMetaLabel);
        checkBoxDisplayPlotMetaLabel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    settingsFrame2.setDisplay_meta_label("Y");
                } else {
                    settingsFrame2.setDisplay_meta_label("N");
                }
            }
        });


        initSpinnerValues();
        initEntryForm(view);
        initEntryFormColor(view);
        initEntryFormDisplayLabel(view);
        return view;
    }

    private void initEntryFormDisplayLabel(View view) {

        if (settingsFrame2.getDisplay_plot_label().equals("Y")) {
            checkBoxDisplayPlotOrderLabel.setChecked(true);
        } else {
            checkBoxDisplayPlotOrderLabel.setChecked(false);
        }

        if (settingsFrame2.getDisplay_meta_label().equals("Y")) {
            checkBoxDisplayPlotMetaLabel.setChecked(true);
        } else {
            checkBoxDisplayPlotMetaLabel.setChecked(false);
        }

    }


    private void initEntryForm(View v) {
        RadioButton radioSingle = (RadioButton) v.findViewById(R.id.radioButtonSingle);
        RadioButton radioBatch = (RadioButton) v.findViewById(R.id.radioButtonRange);

        if (settingsFrame2.getEntryform().equals("single")) {
            radioSingle.setChecked(true);
        } else {
            radioBatch.setChecked(true);
        }

    }

    private void initEntryFormColor(View v) {
        RadioButton radioLight = (RadioButton) v.findViewById(R.id.radioButtonLight);
        RadioButton radioDark = (RadioButton) v.findViewById(R.id.radioButtonDark);

        if (settingsFrame2.getDataEntryColor().equals("light")) {
            radioLight.setChecked(true);
        } else {
            radioDark.setChecked(true);
        }

    }

    private void initSpinnerValues() {

        int dataField1Position = adapterPlotField1.getPosition(settingsFrame2.getDataField1());
        spinnerPlotField1.setSelection(dataField1Position);


        int dataField2Position = adapterPlotField2.getPosition(settingsFrame2.getDataField2());
        spinnerPlotField2.setSelection(dataField2Position);

        int dataField3Position = adapterPlotField2.getPosition(settingsFrame2.getDataField3());
        spinnerPlotField3.setSelection(dataField3Position + 1);

        int dataField4Position = adapterPlotField2.getPosition(settingsFrame2.getDataField4());
        spinnerPlotField4.setSelection(dataField4Position + 1);
    }


    public Settings getSettingsFrame2() {
        return settingsFrame2;
    }
}
