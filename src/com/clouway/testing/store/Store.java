package com.clouway.testing.store;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class Store {

    private Hashtable<String, Product> listOfProducts = new Hashtable<String, Product>();

    public Store(Hashtable<String, Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    /**
     * Add product in store
     *
     * @param product the product to be added
     */
    public void add(Product product) {

        if (!isProductInStore(product.getProductName())) {
            listOfProducts.put(product.getProductName(), product);
        }
    }

    /**
     * Verify that the product is in store
     *
     * @param productName the name of the product
     * @return true if the product is in store
     */
    public boolean isProductInStore(String productName) {

        if (listOfProducts.containsKey(productName)) {
            return true;
        }

        return false;
    }

    /**
     * Increases the quantity of the product
     *
     * @param productName   the name of the product
     * @param quantityToAdd the quantity to be added
     */
    public void increaseQuantity(String productName, int quantityToAdd) {

        if (isProductInStore(productName)) {

            if (currentProductQuantity(productName) + quantityToAdd > maximumProductQuantity(productName)) {
                throw new ReachedMaximumQuantityOfProductException();
            } else {
                listOfProducts.get(productName).setProductQuantity(currentProductQuantity(productName) + quantityToAdd);
            }
        }
    }

    /**
     * Sell product from the store
     *
     * @param productName    the name of the product
     * @param quantityToSell the quantity to be sold
     */
    public void sell(String productName, int quantityToSell) {

        if (isProductInStore(productName)) {

            if ((currentProductQuantity(productName) - quantityToSell) < 0) {
                throw new InsufficientQuantityOfProductException();
            } else {
                listOfProducts.get(productName).setProductQuantity(currentProductQuantity(productName) - quantityToSell);
            }
        }
    }

    /**
     * Sorts products in store
     *
     * @param out the stream where we want the products to be displayed
     */
    public void sortProducts(PrintStream out) {

        List<Product> arrayList = new ArrayList<Product>(listOfProducts.values());
        Collections.sort(arrayList);

        for (Product product : arrayList) {
            out.println(product.getProductName() + " " + product.getProductPrice());
        }
    }

    /**
     * Returns the quantity of the product
     *
     * @param productName the name of the product
     * @return the quantity of the products
     */
    private int maximumProductQuantity(String productName) {

        return listOfProducts.get(productName).getProductMaxQuantity();
    }

    /**
     * Return the maximum quantity of the product, that can be stored
     *
     * @param productName the name of the product
     * @return the maximum quantity of the product, that can be stored
     */
    int currentProductQuantity(String productName) {

        return listOfProducts.get(productName).getProductQuantity();
    }
}
