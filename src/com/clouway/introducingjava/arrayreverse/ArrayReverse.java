package com.clouway.introducingjava.arrayreverse;

import java.util.Arrays;

public class ArrayReverse {

    /**
        * Reverse element order in array
        *
        * @param myArray int
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
