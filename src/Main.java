import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        products.forEach((store -> System.out.println(products)));
//        ReaderManager readerManager = new ReaderManager();
//        WriterManager writerManager = new WriterManager();
//        writerManager.createNewTemplateFile();
    }

    private static void initializeProgram() {
        retrieveData();
    }

    private static void retrieveData() {
        try {
            FileInputStream FEmployee = new FileInputStream("/tmp/employee.ser");
            FileInputStream FProduct = new FileInputStream("/tmp/product.ser");
            FileInputStream FStore = new FileInputStream("/tmp/store.ser");
            FileInputStream FInventory = new FileInputStream("/tmp/inventory.ser");
            ObjectInputStream OEmployee = new ObjectInputStream(FEmployee);
            ObjectInputStream OProduct = new ObjectInputStream(FProduct);
            ObjectInputStream OStore = new ObjectInputStream(FStore);
            ObjectInputStream OInventory = new ObjectInputStream(FInventory);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error in block");
        }
    }
}
