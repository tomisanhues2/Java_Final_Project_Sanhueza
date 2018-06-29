package Resources;

import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class ClickableMenu extends Menu {

    private final Label label;

    public ClickableMenu() {
        this("");
    }


    public ClickableMenu(String title) {
        // dummy item is needed to make JavaFX "believe", that menu item was pressed
        MenuItem item = new MenuItem();
        item.setVisible(false);
        getItems().add(item);

        this.label = new Label();
        label.setText(title);
        label.setOnMouseClicked(evt -> item.fire());
        setGraphic(label);
    }


    public String getTitle() {
        return label.getText();
    }


    public void setTitle(String text) {
        label.setText(text);
    }


    public StringProperty titleProperty() {
        return label.textProperty();
    }

}