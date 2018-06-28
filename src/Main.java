import Managers.ReaderManager;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application{

    private final int WINDOW_X = 600;
    private final int WINDOW_Y = 300;



    //https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html#introlimitations
    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane menu = new StackPane();
        ObservableList menuList = menu.getChildren();

        //Create menu text
        Text menuText = new Text();
        menuText.setText("Menu");
        menuText.setFont(new Font(18));
        menuText.setId("menuText");

        //Create buttons
        Button existingFileButton = new Button();
        existingFileButton.setText("Use existing .xlsx file");
        existingFileButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            new ReaderManager();
            existingFileButton.setDisable(true);

        });
        existingFileButton.setId("existingButton");

        Button createNewButton = new Button();
        createNewButton.setText("Create new records");
        createNewButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            //CREATE NEW FILE
            createNewButton.setDisable(true);
        });

        createNewButton.setId("createButton");


        //Add elements to menuList
        menuList.add(menuText);
        menuList.add(existingFileButton);
        menuList.add(createNewButton);


        //Position Elements in scene
        StackPane.setAlignment(menuText, Pos.TOP_CENTER);
        StackPane.setMargin(menuText,new Insets(20,0,0,0));

        StackPane.setAlignment(existingFileButton,Pos.CENTER_LEFT);
        StackPane.setMargin(existingFileButton,new Insets(0,0,0,30));

        StackPane.setAlignment(createNewButton,Pos.CENTER_RIGHT);
        StackPane.setMargin(createNewButton, new Insets(0,30,0,0));


        //Create scene and set
        Scene menuS = new Scene(menu, WINDOW_X, WINDOW_Y);
        menuS.getStylesheets().add("css/menu.css");

        primaryStage.setScene(menuS);
        primaryStage.setTitle("Objects.Store Manager");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}

