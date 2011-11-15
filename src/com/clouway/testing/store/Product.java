package com.clouway.testing.store;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Product implements Comparable<Product> {

    private String productName; // name of product
    private int productCurrentQuantity = 0; // current quantity of product in store
    private int productMaxQuantity; // maximum quantity of product that can be stored
    private double productPrice; // price of product

    public Product(String productName, int productMaxQuantity, double productPrice) {
        this.productName = productName;
        this.productMaxQuantity = productMaxQuantity;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductCurrentQuantity() {
        return productCurrentQuantity;
    }

    public int getProductMaxQuantity() {
        return productMaxQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductCurrentQuantity(int productCurrentQuantity) {
        this.productCurrentQuantity = productCurrentQuantity;
    }

    public int compareTo(Product product) {
        if (this.productPrice > product.productPrice) {
            return 1;
        } else if (this.productPrice < product.productPrice) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productCurrentQuantity=" + productCurrentQuantity +
                ", productMaxQuantity=" + productMaxQuantity +
                ", productPrice=" + productPrice +
                '}';
    }
}
