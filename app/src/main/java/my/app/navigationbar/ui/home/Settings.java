package my.app.navigationbar.ui.home;

public class Settings {
    private static Settings settings = new Settings();
    private String textSize = "", textColor = "", textAlignment = "", typeface = "";
    private boolean editNotAllowed = false;

    private Settings() {
    }

    public static Settings getInstance() {
        return(settings);
    }

    public void setTextSize(String s) {
        textSize = s;
    }

    public String getTextSize() {
        return(textSize);
    }

    public void setTextColor(String s) {
        textColor = s;
    }

    public String getTextColor() {
        return(textColor);
    }

    public void setTextAlignment(String s) {
        textAlignment = s;
    }

    public String getTextAlignment() {
        return(textAlignment);
    }

    public void setTypeface(String s) {
        typeface = s;
    }

    public String getTypeface() {
        return(typeface);
    }

    public void setEditPermit (boolean s) {
        editNotAllowed = s;
    }

    public boolean getEditPermit() {
        return(editNotAllowed);
    }
}
