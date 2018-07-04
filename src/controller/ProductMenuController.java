package controller;

import Objects.Product;
import Resources.Constants;
import Resources.ID;
import Resources.IObservableLists;
import Resources.Validation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProductMenuController extends Validation implements Constants,
        IObservableLists {


    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn productNameCol;
    @FXML
    private TableColumn productPriceCol;
    @FXML
    private TableColumn productAmountCol;

    @FXML
    private TextField newProductName;
    @FXML
    private TextField newProductPrice;
    @FXML
    private TextField newProductAmount;

    @FXML
    public void initialize() {
        productNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        productPriceCol.setCellFactory(TextFieldTableCell.<Product,
                Double>forTableColumn(new DoubleStringConverter()));
        productAmountCol.setCellFactory(TextFieldTableCell.<Product,
                Integer>forTableColumn(new IntegerStringConverter()));
        tableView.setItems(products);

    }

    @FXML
    public void productNameEdit(TableColumn.CellEditEvent<Product, String>
                                        event) {
        if (productValidName(event.getNewValue()) != null)
            event.getTableView().getItems().get(
                    event.getTablePosition().getRow())
                    .setProductName(
                            event.getNewValue());
        else {
            event.getTableView().getItems().get(
                    event.getTablePosition().getRow())
                    .setProductName(
                            event.getOldValue());
        }
    }

    @FXML
    public void productPriceEdit(TableColumn.CellEditEvent<Product, Double>
                                         event) {

        if (productValidPrice(event.getNewValue().toString()) != -1)
            event.getTableView().getItems().get(
                    event.getTablePosition().getRow())
                    .setProductPrice(
                            event.getNewValue());
        else
            event.getTableView().getItems().get(
                    event.getTablePosition().getRow())
                    .setProductPrice(
                            event.getOldValue());
    }

    @FXML
    public void productAmountEdit(TableColumn.CellEditEvent<Product, Integer>
                                          event) {

        if (productValidAmount(event.getNewValue().toString()) != -1)
            event.getTableView().getItems().get(
                    event.getTablePosition().getRow())
                    .setProductAmount(
                            event.getNewValue());
        else
            event.getTableView().getItems().get(event.getTablePosition()
                    .getRow()).setProductPrice(event.getOldValue());
    }

    @FXML
    public void addNewProduct(ActionEvent event) {
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
    }

}


