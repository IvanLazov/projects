package com.clouway.designpatterns.observer;

import java.util.List;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class SoldProduct implements SoldProductListener {

    private final List<Product> listOfSoldProducts;

    public SoldProduct(List<Product> listOfSoldProducts) {

        this.listOfSoldProducts = listOfSoldProducts;
    }

    public void onSoldProductUpdate(Product product) {

        listOfSoldProducts.add(product);
    }
}
