package com.clouway.designpatterns.observer;

/**
 * SoldProductListener have a method which enables the class that implements
 * that interface to receive updates when a product is sold from the Store
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface SoldProductListener {

    /**
     * When a product is sold from the store, the class that implements this interface is notified
     *
     * @param product sold product
     */
    void onSoldProductUpdate(Product product);
}
