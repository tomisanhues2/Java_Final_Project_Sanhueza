package Objects;

import Resources.ID;

import java.io.Serializable;

public class Store extends ID implements Serializable {

    private String storeName;
    private String storePhoneNum;
    private String storeAddress;
    private Employee storeManager;
    int storeId;

    public Store(String storeName, String storePhoneNum, String storeAddress, Employee storeManager) {
        this.storeName = storeName;
        this.storePhoneNum = storePhoneNum;
        this.storeAddress = storeAddress;
        this.storeManager = storeManager;
        addStoreId();
        storeId = super.getStoreId();
    }

    @Override
    public int getStoreId() {
        return storeId;
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
