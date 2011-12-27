package com.clouway.designpatterns.observer;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Product {

    private final String name;
    private int quantity;

    public Product(String name, int quantity) {

        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {

        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
