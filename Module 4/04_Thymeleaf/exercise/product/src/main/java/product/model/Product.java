package product.model;

public class Product {
    private Integer id;
    private String name;
    private double price;
    private String productType;

    public Product(Integer id, String name, double price, String productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
