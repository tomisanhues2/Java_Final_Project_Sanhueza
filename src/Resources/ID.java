package Resources;

import java.text.DecimalFormat;

public abstract class ID {

    public static int employeeId = 0;
    public static int storeId = 0;
    public static int productId = 0;

    public final DecimalFormat FORMAT_DOUBLE_CURRENCY = new DecimalFormat(
            "#.##");

    public int getEmployeeId() {
        return employeeId;
    }

    public int getStoreId() {
        return storeId;
    }

    public int getProductId() {
        return productId;
    }

    public final void addProductId() {
        productId++;
    }

    public final void addEmployeeId() {
        employeeId++;
    }

    public final void addStoreId() {
        storeId++;
    }
}
