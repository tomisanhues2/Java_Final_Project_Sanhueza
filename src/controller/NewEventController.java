package controller;

import Resources.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class NewEventController implements Constants {

    @FXML public Button employeeButton;
    @FXML public Button productButton;
    @FXML public Button storeButton;

    public void employeeButton(ActionEvent event) {
    }

    public void productButton(ActionEvent event) {
        Stage stage;

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root1 = fxmlLoader.load(getClass().getClassLoader().getResource("res/ProductView.fxml"),messages);
            stage = (Stage) productButton.getScene().getWindow();
            stage.setScene(new Scene(root1));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void storeButton(ActionEvent event) {

    }
}
