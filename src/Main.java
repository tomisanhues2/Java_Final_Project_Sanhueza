import Managers.NewManager;
import Managers.ReaderManager;
import Objects.Employee;
import Objects.Product;
import Objects.Store;
import Resources.ALayout;
import Resources.Constants;
import Resources.WindowSize;
import com.sun.deploy.nativesandbox.NativeSandboxBroker;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;


public class Main extends ALayout implements WindowSize, Constants {


    //https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html#introlimitations

    final static String RANDOM_PHONE_NUM = String.format("%d-%d-%d",new Random().nextInt(899) + 100,
            new Random().nextInt(899) + 100,
            new Random().nextInt(8999) + 1000);


    public static void main(String[] args) {
        try {

            createNewFiles();
            launch(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void start(Stage stage) throws Exception {
        VBox vbox = new VBox();
        HBox hbox = new HBox();

        //Create menu text
        Text menuText = new Text("Main menu");
        menuText.setId("menuText");
        TITLE_ALIGN_CENTER(menuText);
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
            try {
                NewManager newManager = new NewManager(stage);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
            createNewButton.setDisable(true);
        });


        createNewButton.setId("createButton");


        //Add elements to menuList
        hbox.getChildren().addAll(existingFileButton,createNewButton);
        hbox.setSpacing(100);

        vbox.getChildren().add(ADD_MENUBAR_SCENE());
        vbox.getChildren().add(menuText);
        vbox.getChildren().add(hbox);
        vbox.setSpacing(5);
        vbox.setAlignment(Pos.TOP_CENTER);

        //Position Elements in scene

        hbox.setSpacing(10);
        hbox.setAlignment(Pos.BOTTOM_CENTER);



        vbox.getStyleClass().add("text");
        //Create scene and set
        Scene menuS = new Scene(vbox, WINDOW_X/1.2, WINDOW_Y/2.5);
        menuS.getStylesheets().addAll("css/styles.css");

        stage.setScene(menuS);
        stage.setTitle("Store Manager");
        stage.show();
        stage.centerOnScreen();
    }

    private static void createNewFiles() throws IOException{


        if (!(PRODUCT_FILE.exists() || EMPLOYEE_FILE.exists() || STORE_FILE.exists())) {
            createProductFile();
            createEmployeeFile();
            createStoreFile();
        } else {

        }
    }

    private static void createProductFile() throws IOException {
        FileOutputStream fileOut = new FileOutputStream(PRODUCT_PATH);
        ObjectOutputStream productOut = new ObjectOutputStream(fileOut);
        ArrayList<Product> products = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            products.add(new Product("PlaceHolderProduct " + i,new Random().nextDouble() * 100,new Random().nextInt(50)));
        }
        productOut.writeObject(products);
        System.out.println("ProductFile created successfully");
        productOut.close();
        fileOut.close();
    }

    private static void createEmployeeFile() throws IOException {
        FileOutputStream fileOut = new FileOutputStream(EMPLOYEE_PATH);
        ObjectOutputStream employeeOut = new ObjectOutputStream(fileOut);
        ArrayList<Employee> employees = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            employees.add(new Employee("EmployeePlaceHolder" + i,
                    String.format("EmployeeEmail%d@Placeholder.com",i),
                    RANDOM_PHONE_NUM));
        }
        employeeOut.writeObject(employees);
        System.out.println("EmployeeFile created successfully");
        employeeOut.close();
        fileOut.close();

    }

    private static void createStoreFile() throws IOException {
        FileOutputStream fileOut = new FileOutputStream(STORE_PATH);
        ObjectOutputStream storeOut = new ObjectOutputStream(fileOut);
        ArrayList<Store> stores = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            stores.add(new Store("StorePlaceHolder" + i, RANDOM_PHONE_NUM,String.format("%d Address Placeholder",new Random().nextInt(8999) + 1000),null));
        }
        storeOut.writeObject(stores);
        System.out.println("StoreFile created successfully");
        storeOut.close();
        fileOut.close();
    }

    @Override
    protected void saveNewInputSER() {

    }
}

