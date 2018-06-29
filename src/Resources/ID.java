package Resources;

public abstract class ID {

    private static int employeeId = 0;
    private static int storeId = 0;
    private static int productId = 0;


    public int getEmployeeId() {
        return ++employeeId;
    }

    public static int getStoreId() {
        return ++storeId;
    }

    public static int getProductId() {
        return ++productId;
    }
}
