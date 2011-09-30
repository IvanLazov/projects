package com.clouway.exceptions.linkedlistexceptions;

public class Main {

    public static void main(String[] args) throws FullListException, EmptyListException {

        List myList = new List(3);

        myList.add("Sofia");
        myList.add("Paris");
        myList.remove();

        myList.printAllElement();
    }
}
