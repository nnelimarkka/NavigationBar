package my.app.navigationbar;

public class SavedString {
    private static SavedString saved = new SavedString();
    private String savedString = "";
    private String savedString2 = "";

    private SavedString() {
    }

    public void setSavedString(String s, int i) {
        if (i == 1) {
            savedString = s;
        }
        else {
            savedString2 = s;
        }
    }

    public String getSavedString(int i) {
        if (i == 1) {
            return(savedString);
        }
        else {
            return(savedString2);
        }
    }

    public static SavedString getInstance() {
        return(saved);
    }
}
