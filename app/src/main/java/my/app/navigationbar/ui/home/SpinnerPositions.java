package my.app.navigationbar.ui.home;

public class SpinnerPositions {
    private static SpinnerPositions spinnerPositions = new SpinnerPositions();
    private int sizePosition = 3, colorPosition = 0, alignmentPosition = 0, typefacePosition = 0, languagePosition = 0;

    private SpinnerPositions(){
    }

    public static SpinnerPositions getInstance() {
        return(spinnerPositions);
    }

    public void setSizePosition(int i) {
        sizePosition = i;
    }

    public int getSizePosition() {
        return(sizePosition);
    }

    public void setColorPosition(int i) {
        colorPosition = i;
    }

    public int getColorPosition() {
        return(colorPosition);
    }

    public void setAlignmentPosition(int i) {
        alignmentPosition = i;
    }

    public int getAlignmentPosition() {
        return(alignmentPosition);
    }

    public void setTypefacePosition(int i) {
        typefacePosition = i;
    }

    public int getTypefacePosition() {
        return(typefacePosition);
    }

    public void setLanguagePosition(int i) {
        languagePosition = i;
    }

    public int getLanguagePosition() {
        return(languagePosition);
    }
}
