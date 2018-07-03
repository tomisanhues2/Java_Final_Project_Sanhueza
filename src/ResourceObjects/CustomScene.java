package ResourceObjects;

import Resources.Constants;
import Resources.WindowSize;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CustomScene extends Scene implements WindowSize, Constants {


    public CustomScene(Parent root) {
        super(root, WINDOW_X,WINDOW_Y);
        applyCustomStyles();
    }

    public CustomScene(Parent root, double width, double height) {
        super(root, width, height);
        applyCustomStyles();
    }

    public CustomScene(Parent root, Boolean isMenuScene) {
        super(root,WINDOW_X,WINDOW_Y);
        applyCustomStyles();
    }

    private void applyCustomStyles() {

    }

}
