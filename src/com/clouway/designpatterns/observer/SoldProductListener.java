package com.clouway.designpatterns.observer;

/**
 * SoldProductListener have a method which enables the class that implements
 * that interface to receive updates when a product is sold from the Store
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface SoldProductListener {

    void onSoldProductUpdate(Product product); // when a product is sold from the store, the class is notified about which product is sold
}
