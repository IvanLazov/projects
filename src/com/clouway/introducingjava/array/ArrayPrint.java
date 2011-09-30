package com.clouway.array;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/7/11
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArrayPrint {
    /**
        *  Display all elements in com.clouway.array
        * @param myArray
        */
    public void printArray(int[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
    }
}
