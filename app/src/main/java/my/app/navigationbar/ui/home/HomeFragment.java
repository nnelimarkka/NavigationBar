package my.app.navigationbar.ui.home;

import android.content.Context;
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

import my.app.navigationbar.R;
import my.app.navigationbar.SavedString;

public class HomeFragment extends Fragment {
    private SavedString saved;
    private Settings settings;
    private EditText editText;
    private EditText editText2;
    private String text;
    private String text2;
    private TextView textView;
    private boolean editNotAllowed;
    private String textSize, textColor, textAlignment, typeface, displayText;
    private int blackColor = Color.BLACK;
    private int redColor = Color.RED;
    private int greenColor = Color.GREEN;
    private int yellowColor = Color.YELLOW;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
       saved = SavedString.getInstance();
       settings = Settings.getInstance();
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
        textView = (TextView) v.findViewById(R.id.textView7);
        textView.setText(displayText);
        switch (textAlignment) {
            case "Left":
                editText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                editText2.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                break;
            case "Center":
                editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                editText2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                break;
            case "Right":
                editText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                editText2.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                break;
            default:
                break;
        }
        switch (textColor) {
            case "black":
                editText.setTextColor(blackColor);
                editText2.setTextColor(blackColor);
                break;
            case "green":
                editText.setTextColor(greenColor);
                editText2.setTextColor(greenColor);
                break;
            case "yellow":
                editText.setTextColor(yellowColor);
                editText2.setTextColor(yellowColor);
                break;
            case "red":
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
        switch (typeface) {
            case "normal":
                editText.setTypeface(Typeface.DEFAULT);
                editText2.setTypeface(Typeface.DEFAULT);
                break;
            case "sans":
                editText.setTypeface(Typeface.SANS_SERIF);
                editText2.setTypeface(Typeface.SANS_SERIF);
                break;
            case "serif":
                editText.setTypeface(Typeface.SERIF);
                editText2.setTypeface(Typeface.SERIF);
                break;
            case "monospace":
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
