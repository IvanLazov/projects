package com.clouway.introducingjava.arrayreverse;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/7/11
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArrayReverse {
    /**
        * Reverse element order in com.clouway.array
        *
        * @param myArray
        */
    public static void reverseArray(int[] myArray) {
        for (int i = 0; i < myArray.length / 2; i++) {
            int temp = myArray[i];
            myArray[i] = myArray[myArray.length - i - 1];
            myArray[myArray.length - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5};
        reverseArray(myArray);
        System.out.println(Arrays.toString(myArray));
    }
}
