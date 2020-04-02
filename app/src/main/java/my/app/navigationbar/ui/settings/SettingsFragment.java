package my.app.navigationbar.ui.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import my.app.navigationbar.R;
import my.app.navigationbar.ui.home.Settings;

public class SettingsFragment extends Fragment {

    private Spinner alignment;
    private Spinner size;
    private Spinner color;
    private Spinner typeface;
    private CheckBox checkBox;
    private String textSize, textColor, textAlignment, textTypeface;
    private Settings settings;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        final TextView textView = v.findViewById(R.id.text_settings);
        settings = Settings.getInstance();
        return v;
    }

    public void onViewCreated(View v, Bundle savedInstanceState) {
        alignment = (Spinner) v.findViewById(R.id.spinner1);
        size = (Spinner) v.findViewById(R.id.spinner2);
        color = (Spinner) v.findViewById(R.id.spinner3);
        typeface = (Spinner) v.findViewById(R.id.spinner4);
        checkBox = (CheckBox) v.findViewById(R.id.checkBox);

        ArrayAdapter<String> alignmentAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.alignment));
        alignmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        alignment.setAdapter(alignmentAdapter);
        alignment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                                                    textAlignment = alignment.getSelectedItem().toString();
                                                    settings.setTextAlignment(textAlignment);
                                                }

                                                @Override
                                                public void onNothingSelected(AdapterView<?> parent) {

                                                }
                                            });

            ArrayAdapter<String> sizeAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.text_size));
        sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        size.setAdapter(sizeAdapter);
        size.setSelection(3);
        size.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                textSize = size.getSelectedItem().toString();
                settings.setTextSize(textSize);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.text_color));
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        color.setAdapter(colorAdapter);
        color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                textColor = color.getSelectedItem().toString();
                settings.setTextColor(textColor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> typefaceAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.typeface));
        typefaceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeface.setAdapter(typefaceAdapter);
        typeface.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                textTypeface = typeface.getSelectedItem().toString();
                settings.setTypeface(textTypeface);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        checkBox.setChecked(settings.getEditPermit());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    settings.setEditPermit(true);
                }
                else {
                    settings.setEditPermit(false);
                }
            }
        });
    }
}
