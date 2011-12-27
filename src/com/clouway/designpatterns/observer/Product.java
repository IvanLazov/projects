package com.clouway.designpatterns.observer;

/**
 * Product class is used to create objects that will be
 * registered/sold in/from the Store
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Product {

    private final String name; // name of product

    /**
     * Constructor initialize Product's name
     *
     * @param name name of Product
     */
    public Product(String name) {

        this.name = name;
    }

    /**
     * Return the name of the Product
     *
     * @return name of Product
     */
    public String getName() {

        return name;
    }
}
