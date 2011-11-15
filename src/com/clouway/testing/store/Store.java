package com.clouway.testing.store;

import java.util.*;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Store {

    private Map<String, Product> listOfProducts = new Hashtable<String, Product>();

    /**
     * Register product in store.
     * Cannot register product that is already registered.
     *
     * @param product   Product that will be registered
     */
    public void registerProduct(Product product) {

        if (isProductInStore(product.getProductName())) {
            throw new ProductIsRegisteredException();
        } else {
            listOfProducts.put(product.getProductName(), product);
        }
    }

    /**
     * Verify that product is in store
     *
     * @param productName   Name of product
     * @return true   If product is in store
     */
    public boolean isProductInStore(String productName) {

        if (listOfProducts.containsKey(productName)) {
            return true;
        }

        return false;
    }

    /**
     * Increase quantity of product
     *
     * @param productName   Name of product
     * @param quantityToAdd  Quantity to be added
     */
    public void increaseQuantityOfProduct(String productName, int quantityToAdd) {

        if (isProductInStore(productName)) {
            if (currentProductQuantity(productName) + quantityToAdd > maximumProductQuantity(productName)) {
                throw new ReachedMaximumQuantityOfProductException();
            } else {
                listOfProducts.get(productName).setProductCurrentQuantity(currentProductQuantity(productName) + quantityToAdd);
            }
        }
    }

    /**
     * Decreases quantity of product
     *
     * @param productName   name of product
     * @param quantityToSell   quantity to be sold
     */
    public void decreaseQuantityOfProduct(String productName, int quantityToSell) {

        if (isProductInStore(productName)) {

            if ((currentProductQuantity(productName) - quantityToSell) < 0) {

                throw new InsufficientQuantityOfProductException();

            } else {

                listOfProducts.get(productName).setProductCurrentQuantity(currentProductQuantity(productName) - quantityToSell);

            }
        }
    }

    /**
     * Returns product with the specified name
     *
     * @param productName   name of product
     * @return Product
     */
    public Product getProduct(String productName) {
        return listOfProducts.get(productName);
    }

    /**
     * Sort the registered products in store by price
     */
    public List<Product> sortProducts() {

        List<Product> arrayList = new ArrayList<Product>(listOfProducts.values());
        Collections.sort(arrayList);

        return arrayList;
    }

    /**
     * Returns the maximum quantity of the product that can be stored
     *
     * @param productName   the name of the product
     * @return the maximum quantity of the product
     */
    private int maximumProductQuantity(String productName) {
        return listOfProducts.get(productName).getProductMaxQuantity();
    }

    /**
     * Returns the current quantity of the product
     *
     * @param productName the name of the product
     * @return the maximum quantity of the product, that can be stored
     */
    int currentProductQuantity(String productName) {
        return listOfProducts.get(productName).getProductCurrentQuantity();
    }
}
