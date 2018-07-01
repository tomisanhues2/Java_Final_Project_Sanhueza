package ResourceObjects;

import javafx.scene.control.Button;
import javafx.scene.control.Menu;

public class ClickableMenu extends Menu {


    public ClickableMenu(String title) {
        Button button = new Button(title);
        button.setOnMouseClicked(evt -> button.fire());
        setGraphic(button);

    }


}