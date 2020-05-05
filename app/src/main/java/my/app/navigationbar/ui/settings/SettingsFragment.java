package my.app.navigationbar.ui.settings;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import my.app.navigationbar.MainActivity;
import my.app.navigationbar.R;
import my.app.navigationbar.ui.home.Settings;
import my.app.navigationbar.ui.home.SpinnerPositions;

public class SettingsFragment extends Fragment implements View.OnTouchListener {

    private Spinner alignment;
    private Spinner size;
    private Spinner color;
    private Spinner typeface;
    private Spinner language;
    private CheckBox checkBox;
    private EditText editText;
    private String textSize, textColor, textAlignment, textTypeface, displayText;
    private boolean userSelect;
    private int location;
    private Settings settings;
    private ChangeLanguage changeLanguage;
    private SpinnerPositions spinnerPositions;
    private Button save;
    private Context context;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        final TextView textView = v.findViewById(R.id.text_settings);
        settings = Settings.getInstance();
        spinnerPositions = SpinnerPositions.getInstance();
        changeLanguage = ChangeLanguage.getInstance();
        context = getActivity();
        return v;
    }

    public void onViewCreated(View v, Bundle savedInstanceState) {
        alignment = (Spinner) v.findViewById(R.id.spinner1);
        size = (Spinner) v.findViewById(R.id.spinner2);
        color = (Spinner) v.findViewById(R.id.spinner3);
        typeface = (Spinner) v.findViewById(R.id.spinner4);
        checkBox = (CheckBox) v.findViewById(R.id.checkBox);
        language = (Spinner) v.findViewById(R.id.spinner5);
        save = (Button) v.findViewById(R.id.button);

        editText = (EditText) v.findViewById(R.id.editText3);
        displayText = settings.getDisplayText();
        if (displayText.length() > 0) {
            editText.setText(displayText);
        }

        ArrayAdapter<String> alignmentAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.alignment));
        alignmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        alignment.setAdapter(alignmentAdapter);
        alignment.setSelection(spinnerPositions.getAlignmentPosition());
        alignment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                                                    textAlignment = alignment.getSelectedItem().toString();
                                                    spinnerPositions.setAlignmentPosition(alignment.getSelectedItemPosition());
                                                    settings.setTextAlignment(textAlignment);
                                                }

                                                @Override
                                                public void onNothingSelected(AdapterView<?> parent) {

                                                }
                                            });

            ArrayAdapter<String> sizeAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.text_size));
        sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        size.setAdapter(sizeAdapter);
        size.setSelection(spinnerPositions.getSizePosition());
        size.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                textSize = size.getSelectedItem().toString();
                spinnerPositions.setSizePosition(size.getSelectedItemPosition());
                settings.setTextSize(textSize);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.text_color));
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        color.setAdapter(colorAdapter);
        color.setSelection(spinnerPositions.getColorPosition());
        color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                textColor = color.getSelectedItem().toString();
                spinnerPositions.setColorPosition(color.getSelectedItemPosition());
                settings.setTextColor(textColor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> typefaceAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.typeface));
        typefaceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeface.setAdapter(typefaceAdapter);
        typeface.setSelection(spinnerPositions.getTypefacePosition());
        typeface.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                textTypeface = typeface.getSelectedItem().toString();
                spinnerPositions.setTypefacePosition(typeface.getSelectedItemPosition());
                settings.setTypeface(textTypeface);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> languageAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.text_language));
        languageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        language.setAdapter(languageAdapter);
        language.setSelection(spinnerPositions.getLanguagePosition());
        language.setOnTouchListener(this);
        language.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                boolean languageChanged;
                location = language.getSelectedItemPosition();
                if (!userSelect) {
                    return;
                }
                userSelect = false;
                switch (location) {
                    case 0:
                        languageChanged = changeLanguage.setLocale("en", context);
                        spinnerPositions.setLanguagePosition(location);
                        if (languageChanged) {
                            onRefresh();
                        }
                        break;
                    case 1:
                        languageChanged = changeLanguage.setLocale("fi", context);
                        spinnerPositions.setLanguagePosition(location);
                        if (languageChanged) {
                            onRefresh();
                        }
                        break;
                    case 2:
                        languageChanged = changeLanguage.setLocale("sv", context);
                        spinnerPositions.setLanguagePosition(location);
                        if (languageChanged) {
                            onRefresh();
                        }
                        break;
                    default:
                        break;
                }
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

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayText = editText.getText().toString();
                settings.setDisplayText(displayText);
            }
        });
    }

    public void onRefresh() {
        getActivity().recreate();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        userSelect = true;
        return false;
    }
}
