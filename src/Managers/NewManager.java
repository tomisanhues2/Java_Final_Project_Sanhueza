package Managers;

import Objects.Employee;
import Objects.Product;
import Objects.Store;
import Resources.ALayout;
import Resources.ID;
import Resources.WindowSize;
import com.sun.org.apache.bcel.internal.generic.NEW;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NewManager extends ALayout implements WindowSize {

    private ObservableList<Store> stores = FXCollections.observableArrayList();
    private ObservableList<Employee> employees = FXCollections.observableArrayList();
    private ObservableList<Product> products = FXCollections.observableArrayList();
    ResourceBundle messages = ResourceBundle.getBundle("Messages.Messages");


    public NewManager(Stage stage) throws Exception {
        getProductFromSER();
        start(stage);
    }

    private void getProductFromSER() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("/tmp/product.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<Product> productArrayList = (ArrayList<Product>) in.readObject();
        products.addAll(productArrayList);
        ID.productId = products.size();
        in.close();
        fileIn.close();
    }

    private void getEmployeeFromSER() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<Employee> productArrayList = (ArrayList<Employee>) in.readObject();
        employees.addAll(productArrayList);
        ID.employeeId = employees.size();
        in.close();
        fileIn.close();
    }

    private void getStoreFromSER() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("/tmp/store.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<Store> productArrayList = (ArrayList<Store>) in.readObject();
        stores.addAll(productArrayList);
        ID.storeId = stores.size();
        in.close();
        fileIn.close();
    }

    @Override
    public void start(Stage stage) {
//        StackPane createMenu = new StackPane();
//        ObservableList createList = createMenu.getChildren();
//
        VBox vbox = new VBox();
        HBox hbox = new HBox();

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
        hbox.getChildren().addAll(employeeButton, storeButton, productButton); //ADD ELEMENT
        hbox.setSpacing(80);
        hbox.setAlignment(Pos.BOTTOM_CENTER);
        vbox.getChildren().addAll(ADD_MENUBAR_SCENE(), menuText, hbox);
        vbox.setSpacing(5);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.getStyleClass().add("text");

        for (Object o : vbox.getChildren()) {
            if (o instanceof Button) {
                ((Button) o).setPrefWidth(MAX_SIZE_ELEMENT / 1.3);
            }
        }

        Scene createMenuS = new Scene(vbox, WINDOW_X / 1.2, WINDOW_Y / 2.5);
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
        HBox hbox = new HBox();
        HBox hLabels = new HBox();
        TableView table = new TableView();
        table.setEditable(false);

        Text title = new Text();

        if (element == 1) { //EMPLOYEE

        } else if (element == 2) { //PRODUCT
            title.setText(messages.getString("productButton"));
            TableColumn id = new TableColumn(messages.getString("idLiteral"));
            id.setPrefWidth(40);
            id.setStyle("-fx-font-size: 16");
            id.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productId"));


            TableColumn name = new TableColumn(messages.getString("productNameLiteral"));
            name.setPrefWidth(MAX_SIZE_ELEMENT);
            name.setStyle("-fx-font-size: 16");
            name.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));

            TableColumn price = new TableColumn(messages.getString("productPriceLiteral"));
            price.setPrefWidth(MAX_SIZE_ELEMENT);
            price.setStyle("-fx-font-size: 16");
            price.setCellValueFactory(new PropertyValueFactory<Product, Double>("productPrice"));

            TableColumn amount = new TableColumn(messages.getString("productAmountLiteral"));
            amount.setPrefWidth(MAX_SIZE_ELEMENT);
            amount.setStyle("-fx-font-size: 16");
            amount.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productAmount"));

            table.setItems(products);


            TextField newProductName = new TextField();
            newProductName.setPromptText(messages.getString("productNameLiteral"));
            newProductName.setPrefWidth(210);
            Text newProductNameLiteral = new Text(messages.getString("productNameLiteral"));
            newProductNameLiteral.setWrappingWidth(210);
            newProductName.setStyle(NEW_INPUT);

            TextField newProductPrice = new TextField();
            newProductPrice.setPromptText(messages.getString("productPriceLiteral"));
            newProductPrice.setPrefWidth(210);
            Text newProductPriceLiteral = new Text(messages.getString("productPriceLiteral"));
            newProductPriceLiteral.setWrappingWidth(210);
            newProductPrice.setStyle(NEW_INPUT);

            TextField newProductAmount = new TextField();
            newProductAmount.setPromptText(messages.getString("productAmountLiteral"));
            newProductAmount.setPrefWidth(210);
            Text newProductAmountLiteral = new Text(messages.getString("productAmountLiteral"));
            newProductAmountLiteral.setWrappingWidth(210);
            newProductAmount.setStyle(NEW_INPUT);

            Button addProduct = new Button("Add");
            addProduct.setOnAction(event -> {
                if (productValidName(newProductName.getText()) != null &&
                        productValidPrice(newProductPrice.getText()) != -1 &&
                        productValidAmount(newProductAmount.getText()) != -1) {
                    products.add(new Product(
                            newProductName.getText(),
                            Double.parseDouble(newProductPrice.getText()),
                            Integer.parseInt(newProductAmount.getText())));
                    newProductName.clear();
                    newProductPrice.clear();
                    newProductAmount.clear();
                    newProductName.setStyle(NEW_INPUT);
                    newProductPrice.setStyle(NEW_INPUT);
                    newProductAmount.setStyle(NEW_INPUT);
                } else {
                    if (productValidName(newProductName.getText()) == null) {
                        newProductName.clear();
                        newProductName.setStyle(INVALID_INPUT);
                    } else {
                        newProductName.setStyle(VALID_INPUT);
                    }
                    if (productValidPrice(newProductPrice.getText()) == -1) {
                        newProductPrice.clear();
                        newProductPrice.setStyle(INVALID_INPUT);
                    } else {
                        newProductPrice.setStyle(VALID_INPUT);
                    }
                    if (productValidAmount(newProductAmount.getText()) == -1) {
                        newProductAmount.clear();
                        newProductAmount.setStyle(INVALID_INPUT);
                    } else {
                        newProductAmount.setStyle(VALID_INPUT);
                    }

                }
            });
            //Add spacing and elements to HORIZONTAL
            hbox.getChildren().addAll(newProductName, newProductPrice, newProductAmount, addProduct);
            hbox.setSpacing(5);
            hLabels.getChildren().addAll(newProductNameLiteral, newProductPriceLiteral, newProductAmountLiteral);
            hLabels.setSpacing(5);


            table.getColumns().addAll(id, name, price, amount);


        } else if (element == 3) { //STORE

        }

        //Title
        TITLE_ALIGN_CENTER(title);
        table.setPrefHeight(WINDOW_Y / 1.6);

        //Vbox properties and adding child
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 20, 10, 20));
        vbox.getChildren().add(ADD_MENUBAR_SCENE());
        vbox.getChildren().addAll(title, table, hbox, hLabels);

        return new Scene(vbox, WINDOW_X, WINDOW_Y);
    }


    private String productValidName(String s) {
        if (!s.isEmpty() && s.matches("^[a-zA-Z ]+$"))
            return s;
        return null;
    }

    private double productValidPrice(String s) {
        if (!s.isEmpty() && s.matches("^[0-9]+(\\.[0-9]{1,2})?$"))
            return Double.parseDouble(s);
        return -1;
    }

    private int productValidAmount(String s) {
        if (!s.isEmpty() && s.matches("^[0-9]+$"))
            return Integer.parseInt(s);
        return -1;
    }

    @Override
    protected void saveNewInputSER() {
        File productFile = new File("/tmp/product.ser");
        File employeeFile = new File("/tmp/employee.ser");
        File storeFile = new File("/tmp/store.ser");


    }

    private void saveNewProductInputSER(File file) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOut);
        ArrayList<Product> productArrayList = new ArrayList<>(products);
        objectOutputStream.writeObject(productArrayList);
        objectOutputStream.close();
        fileOut.close();
    }

    private void saveNewEmployeeInputSER(File file) throws IOException{
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOut);
        ArrayList<Employee> productArrayList = new ArrayList<>(employees);
        objectOutputStream.writeObject(productArrayList);
        objectOutputStream.close();
        fileOut.close();
    }

    private void saveNewStoreInputSER(File file) throws IOException{
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOut);
        ArrayList<Store> productArrayList = new ArrayList<>(stores);
        objectOutputStream.writeObject(productArrayList);
        objectOutputStream.close();
        fileOut.close();
    }
}



