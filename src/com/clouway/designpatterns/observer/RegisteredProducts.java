package com.clouway.designpatterns.observer;

import java.util.Map;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class RegisteredProducts implements RegisteredProductListener {

    private Map<String, Product> listOfAvailableProducts;

    public RegisteredProducts(Map<String, Product> listOfAvailableProducts) {

        this.listOfAvailableProducts = listOfAvailableProducts;
    }

    public void onRegisteredProductUpdate(Map<String, Product> listOfAvailableProducts) {

        this.listOfAvailableProducts = listOfAvailableProducts;
    }
}
