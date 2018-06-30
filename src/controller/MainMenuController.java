package controller;

import Managers.ReaderManager;
import Resources.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController implements Constants {

    public Button mainMenuNew;
    public Button mainMenuExcel;

    @FXML
    private Text actiontarget;

    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Sign in button pressed");
    }

    @FXML protected void mainMenuExcelFileButton(ActionEvent event) {
        new ReaderManager();
    }
    @FXML protected void mainMenuCreateFileButton(ActionEvent event) {
//        new NewManager();
        Stage stage;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root1 =fxmlLoader.load(getClass().getClassLoader().getResource("res/NewEvent.fxml"),messages);
              stage = (Stage)mainMenuNew.getScene().getWindow();
              stage.close();
             stage.setScene(new Scene(root1));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void menuBarButton(ActionEvent event) {

    }
}
