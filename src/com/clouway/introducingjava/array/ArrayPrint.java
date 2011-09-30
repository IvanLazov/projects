package com.clouway.introducingjava.array;

public class ArrayPrint {

    /**
        *  Display all elements in array
        *
        * @param myArray int
        */
    public void printArray(int[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
    }
}
