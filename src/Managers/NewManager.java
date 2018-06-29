package Managers;

import Objects.Employee;
import Objects.Product;
import Objects.Store;
import Resources.ALayout;
import Resources.WindowSize;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class NewManager extends ALayout implements WindowSize {

    ArrayList<Store> stores = new ArrayList<>();
    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ResourceBundle messages = ResourceBundle.getBundle("Messages.Messages");




    public NewManager(Stage stage) throws Exception {
        start(stage);
    }

    @Override
    public void start(Stage stage) throws Exception {
        StackPane createMenu = new StackPane();
        ObservableList createList = createMenu.getChildren();

        //Create menu text
        Text menuText = new Text(messages.getString("createMenuText"));
        menuText.setId("MenuText"); //ID
        StackPane.setAlignment(menuText, Pos.TOP_CENTER);
        StackPane.setMargin(menuText, new Insets(30, 0, 0, 0));
        menuText.setStyle("-fx-weight: bold;"); //TEMP FIELD, MOVE TO CSS


        //Create buttons
        Button employeeButton = new Button(messages.getString("employeeButton"));
        StackPane.setAlignment(employeeButton, Pos.BOTTOM_LEFT);
        StackPane.setMargin(employeeButton, new Insets(0, 0, 40, 30));
        employeeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            //NEW EMPLOYEE
        });


        Button storeButton = new Button(messages.getString("storeButton"));
        StackPane.setAlignment(storeButton, Pos.BOTTOM_RIGHT);
        StackPane.setMargin(storeButton, new Insets(0, 30, 40, 0));
        storeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            //NEW STORE
        });


        Button productButton = new Button(messages.getString("productButton"));
        StackPane.setAlignment(productButton, Pos.BOTTOM_CENTER);
        StackPane.setMargin(productButton, new Insets(0, 0, 40, 0));
        productButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            newProductScene(stage);
        });

        //Add elements to Pane lists
        createList.addAll(employeeButton, storeButton, productButton, menuText); //ADD ELEMENTS

        createMenu.getStyleClass().add("text");
        Scene createMenuS = new Scene(createMenu, WINDOW_X, WINDOW_Y);
        createMenuS.getStylesheets().addAll("css/createMenu.css","css/styles.css");
        stage.setScene(createMenuS);
        stage.show();
        stage.centerOnScreen();
    }


    private void createNewStore() {
        String storeName;
        String storePhoneNum;
        String storeAddress;
        Employee storeManager;

    }

    private void createNewEmployee() {
        String employeeName;
        String employeeEmail;
        String employeePhone;


    }

    private void createNewProduct() {
        String productName;
        double productPrice;
        int productAmount;


    }

    private void newProductScene(Stage stage) {
        StackPane newProduct = new StackPane();
        ObservableList newProductList = newProduct.getChildren();

        //Create product menu text
        Text text = new Text(messages.getString("productMenuText"));
        text.setId("productText"); //ID

        //Create elements for titles and user input
        Text productName = new Text(messages.getString("productNameLiteral"));
        TextField productNameField = new TextField(messages.getString("productNameLiteral"));
        ALIGN_CENTER_LEFT(productName,productNameField);
        productName.setTextAlignment(TextAlignment.CENTER);
        productName.setWrappingWidth(MAX_SIZE_ELEMENT);
        productNameField.setMaxWidth(MAX_SIZE_ELEMENT);
        StackPane.setMargin(productName, SEPARATE_ELEMENT_LEFT);

        Text productPrice = new Text(messages.getString("productPriceLiteral"));
        TextField productPriceField = new TextField(messages.getString("productPriceLiteral"));
        ALIGN_CENTER_CENTER(productPrice,productPriceField);
        productPrice.setTextAlignment(TextAlignment.CENTER);
        productPrice.setWrappingWidth(MAX_SIZE_ELEMENT);
        productPriceField.setMaxWidth(MAX_SIZE_ELEMENT);
        StackPane.setMargin(productPrice, SEPARATE_ELEMENT_CENTER);

        Text productAmount = new Text(messages.getString("productAmountLiteral"));
        TextField productAmountField = new TextField(messages.getString("productAmountLiteral"));
        ALIGN_CENTER_RIGHT(productAmount,productAmountField);
        productAmount.setTextAlignment(TextAlignment.CENTER);
        productAmount.setWrappingWidth(MAX_SIZE_ELEMENT);
        productAmountField.setMaxWidth(MAX_SIZE_ELEMENT);
        StackPane.setMargin(productAmount,SEPARATE_ELEMENT_RIGHT);


        //Add elements to pane
        newProductList.addAll(productName, productNameField,productPrice, productPriceField, productAmount, productAmountField);
        newProduct.getStyleClass().add("text");
        Scene newProductScene = new Scene(newProduct, WINDOW_X, WINDOW_Y);
        newProductScene.getStylesheets().addAll("css/productMenu.css","css/styles.css");
        stage.setScene(newProductScene);
    }

}














