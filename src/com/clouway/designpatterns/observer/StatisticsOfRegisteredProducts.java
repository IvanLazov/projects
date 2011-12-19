package com.clouway.designpatterns.observer;

import java.util.Map;

/**
 * StatisticsOfRegisteredProducts class is used to maintain
 * a statistic of all registered products in the store.
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class StatisticsOfRegisteredProducts implements ObserverForRegisteredProducts {

    private Map<String, Product> listOfProducts;

    /**
     * Update the list of registered products
     *
     * @param listOfProducts list of registered products
     */
    public void update(Map<String, Product> listOfProducts) {

        this.listOfProducts = listOfProducts;
    }

    public void getState() {

        System.out.println("Registered Products: " + listOfProducts);
    }
}
