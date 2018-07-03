package controller;

import ResourceObjects.CustomScene;
import Resources.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class NewEventController implements Constants {

    @FXML
    public HBox placeHolderHBox;

    public void buttonAction(ActionEvent event) {
        try {

            Stage stage;
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent newRoot = null;

            stage = (Stage) placeHolderHBox.getScene().getWindow();

            String buttonPressed = ((Button) event.getSource()).getText();

            switch (buttonPressed) {
                case "Employees List":
                    newRoot = fxmlLoader.load(getClass().getClassLoader().getResource("res/EmployeeView.fxml"), messages);
                    break;
                case "Products List":
                    newRoot = fxmlLoader.load(getClass().getClassLoader().getResource("res/ProductView.fxml"), messages);
                    break;
                case "Stores List":
                    newRoot = fxmlLoader.load(getClass().getClassLoader().getResource("res/StoreView.fxml"), messages);
                    break;
            }

            stage.setScene(new CustomScene(newRoot));

        } catch (IOException e) {

        }
    }
}
