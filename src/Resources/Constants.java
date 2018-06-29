package Resources;

import java.io.File;

public interface Constants {

    String PRODUCT_PATH = "/tmp/product.ser";
    String EMPLOYEE_PATH = "/tmp/employee.ser";
    String STORE_PATH = "/tmp/store.ser";

    File PRODUCT_FILE = new File(PRODUCT_PATH);
    File EMPLOYEE_FILE = new File(EMPLOYEE_PATH);
    File STORE_FILE = new File(STORE_PATH);
}
