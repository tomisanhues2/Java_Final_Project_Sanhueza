package Managers;

import Objects.Employee;
import Objects.Product;
import Objects.Store;
import Resources.ALayout;
import Resources.Constants;
import Resources.ID;
import Resources.WindowSize;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.*;
import java.util.ArrayList;

public class NewManager extends ALayout implements WindowSize, Constants {

    private ObservableList<Store> stores = FXCollections.observableArrayList();
    private ObservableList<Employee> employees = FXCollections.observableArrayList();
    private ObservableList<Product> products = FXCollections.observableArrayList();




    public NewManager(Stage stage) throws Exception {
        getProductFromSER();
        getEmployeeFromSER();
        getStoreFromSER();
        start(stage);
    }

    private void getProductFromSER() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(PRODUCT_PATH);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<Product> productArrayList = (ArrayList<Product>) in.readObject();
        products.addAll(productArrayList);
        ID.productId = products.size();
        in.close();
        fileIn.close();
    }

    private void getEmployeeFromSER() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(EMPLOYEE_PATH);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<Employee> productArrayList = (ArrayList<Employee>) in.readObject();
        employees.addAll(productArrayList);
        ID.employeeId = employees.size();
        for (Employee e : employees) {
            System.out.println(e);
        }
        in.close();
        fileIn.close();
    }

    private void getStoreFromSER() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(STORE_PATH);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<Store> productArrayList = (ArrayList<Store>) in.readObject();
        stores.addAll(productArrayList);
        ID.storeId = stores.size();
        for (Store s : stores) {
            System.out.println(s);
        }
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


        //Create buttons//

        //Employee
        Button employeeButton = new Button(messages.getString("employeeButton"));
        employeeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            stage.setScene(showExistingElements(1));
        });



        //Product
        Button productButton = new Button(messages.getString("productButton"));
        productButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            stage.setScene(showExistingElements(2));
        });

        //Store
        Button storeButton = new Button(messages.getString("storeButton"));
        storeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            stage.setScene(showExistingElements(3));
        });



        //Add elements to Pane lists
        hbox.getChildren().addAll(employeeButton, storeButton, productButton); //ADD ELEMENT
        hbox.setSpacing(80);
        hbox.setAlignment(Pos.BOTTOM_CENTER);
        vbox.getChildren().addAll(menuText, hbox);
        vbox.setSpacing(5);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.getStyleClass().add("text");

        for (Object o : vbox.getChildren()) {
            if (o instanceof Button) {
                ((Button) o).setPrefWidth(MAX_SIZE_ELEMENT / 1.3);
            }
        }

        Scene createMenuS = new Scene(vbox, WINDOW_X / 1.2, WINDOW_Y / 2.5);
        createMenuS.getStylesheets().addAll("Css/createMenu.css", "Css/styles.css");

        stage.setScene(createMenuS);
        stage.show();
        stage.centerOnScreen();
    }



    private Scene showExistingElements(int element) {

        VBox vbox = new VBox();
        HBox hbox = new HBox();
        HBox hLabels = new HBox();
        TableView table = new TableView();
        table.setEditable(true);

        Text title = new Text();

        if (element == 1) { //EMPLOYEE

            title.setText(messages.getString("employeeButton"));

            TableColumn id = new TableColumn(messages.getString("idLiteral"));
            id.setPrefWidth(40);
            id.setStyle("-fx-font-size: 16");
            id.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeId"));
            id.setEditable(false);

            TableColumn name = new TableColumn(messages.getString("employeeNameLiteral"));
            name.setPrefWidth(MAX_SIZE_ELEMENT);
            name.setStyle("-fx-font-size: 16");
            name.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeName"));
            name.setCellFactory(TextFieldTableCell.forTableColumn());
            name.setOnEditCommit((EventHandler<CellEditEvent<Employee, String>>) event -> {
                if (employeeValidName(event.getNewValue()) != null)
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setEmployeeName(event.getNewValue());
                else
                    System.out.println("aDD ERROR MESSAGE");
            });

            TableColumn email = new TableColumn(messages.getString("employeeEmailLiteral"));
            email.setPrefWidth(MAX_SIZE_ELEMENT);
            email.setStyle("-fx-font-size: 16");
            email.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeEmail"));
            email.setCellFactory(TextFieldTableCell.forTableColumn());
            email.setOnEditCommit((EventHandler<CellEditEvent<Employee, String>>) event -> {
                if (employeeValidEmail(event.getNewValue()) != null)
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setEmployeeEmail(event.getNewValue());
                else
                    System.out.println("aDD ERROR MESSAGE");
            });

            TableColumn phone = new TableColumn(messages.getString("employeePhoneLiteral"));
            phone.setPrefWidth(MAX_SIZE_ELEMENT);
            phone.setStyle("-fx-font-size: 16");
            phone.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeePhone"));
            phone.setCellFactory(TextFieldTableCell.forTableColumn());
            phone.setOnEditCommit((EventHandler<CellEditEvent<Employee, String>>) event -> {
                if (employeeValidPhone(event.getNewValue()) != null)
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setEmployeePhone(event.getNewValue());
                else
                    System.out.println("aDD ERROR MESSAGE");
            });

            table.setItems(employees);

            TextField newEmployeeName = new TextField();
            newEmployeeName.setPromptText(messages.getString("employeeNameLiteral"));
            newEmployeeName.setPrefWidth(210);
            Text newEmployeeNameLiteral = new Text(messages.getString("employeeNameLiteral"));
            newEmployeeNameLiteral.setWrappingWidth(210);
            newEmployeeName.setStyle(NEW_INPUT);


            TextField newEmployeeEmail = new TextField();
            newEmployeeEmail.setPromptText(messages.getString("employeeEmailLiteral"));
            newEmployeeEmail.setPrefWidth(210);
            Text newEmployeeEmailLiteral = new Text(messages.getString("employeeEmailLiteral"));
            newEmployeeEmailLiteral.setWrappingWidth(210);
            newEmployeeEmail.setStyle(NEW_INPUT);

            TextField newEmployeePhone = new TextField();
            newEmployeePhone.setPromptText(messages.getString("employeePhoneLiteral"));
            newEmployeePhone.setPrefWidth(210);
            Text newEmployeePhoneLiteral = new Text(messages.getString("employeePhoneLiteral"));
            newEmployeePhoneLiteral.setWrappingWidth(210);
            newEmployeePhone.setStyle(NEW_INPUT);

            Button addEmployee = new Button("Add");
            addEmployee.setOnAction(event -> {
                if (employeeValidName(newEmployeeName.getText()) != null &&
                        employeeValidEmail(newEmployeeEmail.getText()) != null &&
                        employeeValidPhone(newEmployeePhone.getText()) != null) {

                    employees.add(new Employee(
                            newEmployeeName.getText(), newEmployeeEmail.getText(),newEmployeePhone.getText()));


                    newEmployeeName.clear();
                    newEmployeeEmail.clear();
                    newEmployeePhone.clear();


                    newEmployeeName.setStyle(NEW_INPUT);
                    newEmployeeEmail.setStyle(NEW_INPUT);
                    newEmployeePhone.setStyle(NEW_INPUT);


                } else {

                    if (employeeValidName(newEmployeeName.getText()) == null) {
                        newEmployeeName.clear();
                        newEmployeeName.setStyle(INVALID_INPUT);
                    } else {
                        newEmployeeName.setStyle(VALID_INPUT);
                    }
                    if (employeeValidEmail(newEmployeeEmail.getText()) == null) {
                        newEmployeeEmail.clear();
                        newEmployeeEmail.setStyle(INVALID_INPUT);
                    } else {
                        newEmployeeEmail.setStyle(VALID_INPUT);
                    }
                    if (employeeValidPhone(newEmployeePhone.getText()) == null) {
                        newEmployeePhone.clear();
                        newEmployeePhone.setStyle(INVALID_INPUT);
                    } else {
                        newEmployeePhone.setStyle(VALID_INPUT);
                    }

                }
            });


            //Add spacing and elements to HORIZONTAL
            hbox.getChildren().addAll(newEmployeeName, newEmployeeEmail, newEmployeePhone, addEmployee);
            hbox.setSpacing(5);
            hLabels.getChildren().addAll(newEmployeeNameLiteral, newEmployeeEmailLiteral, newEmployeePhoneLiteral);
            hLabels.setSpacing(5);


            table.getColumns().addAll(id, name, email, phone);


        } else if (element == 2) { //PRODUCT
            title.setText(messages.getString("productButton"));

            TableColumn id = new TableColumn(messages.getString("idLiteral"));
            id.setPrefWidth(40);
            id.setStyle("-fx-font-size: 16");
            id.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productId"));
            id.setEditable(false);


            TableColumn name = new TableColumn(messages.getString("productNameLiteral"));
            name.setPrefWidth(MAX_SIZE_ELEMENT);
            name.setStyle("-fx-font-size: 16");
            name.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
            name.setCellFactory(TextFieldTableCell.forTableColumn());
            name.setOnEditCommit((EventHandler<CellEditEvent<Product, String>>) event -> {
                if (productValidName(event.getNewValue()) != null)
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setProductName(event.getNewValue());
                else {
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setProductName(event.getOldValue());                }
            });

            TableColumn price = new TableColumn(messages.getString("productPriceLiteral"));
            price.setPrefWidth(MAX_SIZE_ELEMENT);
            price.setStyle("-fx-font-size: 16");
            price.setCellValueFactory(new PropertyValueFactory<Product, Double>("productPrice"));
            price.setCellFactory(TextFieldTableCell.<Product, Double>forTableColumn(new DoubleStringConverter()));
            price.setOnEditCommit((EventHandler<CellEditEvent<Product, Double>>) event -> {
                if (productValidPrice(event.getNewValue().toString()) != -1)
                     event.getTableView().getItems().get(event.getTablePosition().getRow()).setProductPrice(event.getNewValue());
                else
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setProductPrice(event.getOldValue());
            });

            TableColumn amount = new TableColumn(messages.getString("productAmountLiteral"));
            amount.setPrefWidth(MAX_SIZE_ELEMENT);
            amount.setStyle("-fx-font-size: 16");
            amount.setCellValueFactory(new PropertyValueFactory<Product, Double>("productAmount"));
            amount.setCellFactory(TextFieldTableCell.<Product, Integer>forTableColumn(new IntegerStringConverter()));
            amount.setOnEditCommit((EventHandler<CellEditEvent<Product, Integer>>) event -> {
                 if (productValidAmount(event.getNewValue().toString()) != -1)
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setProductAmount(event.getNewValue());
                else
                    event.getTablePosition().getTableView().setStyle(INVALID_INPUT);
            });

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

            title.setText(messages.getString("storeButton"));

            TableColumn id = new TableColumn(messages.getString("idLiteral"));
            id.setPrefWidth(40);
            id.setStyle("-fx-font-size: 16");
            id.setCellValueFactory(new PropertyValueFactory<Store, Integer>("storeId"));
            id.setEditable(false);

            TableColumn name = new TableColumn(messages.getString("storeNameLiteral"));
            name.setPrefWidth(MAX_SIZE_ELEMENT);
            name.setStyle("-fx-font-size: 16");
            name.setCellValueFactory(new PropertyValueFactory<Store, String>("storeName"));
            name.setCellFactory(TextFieldTableCell.forTableColumn());
            name.setOnEditCommit((EventHandler<CellEditEvent<Store, String>>) event -> {
                if (storeValidName(event.getNewValue()) != null)
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setStoreName(event.getNewValue());
                else
                    System.out.println("aDD ERROR MESSAGE");
            });

            TableColumn phone = new TableColumn(messages.getString("storePhoneLiteral"));
            phone.setPrefWidth(MAX_SIZE_ELEMENT);
            phone.setStyle("-fx-font-size: 16");
            phone.setCellValueFactory(new PropertyValueFactory<Store, String>("storePhone"));
            phone.setCellFactory(TextFieldTableCell.forTableColumn());
            phone.setOnEditCommit((EventHandler<CellEditEvent<Store, String>>) event -> {
                if (storeValidPhone(event.getNewValue()) != null)
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setStorePhone(event.getNewValue());
                else
                    System.out.println("aDD ERROR MESSAGE");
            });


            TableColumn address = new TableColumn(messages.getString("storeAddressLiteral"));
            address.setPrefWidth(MAX_SIZE_ELEMENT);
            address.setStyle("-fx-font-size: 16");
            address.setCellValueFactory(new PropertyValueFactory<Store, String>("storeAddress"));
            address.setCellFactory(TextFieldTableCell.forTableColumn());
            address.setOnEditCommit((EventHandler<CellEditEvent<Store, String>>) event -> {
                if (storeValidAddress(event.getNewValue()) != null)
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setStoreAddress(event.getNewValue());
                else
                    System.out.println("aDD ERROR MESSAGE");
            });


            TableColumn<Store,Employee> manager = new TableColumn(messages.getString("storeManagerLiteral"));
            manager.setPrefWidth(MAX_SIZE_ELEMENT);
            manager.setStyle("-fx-font-size: 16");
            //Fix manager

            table.setItems(stores);

            TextField newStoreName = new TextField();
            newStoreName.setPromptText(messages.getString("storeNameLiteral"));
            newStoreName.setPrefWidth(210);
            Text newStoreNameLiteral = new Text(messages.getString("storeNameLiteral"));
            newStoreNameLiteral.setWrappingWidth(210);
            newStoreName.setStyle(NEW_INPUT);


            TextField newStorePhone = new TextField();
            newStorePhone.setPromptText(messages.getString("storePhoneLiteral"));
            newStorePhone.setPrefWidth(210);
            Text newStorePhoneLiteral = new Text(messages.getString("storePhoneLiteral"));
            newStorePhoneLiteral.setWrappingWidth(210);
            newStorePhone.setStyle(NEW_INPUT);
            
            TextField newStoreAddress = new TextField();
            newStoreAddress.setPromptText(messages.getString("storeAddressLiteral"));
            newStoreAddress.setPrefWidth(210);
            Text newStoreAddressLiteral = new Text(messages.getString("storeAddressLiteral"));
            newStoreAddressLiteral.setWrappingWidth(210);
            newStoreAddress.setStyle(NEW_INPUT);

            TextField newStoreManager = new TextField();
            newStoreManager.setPromptText(messages.getString("storeManagerLiteral"));
            newStoreManager.setPrefWidth(210);
            Text newStoreManagerLiteral = new Text(messages.getString("storeManagerLiteral"));
            newStoreManagerLiteral.setWrappingWidth(210);
            newStoreManager.setStyle(NEW_INPUT);

            Button addStore = new Button("Add");
            addStore.setOnAction(event -> {
                if (storeValidName(newStoreName.getText()) != null &&
                        storeValidPhone(newStorePhone.getText()) != null &&
                        storeValidAddress(newStoreAddress.getText()) != null &&
                        storeValidManager(newStoreManager.getText()) != null ){

                    stores.add(new Store(newStoreName.getText(), newStorePhone.getText(),newStoreAddress.getText(),employees.get(1)));


                    newStoreName.clear();
                    newStorePhone.clear();
                    newStoreAddress.clear();
                    newStoreManager.clear();


                    newStoreName.setStyle(NEW_INPUT);
                    newStorePhone.setStyle(NEW_INPUT);
                    newStoreAddress.setStyle(NEW_INPUT);
                    newStoreManager.setStyle(NEW_INPUT);


                } else {

                    if (storeValidName(newStoreName.getText()) == null) {
                        newStoreName.clear();
                        newStoreName.setStyle(INVALID_INPUT);
                    } else {
                        newStoreName.setStyle(VALID_INPUT);
                    }
                    if (storeValidPhone(newStorePhone.getText()) == null) {
                        newStorePhone.clear();
                        newStorePhone.setStyle(INVALID_INPUT);
                    } else {
                        newStorePhone.setStyle(VALID_INPUT);
                    }
                    if (storeValidAddress(newStoreAddress.getText()) == null) {
                        newStoreAddress.clear();
                        newStoreAddress.setStyle(INVALID_INPUT);
                    } else {
                        newStoreAddress.setStyle(VALID_INPUT);
                    }

//                    if (storeValidManager(newStoreManager.getText() == null)) {
//                        newStoreManager.clear();
//                        newStoreManager.setStyle(INVALID_INPUT);
//                    } else {
//                        newStoreManager.setStyle(VALID_INPUT);
//                    }



                }
            });


            //Add spacing and elements to HORIZONTAL
            hbox.getChildren().addAll(newStoreName, newStorePhone, newStoreAddress, newStoreManager,addStore);
            hbox.setSpacing(5);
            hLabels.getChildren().addAll(newStoreNameLiteral, newStorePhoneLiteral,newStoreAddressLiteral,newStoreManagerLiteral);
            hLabels.setSpacing(5);


            table.getColumns().addAll(id, name,phone,address,manager);
        }

        //Title
        TITLE_ALIGN_CENTER(title);
        table.setPrefHeight(WINDOW_Y / 1.6);

        //Vbox properties and adding child
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 20, 10, 20));
        vbox.getChildren().addAll(title, table, hbox, hLabels);

        return new Scene(vbox, WINDOW_X, WINDOW_Y);
    }


    protected void saveNewInputSER() throws IOException{

        saveNewProductInputSER(PRODUCT_FILE);

        Button button = new Button(messages.getString("confirmExit"));
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            System.exit(0);
        });
        button.setMaxSize(200,100);
        GridPane group = new GridPane();

        group.getChildren().add(button);
        group.setAlignment(Pos.CENTER);
        Scene scene = new Scene(group,300,150);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(messages.getString("confirmExit"));
        stage.show();
        stage.setAlwaysOnTop(true);
        stage.centerOnScreen();
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



