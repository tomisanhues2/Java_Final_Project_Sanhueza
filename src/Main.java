import Managers.NewManager;
import Managers.ReaderManager;
import Objects.Employee;
import Objects.Product;
import Objects.Store;
import ResourceObjects.*;
import Resources.ALayout;
import Resources.Constants;
import Resources.IDimensions;
import Resources.WindowSize;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;


public class Main extends ALayout implements WindowSize, Constants, IDimensions {


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

        FXMLLoader mainMenu = new FXMLLoader();
       Parent root = mainMenu.load(getClass().getClassLoader().getResource("res/MainMenu.fxml"),messages);

        Scene scene = new Scene(root,400,140);

        stage.setScene(scene);
        stage.setTitle("Store Manager");
        stage.show();
    }


    private static void createNewFiles() throws IOException{

        createProductFile();
        createEmployeeFile();
        createStoreFile();

/*        if (!(PRODUCT_FILE.exists() || EMPLOYEE_FILE.exists() || STORE_FILE.exists())) {
            createProductFile();
            createEmployeeFile();
            createStoreFile();
        } else {
        }*/
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
            stores.add(new Store("StorePlaceHolder" + i, RANDOM_PHONE_NUM,String.format("%d Address Placeholder",new Random().nextInt(8999) + 1000),new Employee()));
        }
        storeOut.writeObject(stores);
        System.out.println("StoreFile created successfully");
        storeOut.close();
        fileOut.close();
    }
}

