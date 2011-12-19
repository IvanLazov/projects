package com.clouway.designpatterns.observer;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Main {
    
    public static void main(String[] args) {

        // Create Store object
        Store store = new Store();

        // Define observers for registered and sold products
        ObserverForRegisteredProducts registeredProducts = new StatisticsOfRegisteredProducts();
        ObserverForSoldProducts soldProducts = new StatisticsOfSoldProducts();

        // Register observers
        store.addObserverForRegisteredProducts(registeredProducts);
        store.addObserverForSoldProducts(soldProducts);

        // Register two products and increase their quantity
        store.registerProduct(new Product("PS3", 1000, 599.00));
        store.registerProduct(new Product("Xbox 360", 1000, 499.00));
        store.increaseQuantityOfProduct("PS3", 100);
        store.increaseQuantityOfProduct("Xbox 360", 200);

        registeredProducts.getState();

        // Sell two products
        store.sellProduct("PS3", 26);
        store.sellProduct("Xbox 360", 14);

        registeredProducts.getState();
        soldProducts.getState();
    }
}
