package my.app.navigationbar;

public class SavedString {
    private static SavedString saved = new SavedString();
    private String savedString = "";

    private SavedString() {
    }

    public void setSavedString(String s) {
        savedString = s;
    }

    public String getSavedString() {
        return(savedString);
    }

    public static SavedString getInstance() {
        return(saved);
    }
}
