package ResourceObjects;

import javafx.scene.control.Button;

public class ClickableMenu extends Button {


    public ClickableMenu(String title) {
        Button button = new Button(title);
        button.setOnMouseClicked(evt -> button.fire());
        setGraphic(button);

    }


}