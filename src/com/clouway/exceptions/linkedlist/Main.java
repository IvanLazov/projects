package com.clouway.exceptions.linkedlist;

public class Main {

    public static void main(String[] args) {
        List myList = new List(1);

        myList.add(1);
        myList.add(5.0);
        myList.add("Car");
        myList.remove();

        myList.printAllElement();
    }
}
