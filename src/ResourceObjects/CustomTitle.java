package ResourceObjects;

import Resources.IDimensions;
import javafx.geometry.Pos;
import javafx.scene.control.Label;


public class CustomTitle extends Label implements IDimensions {

    public CustomTitle(String text) {
        super(text);
        applyCustomStyles();
    }

    private void applyCustomStyles() {
        setFont(TITLE_FONT);
        setAlignment(Pos.TOP_CENTER);
        setFocused(true);
        setMaxWidth(300);
    }

    public CustomVBox getTitleVBox() {
        CustomVBox customVBox = new CustomVBox(this);
        customVBox.setAlignment(Pos.TOP_CENTER);
        return customVBox;
    }
}
