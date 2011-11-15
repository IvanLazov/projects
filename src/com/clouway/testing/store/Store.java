package com.clouway.testing.store;

import java.util.*;

/**
 * Store class can register new products and sell existing products.
 * Provides also a list which contains the current registered products sorted.
 *
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
     * Sell product from store
     *
     * @param productName   Name of product
     * @param quantity   quantity to be sold
     */
    public void sellProduct(String productName, int quantity) {
        decreaseQuantityOfProduct(productName,quantity);
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
     * @param quantity  Quantity to be added
     */
    public void increaseQuantityOfProduct(String productName, int quantity) {

        if (isProductInStore(productName)) {
            if (currentProductQuantity(productName) + quantity > maximumProductQuantity(productName)) {
                throw new ReachedMaximumQuantityOfProductException();
            } else {
                listOfProducts.get(productName).setProductCurrentQuantity(currentProductQuantity(productName) + quantity);
            }
        }
    }

    /**
     * Decreases quantity of product
     *
     * @param productName   name of product
     * @param quantity   quantity to be sold
     */
    public void decreaseQuantityOfProduct(String productName, int quantity) {

        if (isProductInStore(productName)) {

            if ((currentProductQuantity(productName) - quantity) < 0) {

                throw new InsufficientQuantityOfProductException();

            } else {

                listOfProducts.get(productName).setProductCurrentQuantity(currentProductQuantity(productName) - quantity);

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
     * Get the products registered in store sorted by their price
     *
     * @return
     */
    public List<Product> getSortedProducts() {

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
    private int currentProductQuantity(String productName) {
        return listOfProducts.get(productName).getProductCurrentQuantity();
    }
}
