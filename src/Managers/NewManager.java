package Managers;

import Objects.Employee;
import Objects.Product;
import Objects.Store;
import Resources.ALayout;
import Resources.WindowSize;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class NewManager extends ALayout implements WindowSize {

    ObservableList<Store> stores = FXCollections.observableArrayList();
    ObservableList<Employee> employees = FXCollections.observableArrayList();
    ObservableList<Product> products = FXCollections.observableArrayList();
    ResourceBundle messages = ResourceBundle.getBundle("Messages.Messages");


    public NewManager(Stage stage) throws Exception {
        products.add(new Product("product",12,34));
        products.add(new Product("asd",321312,32));
        products.add(new Product("pro111duct",1,3124));
        products.add(new Product("proasdasdduct",1211231232,3));
        products.add(new Product("pro1duct",33312,31));
        start(stage);
    }

    @Override
    public void start(Stage stage) throws Exception {
        StackPane createMenu = new StackPane();
        ObservableList createList = createMenu.getChildren();

        //Create menu text
        Text menuText = new Text(messages.getString("createMenuText"));
        menuText.setId("MenuText"); //ID
        TITLE_ALIGN_CENTER(menuText);


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
//            newProductScene(stage); //NEW PRODUCT
            stage.setScene(showExistingElements(2));
        });

        //Add elements to Pane lists
        createList.addAll(employeeButton, storeButton, productButton, menuText); //ADD ELEMENTS

        createMenu.getStyleClass().add("text");

        for (Object o : createList) {
            if (o instanceof Button) {
                ((Button) o).setPrefWidth(MAX_SIZE_ELEMENT / 1.3);
            }

        }
        Scene createMenuS = new Scene(createMenu, WINDOW_X / 1.4, WINDOW_Y / 2.2);
        createMenuS.getStylesheets().addAll("css/createMenu.css", "css/styles.css");
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

    private Scene showExistingElements(int element) {

        VBox vbox = new VBox();
        TableView table = new TableView();
        table.setEditable(false);

        Label title = new Label();

        if (element == 1) { //EMPLOYEE

        } else if (element == 2) { //PRODUCT
            title.setText(messages.getString("productButton"));
            TableColumn id = new TableColumn(messages.getString("idLiteral"));
            id.setPrefWidth(40);
            id.setStyle("-fx-font-size: 16");
            id.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productId"));


            TableColumn name = new TableColumn(messages.getString("productNameLiteral"));
            name.setPrefWidth(222);
            name.setStyle("-fx-font-size: 16");
            name.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));

            TableColumn price = new TableColumn(messages.getString("productPriceLiteral"));
            price.setPrefWidth(222);
            price.setStyle("-fx-font-size: 16");
            price.setCellValueFactory(new PropertyValueFactory<Product, Double>("productPrice"));

            TableColumn amount = new TableColumn(messages.getString("productAmountLiteral"));
            amount.setPrefWidth(222);
            amount.setStyle("-fx-font-size: 16");
            amount.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productAmount"));

            table.setItems(products);

            table.getColumns().addAll(id,name,price,amount);
        } else if (element == 3) { //STORE

        }


        //Title
        title.setFont(new Font(20));
        table.setPrefHeight(WINDOW_Y/1.6);

        //Vbox properties and adding child
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 20, 10, 20));
        vbox.getChildren().addAll(title, table);

        return new Scene(vbox, WINDOW_X / 1.2, WINDOW_Y);
    }

    private void newProductScene(Stage stage) {
        StackPane newProduct = new StackPane();
        ObservableList newProductList = newProduct.getChildren();

        //Create product menu text
        Text text = new Text(messages.getString("productMenuText"));
        text.setId("productText"); //ID
        TITLE_ALIGN_CENTER(text);

        //Create elements for titles and user input
        Text productName = new Text(messages.getString("productNameLiteral"));
        TextField productNameField = new TextField(messages.getString("productNameLiteral"));
        ALIGN_CENTER_LEFT(productName, productNameField);
        productName.setTextAlignment(TextAlignment.CENTER);
        productName.setWrappingWidth(MAX_SIZE_ELEMENT);
        productNameField.setMaxWidth(MAX_SIZE_ELEMENT);
        StackPane.setMargin(productName, SEPARATE_ELEMENT_LEFT);

        Text productPrice = new Text(messages.getString("productPriceLiteral"));
        TextField productPriceField = new TextField(messages.getString("productPriceLiteral"));
        ALIGN_CENTER_CENTER(productPrice, productPriceField);
        productPrice.setTextAlignment(TextAlignment.CENTER);
        productPrice.setWrappingWidth(MAX_SIZE_ELEMENT);
        productPriceField.setMaxWidth(MAX_SIZE_ELEMENT);
        StackPane.setMargin(productPrice, SEPARATE_ELEMENT_CENTER);

        Text productAmount = new Text(messages.getString("productAmountLiteral"));
        TextField productAmountField = new TextField(messages.getString("productAmountLiteral"));
        ALIGN_CENTER_RIGHT(productAmount, productAmountField);
        productAmount.setTextAlignment(TextAlignment.CENTER);
        productAmount.setWrappingWidth(MAX_SIZE_ELEMENT);
        productAmountField.setMaxWidth(MAX_SIZE_ELEMENT);
        StackPane.setMargin(productAmount, SEPARATE_ELEMENT_RIGHT);


        //Add elements to pane
        newProductList.addAll(productName, productNameField, productPrice, productPriceField, productAmount, productAmountField);
        newProduct.getStyleClass().add("text");
        Scene newProductScene = new Scene(newProduct, WINDOW_X, WINDOW_Y);
        newProductScene.getStylesheets().addAll("css/productMenu.css", "css/styles.css");
        stage.setScene(newProductScene);
    }

}



