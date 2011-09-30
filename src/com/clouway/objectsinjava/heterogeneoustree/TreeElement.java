package com.clouway.objectsinjava.heterogeneoustree;

public class TreeElement {

    TreeElement leftElement;
    TreeElement rightElement;
    int key;
    Object data;

    /**
        * Constructor creates a tree leaf element
        *
        * @param keyValue int value of the tree leaf element key
        * @param dataValue Object reference to the object value
        */
    public TreeElement(int keyValue, Object dataValue) {
        key = keyValue;
        data = dataValue;
    }

    /**
        * Locate insertion point and insert new tree element
        *
        * @param keyValue int value of the tree leaf element key
        * @param dataObjectValue Object reference to the object value
        */
    public void insert(int keyValue, Object dataObjectValue) {

        // insert to the left
        if (keyValue < key) {

            if (leftElement == null) {
                leftElement = new TreeElement(keyValue, dataObjectValue);
            } else {
                leftElement.insert(keyValue, dataObjectValue);
            }
        } else if (keyValue > key) {

            if (rightElement == null) {
                rightElement = new TreeElement(keyValue, dataObjectValue);
            } else {
                rightElement.insert(keyValue, dataObjectValue);
            }
        }
    }
}
