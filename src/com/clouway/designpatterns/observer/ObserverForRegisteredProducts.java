package com.clouway.designpatterns.observer;

import java.util.Map;

/**
 * ObserverForRegisteredProducts interface provides two methods.
 * Method update() is used to update that a new product in the store have been registered.
 * Method getState() is used to display the products which are registered in the store
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface ObserverForRegisteredProducts {

    public void update(Map<String, Product> listOfProducts);
    public void getState();
}
