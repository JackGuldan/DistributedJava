package us.Lab4.model;

public class Item {
    private int productNumer;
    private String name;
    private double price;
    private boolean featured;
    private String description;
    private String image;

    public Item(int productNumer, double price, String description) {
        this.productNumer = productNumer;
        this.price = price;
        this.description = description;
    }

    public Item() {

    }

    public int getProductNumer() {
        productNumer = 1;
        return productNumer;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isFeatured() {
        return featured;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}
