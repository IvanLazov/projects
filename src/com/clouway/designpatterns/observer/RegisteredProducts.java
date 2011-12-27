package com.clouway.designpatterns.observer;

import java.util.Map;

/**
 * RegisteredProducts class have a list which saves registered products in the Store.
 * The class implements RegisteredProductListener so when a new product is added,
 * the class is notified and automatically updates the list
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class RegisteredProducts implements RegisteredProductListener {

    private Map<String, Product> listOfRegisteredProducts;

    /**
     * Constructor initialize the list of registered products
     *
     * @param listOfRegisteredProducts contains the registered products in the store
     */
    public RegisteredProducts(Map<String, Product> listOfRegisteredProducts) {

        this.listOfRegisteredProducts = listOfRegisteredProducts;
    }

    /**
     * Updates the list of registered products when a new product is registered
     *
     * @param product product to be added to the list of registered products
     */
    public void onRegisteredProductUpdate(Product product) {

        this.listOfRegisteredProducts.put(product.getName(), product);
    }
}
