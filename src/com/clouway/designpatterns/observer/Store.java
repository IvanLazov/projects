package com.clouway.designpatterns.observer;

import java.util.Map;

/**
 * Store contains a list of registered products. It has methods for adding and selling product from the Store.
 * Also it has two listeners which are used to notify when a product is registered / sold from the Store
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Store {

    private final Map<String, Product> listOfRegisteredProducts; // list of registered products

    private RegisteredProductListener registeredProductListener; // this listener is used to notify that a new product have been registered in the store
    private SoldProductListener soldProductListener; // this listener is used to notify that a product have been sold from the store

    /**
     * Constructor initialize the list of registered products
     *
     * @param listOfRegisteredProducts list containing the current registered products
     */
    public Store(Map<String, Product> listOfRegisteredProducts) {

        this.listOfRegisteredProducts = listOfRegisteredProducts;
    }

    /**
     * Register a new product to the Store
     *
     * @param product product to be registered
     */
    public void register(Product product) {

        listOfRegisteredProducts.put(product.getName(), product);

        if (registeredProductListener != null) {
            registeredProductListener.onRegisteredProductUpdate(product);
        }
    }

    /**
     * Add a RegisterProductListener to the Store
     *
     * @param listener listener which will be used to notify for new registered product
     */
    public void addRegisterProductListener(RegisteredProductListener listener) {

        registeredProductListener = listener;
    }

    /**
     * Sell a product from the Store
     *
     * @param product product to be sold
     */
    public void sell(String product) {

        soldProductListener.onSoldProductUpdate(listOfRegisteredProducts.get(product));

        if (soldProductListener != null) {
            listOfRegisteredProducts.remove(product);
        }
    }

    /**
     * Add a SoldProductListener to the Store
     *
     * @param listener listener which will be used to notify for a sold product
     */
    public void addSoldProductListener(SoldProductListener listener) {

        this.soldProductListener = listener;
    }
}
