package my.app.navigationbar.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
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
    private String text;
    private String textSize, textColor, textAlignment, typeface;
    private int blackColor = Color.BLACK;
    private int redColor = Color.RED;
    private int greenColor = Color.GREEN;
    private int yellowColor = Color.YELLOW;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
       saved = SavedString.getInstance();
       settings = Settings.getInstance();
       text = saved.getSavedString();
       return(v);
    }

    public void onViewCreated(View v, Bundle savedInstanceState) {
        editText = v.findViewById(R.id.editText);
        textAlignment = settings.getTextAlignment();
        textColor = settings.getTextColor();
        textSize = settings.getTextSize();
        typeface = settings.getTypeface();
        switch (textAlignment) {
            case "Left":
                editText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                break;
            case "Center":
                editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                break;
            case "Right":
                editText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                break;
            default:
                break;
        }
        switch (textColor) {
            case "black":
                editText.setTextColor(blackColor);
                break;
            case "green":
                editText.setTextColor(greenColor);
                break;
            case "yellow":
                editText.setTextColor(yellowColor);
                break;
            case "red":
                editText.setTextColor(redColor);
                break;
            default:
                break;
        }
        switch (textSize) {
            case "10sp":
                editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
                break;
            case "12sp":
                editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                break;
            case "14sp":
                editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                break;
            case "18sp":
                editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                break;
            case "24sp":
                editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
                break;
            default:
                break;
        }
        switch (typeface) {
            case "normal":
                editText.setTypeface(Typeface.DEFAULT);
                break;
            case "sans":
                editText.setTypeface(Typeface.SANS_SERIF);
                break;
            case "serif":
                editText.setTypeface(Typeface.SERIF);
                break;
            case "monospace":
                editText.setTypeface(Typeface.MONOSPACE);
                break;
            default:
                break;
        }
        if (text.length() > 0) {
            editText.setText(text);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        text = editText.getText().toString();
        saved.setSavedString(text);
    }
}
