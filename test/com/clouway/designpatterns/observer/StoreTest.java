package com.clouway.designpatterns.observer;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class StoreTest {

    private final Map<String, Product> listOfRegisteredProducts = new HashMap<String, Product>();

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
    public void sellProductFromStore() {

        store.sell(product.getName());
        assertEquals(null, listOfRegisteredProducts.get(product.getName()));
    }

    @Test
    public void sellingProductFromStoreShouldNotifyListener() {

        store.addSoldProductListener(mockSoldProductListener);
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
