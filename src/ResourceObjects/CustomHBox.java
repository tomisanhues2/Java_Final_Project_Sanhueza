package ResourceObjects;

import Resources.Constants;
import Resources.IDimensions;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CustomHBox extends HBox implements IDimensions, Constants {

    public CustomHBox() {
        super();
        applyCustomStyles();
    }

    private void applyCustomStyles() {
        setSpacing(HORIZONTAL_SPACING_ELEMENTS_2);
    }


}
