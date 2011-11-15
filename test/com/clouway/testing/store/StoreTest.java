package com.clouway.testing.store;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StoreTest {

    private Store store;

    @Before
    public void setUp() {

        store = new Store();

        store.registerProduct(new Product("PS3", 1000, 599.00));
        store.registerProduct(new Product("Xbox", 3000, 399.00));
        store.registerProduct(new Product("Wii", 500, 299.00));
    }

    @Test
    public void registerProductInStore() {

        store.registerProduct(new Product("Xbox 360", 4000, 799.00));
        assertTrue(store.isProductInStore("Xbox 360"));
    }

    @Test
    public void isProductInStore() {
        assertTrue(store.isProductInStore("PS3"));
    }

    @Test(expected = ProductIsRegisteredException.class)
    public void cannotRegisterExistingProduct() {
        store.registerProduct(new Product("Xbox", 3000, 899.00));
    }

    @Test
    public void increaseQuantityOfProduct() {

        store.increaseQuantityOfProduct("PS3", 10);
        assertEquals(10, store.getProduct("PS3").getProductCurrentQuantity());
    }

    @Test
    public void sellProductIfThereIsEnoughQuantity() {

        store.increaseQuantityOfProduct("PS3", 10);
        store.decreaseQuantityOfProduct("PS3", 8);
        assertEquals(2, store.getProduct("PS3").getProductCurrentQuantity());
    }

    @Test(expected = InsufficientQuantityOfProductException.class)
    public void cannotSellProductWithInsufficientQuantity() {

        store.decreaseQuantityOfProduct("PS3", 300);
    }

    @Test(expected = ReachedMaximumQuantityOfProductException.class)
    public void cannotIncreaseProductQuantityMoreThanTheProductMaximumQuantity() {

        store.increaseQuantityOfProduct("PS3", 2000);
    }

    @Test
    public void sortElementsOfStoreByPrice() {

        double[] productsPrice = {299.00, 399.00, 599.00};

        Product[] products = new Product[store.sortProducts().size()];
        products = store.sortProducts().toArray(products);

        for (int i = 0; i < products.length; i++) {
            assertEquals(productsPrice[i], products[i].getProductPrice(), 0);
        }
    }
}
