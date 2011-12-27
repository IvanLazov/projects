package com.clouway.designpatterns.observer;

import java.util.Map;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Store {

    private final Map<String, Product> listOfRegisteredProducts;

    private RegisteredProductListener registeredProductListener;
    private SoldProductListener soldProductListener;

    public Store(Map<String, Product> listOfRegisteredProducts) {

        this.listOfRegisteredProducts = listOfRegisteredProducts;
    }

    public void register(Product product) {

        listOfRegisteredProducts.put(product.getName(), product);
        registeredProductListener.onRegisteredProductUpdate(listOfRegisteredProducts);
    }

    public void addRegisterProductListener(RegisteredProductListener listener) {

        registeredProductListener = listener;
    }

    public void sell(String product) {

        soldProductListener.onSoldProductUpdate(listOfRegisteredProducts.get(product));
        listOfRegisteredProducts.remove(product);
    }

    public void addSoldProductListener(SoldProductListener listener) {

        this.soldProductListener = listener;
    }
}
