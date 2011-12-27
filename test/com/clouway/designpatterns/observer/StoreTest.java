package com.clouway.designpatterns.observer;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
@RunWith(JMock.class)
public class StoreTest {

    private final Map<String, Product> listOfRegisteredProducts = new HashMap<String, Product>();
    private final List<Product> listOfSoldProducts = new ArrayList<Product>();
    
    private Mockery context = new JUnit4Mockery();

    private final RegisteredProductListener registeredProductListener = context.mock(RegisteredProductListener.class);
    private final SoldProductListener soldProductListener = context.mock(SoldProductListener.class);

    @Test
    public void registerProductInStore() {

        Store store = new Store(listOfRegisteredProducts);
        Product product = new Product("Acer");
        store.addRegisterProductListener(new RegisteredProducts(listOfRegisteredProducts));
        store.register(product);
        assertEquals(product, listOfRegisteredProducts.get("Acer"));
    }
    
    @Test
    public void registeringProductInStoreShouldNotifyListener() {
        
        final Product product = new Product("Acer");
        Store store = new Store(listOfRegisteredProducts);
        store.addRegisterProductListener(registeredProductListener);

        context.checking(new Expectations(){{
            oneOf(registeredProductListener).onRegisteredProductUpdate(product);
        }});

        store.register(product);
    }
    
    @Test
    public void registeredProductMustBeInTheRegisteredProductsList() {
        
        Product product = new Product("Acer");
        Store store = new Store(listOfRegisteredProducts);
        store.addRegisterProductListener(new RegisteredProducts(listOfRegisteredProducts));
        store.register(product);
        assertEquals(product, listOfRegisteredProducts.get("Acer"));
    }

    @Test
    public void sellProductFromStore() {
        
        Product product = new Product("Acer");
        Store store = new Store(listOfRegisteredProducts);
        store.addRegisterProductListener(new RegisteredProducts(listOfRegisteredProducts));
        store.addSoldProductListener(new SoldProduct(new ArrayList<Product>()));

        store.register(product);        
        store.sell("Acer");
        assertEquals(null, listOfRegisteredProducts.get("Acer"));
    }

    @Test
    public void sellingProductFromStoreShouldNotifyListener() {
        
        final Product product = new Product("Acer");
        Store store = new Store(listOfRegisteredProducts);
        store.addRegisterProductListener(new RegisteredProducts(listOfRegisteredProducts));
        store.addSoldProductListener(soldProductListener);
        store.register(product);

        context.checking(new Expectations(){{
            oneOf(soldProductListener).onSoldProductUpdate(product);
        }});

        store.sell(product.getName());
    }

    @Test
    public void soldProductMustBeInTheSoldProductsList() {

        Product product = new Product("Acer");
        Store store = new Store(listOfRegisteredProducts);

        store.addRegisterProductListener(new RegisteredProducts(listOfRegisteredProducts));
        store.addSoldProductListener(new SoldProduct(listOfSoldProducts));

        store.register(product);
        store.sell(product.getName());
        assertEquals(product, listOfSoldProducts.get(0));
    }
}
