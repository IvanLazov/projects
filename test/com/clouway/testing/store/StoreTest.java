package com.clouway.testing.store;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class StoreTest {

    private Store store;
    Product productXbox = new Product("Xbox", 3000, 399.00);
    Product productPS3 = new Product("PS3", 1000, 599.00);

    @Before
    public void setUp() {

        store = new Store();
        store.registerProduct(productPS3);
        store.registerProduct(productXbox);

        store.increaseQuantityOfProduct("PS3", 100);
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
    public void sellProductFromStore() {

        store.sellProduct("PS3", 20);
        assertEquals(80, store.getProduct("PS3").getProductCurrentQuantity());
    }

    @Test
    public void increaseQuantityOfProduct() {

        store.increaseQuantityOfProduct("PS3", 10);
        assertEquals(110, store.getProduct("PS3").getProductCurrentQuantity());
    }

    @Test
    public void decreaseQuantityOfProduct() {

        store.decreaseQuantityOfProduct("PS3", 10);
        assertEquals(90, store.getProduct("PS3").getProductCurrentQuantity());
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

        List<Product> products = store.getSortedProducts();

        assertEquals(productPS3, products.get(1));
        assertEquals(productXbox, products.get(0));
    }
}
