package controller;

import Objects.Employee;
import Objects.Product;
import Objects.Store;
import ResourceObjects.CustomScene;
import Resources.Constants;
import Resources.ID;
import Resources.IObservableLists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class NewEventController implements Constants, IObservableLists {

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
                    newRoot = fxmlLoader.load(
                            getClass().getClassLoader().getResource(
                                    "res/EmployeeView.fxml"), messages);
                    break;
                case "Products List":
                    newRoot = fxmlLoader.load(
                            getClass().getClassLoader().getResource(
                                    "res/ProductView.fxml"), messages);
                    break;
                case "Stores List":
                    newRoot = fxmlLoader.load(
                            getClass().getClassLoader().getResource(
                                    "res/StoreView.fxml"), messages);
                    break;
            }

            getEmployeeFromSER();
            getProductFromSER();
            getStoreFromSER();


            stage.setScene(new CustomScene(newRoot));

        } catch (IOException e) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getProductFromSER() throws IOException,
            ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(PRODUCT_PATH);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<Product> productArrayList = (ArrayList<Product>) in
                .readObject();
        products.addAll(productArrayList);
        ID.productId = products.size(); //change
        in.close();
        fileIn.close();
    }

    private void getEmployeeFromSER() throws IOException,
            ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(EMPLOYEE_PATH);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<Employee> productArrayList = (ArrayList<Employee>) in
                .readObject();
        employees.addAll(productArrayList);
        ID.employeeId = employees.size();
        in.close();
        fileIn.close();
    }

    private void getStoreFromSER() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(STORE_PATH);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<Store> productArrayList = (ArrayList<Store>) in.readObject();
        stores.addAll(productArrayList);
        ID.storeId = stores.size();
        in.close();
        fileIn.close();
    }
}
