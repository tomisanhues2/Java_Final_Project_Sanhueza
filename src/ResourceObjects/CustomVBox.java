package ResourceObjects;

import Resources.Constants;
import Resources.IDimensions;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class CustomVBox extends VBox implements IDimensions, Constants {


    public CustomVBox() {
        super();
        applyCustomStyles();
    }

    public CustomVBox(Node... children) {
        super(children);
        applyCustomStyles();
    }

    private void applyCustomStyles() {
        setSpacing(VERTICAL_SPACING_VBOX);
    }




}
