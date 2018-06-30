package Objects;

import Resources.ID;

import java.io.Serializable;

public class Store extends ID implements Serializable {

    private String storeName;
    private String storePhone;
    private String storeAddress;
    private Employee storeManager;
    int storeId;

    public Store(String storeName, String storePhone, String storeAddress, Employee storeManager) {
        this.storeName = storeName;
        this.storePhone = storePhone;
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

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
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
