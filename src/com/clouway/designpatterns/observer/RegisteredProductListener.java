package com.clouway.designpatterns.observer;

import java.util.Map;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface RegisteredProductListener {

    void onRegisteredProductUpdate(Map<String, Product> listOfAvailableProducts);
}
