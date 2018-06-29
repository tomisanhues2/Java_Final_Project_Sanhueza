package Objects;

import Resources.ID;

import java.io.Serializable;

public class Product extends ID implements Serializable {

    private String productName; //Objects.Store product name
    private double productPrice; //Objects.Store product price per bag
    private int productAmount;  //Objects.Store product quantity per bag
    int productId;

    public Product(String productName, double productPrice, int productAmount) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
        addProductId();
        productId = super.getProductId();

    }

    @Override
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    @Override
    public String toString() {
        return "-----------------------------------\n" + String.format("Objects.Product ID: %d\nObjects.Product Name: %s\nObjects.Product Price per bag: %.2f\nObjects.Product Quantity per bag: %d\n",productId,getProductName(),getProductPrice(),getProductAmount()) + "-----------------------------------\n";
    }
}
