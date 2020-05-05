package my.app.navigationbar.ui.home;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.Locale;

import my.app.navigationbar.R;
import my.app.navigationbar.SavedString;

public class HomeFragment extends Fragment {
    private SavedString saved;
    private Settings settings;
    private SpinnerPositions spinnerPositions;
    private EditText editText;
    private EditText editText2;
    private String text;
    private String text2;
    private TextView textView;
    private boolean editNotAllowed;
    private String textSize, textColor, textAlignment, typeface, displayText;
    private int colorInteger, alignmentInteger, typefaceInteger;
    private int blackColor = Color.BLACK;
    private int redColor = Color.RED;
    private int greenColor = Color.GREEN;
    private int yellowColor = Color.YELLOW;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
       saved = SavedString.getInstance();
       settings = Settings.getInstance();
       spinnerPositions = SpinnerPositions.getInstance();
       text = saved.getSavedString(1);
       text2 = saved.getSavedString(2);
       return(v);
    }

    public void onViewCreated(View v, Bundle savedInstanceState) {
        editText = v.findViewById(R.id.editText);
        editText2 = v.findViewById(R.id.editText2);
        textAlignment = settings.getTextAlignment();
        textColor = settings.getTextColor();
        textSize = settings.getTextSize();
        typeface = settings.getTypeface();
        displayText = settings.getDisplayText();
        editNotAllowed = settings.getEditPermit();
        alignmentInteger = spinnerPositions.getAlignmentPosition();
        colorInteger = spinnerPositions.getColorPosition();
        typefaceInteger = spinnerPositions.getTypefacePosition();
        textView = (TextView) v.findViewById(R.id.textView7);
        textView.setText(displayText);
        switch (alignmentInteger) {
            case 0:
                editText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                editText2.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                break;
            case 1:
                editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                editText2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                break;
            case 2:
                editText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                editText2.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                break;
            default:
                break;
        }
        switch (colorInteger) {
            case 0:
                editText.setTextColor(blackColor);
                editText2.setTextColor(blackColor);
                break;
            case 1:
                editText.setTextColor(greenColor);
                editText2.setTextColor(greenColor);
                break;
            case 2:
                editText.setTextColor(yellowColor);
                editText2.setTextColor(yellowColor);
                break;
            case 3:
                editText.setTextColor(redColor);
                editText2.setTextColor(redColor);
                break;
            default:
                break;
        }
        switch (textSize) {
            case "10sp":
                editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
                editText2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
                break;
            case "12sp":
                editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                editText2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                break;
            case "14sp":
                editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                editText2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                break;
            case "18sp":
                editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                editText2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                break;
            case "24sp":
                editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
                editText2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
                break;
            default:
                break;
        }
        switch (typefaceInteger) {
            case 0:
                editText.setTypeface(Typeface.DEFAULT);
                editText2.setTypeface(Typeface.DEFAULT);
                break;
            case 1:
                editText.setTypeface(Typeface.SANS_SERIF);
                editText2.setTypeface(Typeface.SANS_SERIF);
                break;
            case 2:
                editText.setTypeface(Typeface.SERIF);
                editText2.setTypeface(Typeface.SERIF);
                break;
            case 3:
                editText.setTypeface(Typeface.MONOSPACE);
                editText2.setTypeface(Typeface.MONOSPACE);
                break;
            default:
                break;
        }
        if (text.length() > 0) {
            editText.setText(text);
        }
        if (text2.length() > 0) {
            editText2.setText(text2);
        }
        if (editNotAllowed == true) {
            text2 = editText2.getText().toString();
            editText.setText(text2);
            editText.setEnabled(false);
            editText.setInputType(InputType.TYPE_NULL);
        }
        else {
            editText.setEnabled(true);
            editText.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        text = editText.getText().toString();
        text2 = editText2.getText().toString();
        saved.setSavedString(text, 1);
        saved.setSavedString(text2, 2);
    }
}
