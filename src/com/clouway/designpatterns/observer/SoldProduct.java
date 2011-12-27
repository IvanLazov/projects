package com.clouway.designpatterns.observer;

import java.util.List;

/**
 * SoldProducts class have a list which contains all sold products from the Store.
 * The class implements SoldProductListener so when a product is sold,
 * the class is notified and automatically updates it's list of sold products
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class SoldProduct implements SoldProductListener {

    private final List<Product> listOfSoldProducts;

    /**
     * Constructor initialize the list of sold products
     *
     * @param listOfSoldProducts contains the sold products from the store
     */
    public SoldProduct(List<Product> listOfSoldProducts) {

        this.listOfSoldProducts = listOfSoldProducts;
    }

    /**
     * Updates the list of sold products when a product is sold from the Store
     *
     * @param product product to be added to the list of sold products
     */
    public void onSoldProductUpdate(Product product) {

        listOfSoldProducts.add(product);
    }
}
