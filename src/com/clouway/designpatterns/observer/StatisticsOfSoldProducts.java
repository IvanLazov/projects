package com.clouway.designpatterns.observer;

import java.util.Hashtable;
import java.util.Map;

/**
 * StatisticsOfSoldProducts class is used to maintain a statistic
 * of all products that are sold from the store
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class StatisticsOfSoldProducts implements ObserverForSoldProducts {
    
    private Map<String, Integer> listOfSoldProducts = new Hashtable<String, Integer>();

    /**
     * Update the list of sold products
     *
     * @param productName name of sold product
     * @param productQuantity sold quantity
     */
    public void update(String productName, int productQuantity) {
        
        if (!listOfSoldProducts.containsKey(productName)) {
            listOfSoldProducts.put(productName, productQuantity);    
        } else {
            int currentQuantity = listOfSoldProducts.get(productName);
            listOfSoldProducts.put(productName, currentQuantity + productQuantity);
        }
    }

    public void getState() {

        System.out.println("Sold products: " + listOfSoldProducts);
    }
}
