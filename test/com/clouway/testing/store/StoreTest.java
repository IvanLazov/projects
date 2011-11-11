package com.clouway.testing.store;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Hashtable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class StoreTest {

    private Store store;
    private Hashtable<String, Product> listOfProducts = new Hashtable<String, Product>();

    @Before
    public void setUp() {

        store = new Store(listOfProducts);
        Product product = new Product("PS3", 10, 1000, 399.00);
        Product productTwo = new Product("Xbox", 30, 2500, 599.00);
        store.add(product);
        store.add(productTwo);
    }

    @Test
    public void verifyTheProductIsInTheStore() {

        assertTrue(store.isProductInStore("PS3"));
    }

    @Test
    public void increaseQuantityOfProduct() {

        store.increaseQuantity("Xbox", 10);
        assertEquals(40, listOfProducts.get("Xbox").getProductQuantity());
    }

    @Test
    public void sellProduct() {

        store.sell("PS3", 8);
        assertEquals(2, listOfProducts.get("PS3").getProductQuantity());
    }

    @Test(expected = InsufficientQuantityOfProductException.class)
    public void cannotSellProductWithInsufficientQuantity() {

        store.sell("PS3", 300);
    }

    @Test(expected = ReachedMaximumQuantityOfProductException.class)
    public void cannotIncreaseProductQuantityMoreThanTheProductMaximumQuantity() {

        store.increaseQuantity("PS3", 1000);
    }

    @Test
    public void printElementsOfStore() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        store.sortProducts(new PrintStream(out));
        assertEquals("PS3 399.0\nXbox 599.0\n", new String(out.toByteArray()));
    }
}
