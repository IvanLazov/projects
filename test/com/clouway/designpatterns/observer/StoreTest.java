package com.clouway.designpatterns.observer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class StoreTest {

    private final Map<String, Product> listOfRegisteredProducts = new HashMap<String, Product>();
    private final List<Product> listOfSoldProducts = new ArrayList<Product>();

    private Store store = new Store(listOfRegisteredProducts);
    private Product product = new Product("Acer");

    private MockRegisteredProductListener mockRegisteredProductListener = new MockRegisteredProductListener();
    private MockSoldProductListener mockSoldProductListener = new MockSoldProductListener();

    @Before
    public void setUp() {
        
        store.register(product);
    }
    
    @Test
    public void registerProductInStore() {
        
        Product sony = new Product("Sony");
        store.register(sony);
        assertEquals(sony, listOfRegisteredProducts.get("Sony"));
    }

    @Test
    public void registeringProductInStoreShouldNotifyListener() {

        store.addRegisterProductListener(mockRegisteredProductListener);
        store.register(product);
        assertEquals(product, mockRegisteredProductListener.product);
    }

    @Test
    public void registeredProductMustBeInTheRegisteredProductsList() {

        store.register(product);
        assertEquals(product, listOfRegisteredProducts.get("Acer"));
    }

    @Test
    public void sellProductFromStore() {

        store.register(product);
        store.sell(product.getName());
        assertEquals(null, listOfRegisteredProducts.get(product.getName()));
    }

    @Test
    public void sellingProductFromStoreShouldNotifyListener() {

        store.addSoldProductListener(mockSoldProductListener);
        store.register(product);
        store.sell(product.getName());
    }

    @Test
    public void soldProductMustBeInTheSoldProductsList() {

        store.addSoldProductListener(mockSoldProductListener);
        store.register(product);
        store.sell(product.getName());
        assertEquals(product, mockSoldProductListener.product);
    }

    private class MockRegisteredProductListener implements RegisteredProductListener {

        private Product product;

        public void onRegisteredProductUpdate(Product product) {

            this.product = product;
        }
    }

    private class MockSoldProductListener implements SoldProductListener {

        private Product product;

        public void onSoldProductUpdate(Product product) {

            this.product = product;
        }
    }
}
