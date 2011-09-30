package com.clouway.objectsinjava.tree;

public class TreeElement {

    TreeElement leftElement;
    TreeElement rightElement;
    int data;

    /**
        * Constructor creates a tree leaf element
        *
        * @param insertValue int value of the created tree leaf element
        */
    public TreeElement(int insertValue) {
        data = insertValue;
        leftElement = rightElement = null;
    }

    /**
        * Locate insertion point and insert new tree element
        *
        * @param insertValue int value of the new inserted tree element
        */
    public void insert(int insertValue) {

        if (insertValue < data) {

            if (leftElement == null) {
                leftElement = new TreeElement(insertValue);
            } else {
                leftElement.insert(insertValue);
            }
        } else if (insertValue > data) {

            if (rightElement == null) {
                rightElement = new TreeElement(insertValue);
            } else {
                rightElement.insert(insertValue);
            }
        }
    }

    /**
        * Search for a tree element
        *
        * @param insertValue int value of the tree element we search
        * @return true if tree element is found, false otherwise
        */
    public boolean search(int insertValue) {

        if (insertValue == data) {
            return true;
        } else if (insertValue < data) {

            if (leftElement == null) {
                return false;
            } else {
                leftElement.search(insertValue);
            }

        } else if (insertValue > data) {

            if (rightElement == null) {
                return false;
            } else {
                rightElement.search(insertValue);
            }

        }

        return false;
    }
}