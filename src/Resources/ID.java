package Resources;

public abstract class ID {

    private static int employeeId = 0;
    private static int storeId = 0;
    private static int productId = 0;


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
