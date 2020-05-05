package my.app.navigationbar.ui.settings;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

public class ChangeLanguage {
    private static ChangeLanguage changeLanguage = new ChangeLanguage();

    private ChangeLanguage() {
    }

    public static ChangeLanguage getInstance() {
        return(changeLanguage);
    }

    public boolean setLocale(String localeCode, Context context) {
        Resources res = context.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(localeCode.toLowerCase()));
        res.updateConfiguration(conf, dm);
        return(true);
    }
}
