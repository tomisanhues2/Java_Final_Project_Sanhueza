package Resources;

import Objects.Employee;
import Objects.Product;
import Objects.Store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface IObservableLists {

    ObservableList<Store> stores = FXCollections.observableArrayList();
    ObservableList<Employee> employees = FXCollections.observableArrayList();
    ObservableList<Product> products = FXCollections.observableArrayList();

}
