package controller;

import Objects.Employee;
import Objects.Product;
import Objects.Store;
import Resources.Constants;
import Resources.IObservableLists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MenuBarController implements Constants, IObservableLists {


    @FXML
    public void menuBarButton(ActionEvent event) {
        try {
            saveNewProductInputSER(PRODUCT_FILE);
            //saveNewEmployee
            //saveNewStore

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.exit(1);
        }
    }

    private void saveNewProductInputSER(File file) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOut);
        ArrayList<Product> productArrayList = new ArrayList<>(products);
        objectOutputStream.writeObject(productArrayList);
        objectOutputStream.close();
        fileOut.close();
    }

    private void saveNewEmployeeInputSER(File file) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOut);
        ArrayList<Employee> productArrayList = new ArrayList<>(employees);
        objectOutputStream.writeObject(productArrayList);
        objectOutputStream.close();
        fileOut.close();
    }

    private void saveNewStoreInputSER(File file) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOut);
        ArrayList<Store> productArrayList = new ArrayList<>(stores);
        objectOutputStream.writeObject(productArrayList);
        objectOutputStream.close();
        fileOut.close();
    }
}
