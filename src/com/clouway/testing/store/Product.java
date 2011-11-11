package com.clouway.testing.store;

public class Product implements Comparable<Product> {

    private String productName;
    private int productQuantity;
    private int productMaxQuantity;
    private double productPrice;

    public Product(String productName, int productQuantity, int productMaxQuantity, double productPrice) {

        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productMaxQuantity = productMaxQuantity;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public int getProductMaxQuantity() {
        return productMaxQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
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
}
