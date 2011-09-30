package com.clouway.objectsinjava.tree;

public class Tree {

    private TreeElement root;

    public Tree() {
        root = null;
    }

    /**
        * Insert new tree element
        *
        * @param insertValue int value of the created tree element
        */
    public void insertElement(int insertValue) {

        if (root == null) {
            root = new TreeElement(insertValue);
        } else {
            root.insert(insertValue);
        }
    }

    /**
        * Search for a tree element
        *
        * @param insertValue int value of the tree element we search
        * @return true if tree element is found, false otherwise
        */
    public boolean searchElement(int insertValue) {

        if (root == null) {
            return false;
        } else {
            return root.search(insertValue);
        }
    }

    /**
        * Print the elements of the tree
        */
    public void printElement() {
        print(root);
    }

    /**
        * Print the element of the tree
        *
        * @param root TreeElement the root of the Tree
        */
    private void print(TreeElement root) {

        if (root == null) {
            return;
        }

        print(root.leftElement);
        System.out.printf("%d ", root.data);
        print(root.rightElement);
    }
}
