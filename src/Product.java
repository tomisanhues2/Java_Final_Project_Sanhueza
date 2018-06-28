import java.io.Serializable;

public class Product extends AProduct implements Serializable {

    private String productName; //Store product name
    private double productPrice; //Store product price per bag
    private int productAmount;  //Store product quantity per bag

    private int Id;

    public Product(String productName, double productPrice, int productAmount) {
        super();
        this.productName = productName;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
        Id = super.getId();
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
    public int getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "-----------------------------------\n" + String.format("Product ID: %d\nProduct Name: %s\nProduct Price per bag: %.2f\nProduct Quantity per bag: %d\n",getId(),getProductName(),getProductPrice(),getProductAmount()) + "-----------------------------------\n";
    }
}
