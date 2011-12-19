package com.clouway.designpatterns.observer;

/**
 * ObservedStore is an interface that provides two methods.
 * The first method is used to add an observer which monitors
 * registering new products in the store, and the second method
 * is used to add an observer which monitors selling products from the store
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface ObservedStore {

    public void addObserverForRegisteredProducts(ObserverForRegisteredProducts observer);
    public void addObserverForSoldProducts(ObserverForSoldProducts observer);
}
