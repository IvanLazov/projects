package com.clouway.objectsinjava.heterogeneoustree;

public class Tree {

    private TreeElement root;

    public Tree() {
        root = null;
    }

    /**
        * Insert new tree element
        *
        * @param keyValue int value of the key element
        * @param dataValue Object value of the Object element
        */
    public void insert(int keyValue, Object dataValue) {

        if (root == null) {
            root = new TreeElement(keyValue, dataValue);
        } else {
            root.insert(keyValue, dataValue);
        }
    }

    /**
        * Print the elements of the tree
        */
    public void printElement() {
        print(root);
    }

    /**
        * Print the elements of the tree
        *
        * @param root TreeElement the root of the tree
        */
    private void print(TreeElement root) {

        if(root == null) {
            return;
        }

        print(root.leftElement);
        System.out.printf("%s ", root.data);
        print(root.rightElement);
    }
}
