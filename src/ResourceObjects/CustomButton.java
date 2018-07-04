package ResourceObjects;

import Resources.WindowSize;
import javafx.scene.control.Button;


public class CustomButton extends Button implements WindowSize {


    public CustomButton(String label) {
        super(label);
        autoApplyStyles();
    }

    private void autoApplyStyles() {
        setMinSize(MAX_SIZE_ELEMENT * 1.3, WINDOW_Y / 8);
        setPrefSize(MAX_SIZE_ELEMENT * 1.3, WINDOW_Y / 8);
        setMaxSize(MAX_SIZE_ELEMENT * 1.3, WINDOW_Y / 8);
        setOnMouseClicked(event -> fire());
        setFocused(false);
    }

    @Override
    public void fire() {
        setDisable(true);
    }
}
