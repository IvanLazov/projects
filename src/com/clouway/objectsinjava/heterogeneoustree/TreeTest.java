package com.clouway.objectsinjava.heterogeneoustree;

public class TreeTest {

    public static void main(String[] args) {

        Tree myTree = new Tree();
        Integer a = new Integer(5);
        String test = "Hello World";
        Cat myCat = new Cat("Johny");

        myTree.insert(3, a);
        myTree.insert(2, test);
        myTree.insert(10, a);
        myTree.insert(20, myCat);
        myTree.printElement();
    }
}
