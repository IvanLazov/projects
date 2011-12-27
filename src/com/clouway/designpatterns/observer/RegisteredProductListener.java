package com.clouway.designpatterns.observer;

/**
 * RegisteredProductListener interface defines one method which enables
 * the class that implements it to receive updates when a new product is registered in the Store
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface RegisteredProductListener {

    void onRegisteredProductUpdate(Product product); // when a product is added to the store, the class is notified about which product is added
}
