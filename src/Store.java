import java.io.Serializable;

public class Store extends AStore implements Serializable {

    private String storeName;
    private String storePhoneNum;
    private String storeAddress;
    private Employee storeManager;
    private int storeId;


    public Store() {
        storeId = getId();
    }

    public Store(String storeName, String storePhoneNum, String storeAddress, Employee storeManager) {
        this.storeName = storeName;
        this.storePhoneNum = storePhoneNum;
        this.storeAddress = storeAddress;
        this.storeManager = storeManager;
        storeId = getId() + 1;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStorePhoneNum() {
        return storePhoneNum;
    }

    public void setStorePhoneNum(String storePhoneNum) {
        this.storePhoneNum = storePhoneNum;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public Employee getStoreManager() {
        return storeManager;
    }

    public void setStoreManager(Employee storeManager) {
        this.storeManager = storeManager;
    }
}
