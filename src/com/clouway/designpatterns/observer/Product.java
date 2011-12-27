package com.clouway.designpatterns.observer;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Product {

    private final String name;

    public Product(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
}
