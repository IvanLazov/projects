package com.clouway.designpatterns.observer;

/**
 * ObserverForSoldProducts interface provides two methods.
 * Method update() is used to notify that a new product have been sold from the store.
 * Method getState() is used to display the products which are sold from the store
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface ObserverForSoldProducts {
    
    public void update(String productName, int productQuantity);
    public void getState();
}
