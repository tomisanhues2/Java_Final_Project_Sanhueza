package ResourceObjects;

import Resources.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;

public class CustomBorderPane extends BorderPane implements Constants {

    public CustomBorderPane() {

        applyCustomStyles();
    }

    public CustomBorderPane(String menuName) {

        applyCustomStyles();
        createHeaderBar(menuName);
    }


    private void applyCustomStyles() {

    }


    private void createHeaderBar(String menuName) {
        CustomHBox hbox = new CustomHBox();

        hbox.setStyle("-fx-background-color: #336699;");

        CustomTitle customTitle = new CustomTitle(menuName);
        CustomTitle customTitle1 = new CustomTitle("RIGHT");

        customTitle.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(customTitle,customTitle1);
        CustomHBox.setHgrow(customTitle1,Priority.ALWAYS);
        CustomHBox.setMargin(customTitle1,new Insets(0,10,0,0));
        setTop(hbox);
    }
    /*private void createHeaderBar(String menuName) {
        CustomCustomHBox header = new CustomCustomHBox();
        StackPane menuButton = new StackPane();


        ClickableMenu clickableMenu = new ClickableMenu(messages.getString("menuBarSaveButton"));
        stackPane.getChildren().add(clickableMenu);
        stackPane.setAlignment(Pos.CENTER_RIGHT);



        ClickableMenu clickableMenu = new ClickableMenu(messages.getString("menuBarSaveButton"));
        clickableMenu.setOnAction(event -> {
//            try {
//                saveNewInputSER();
//                clickableMenu.setDisable(true);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        });
        menuButton.getChildren().add(clickableMenu);
        menuButton.setAlignment(Pos.CENTER_RIGHT);


        header.getChildren().addAll(new CustomTitle(menuName),menuButton);
        this.setTop(header);
        this.setAlignment(header,Pos.CENTER);
    }*/
}
