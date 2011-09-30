package com.clouway.objectsinjava.tree;

import java.util.Random;

public class TreeTest {

    public static void main(String[] args) {

        Tree myTree = new Tree();
        Random randomNumber = new Random();
        int value;

        for (int i = 0; i < 10; i++) {
            value = randomNumber.nextInt(20);
            System.out.print(value + " ");
            myTree.insertElement(value);
        }

        System.out.println();
        myTree.printElement();
        System.out.println("\nItem found: " + myTree.searchElement(15));
    }
}
