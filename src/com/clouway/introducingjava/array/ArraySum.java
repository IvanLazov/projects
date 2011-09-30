package com.clouway.introducingjava.array;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/7/11
 * Time: 3:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArraySum {
    /**
        *  Calculates the sum of all elements in com.clouway.array
        * @param myArray
        * @return The sum of all elements in com.clouway.array
        */
    public int getSum(int[] myArray) {
        int sum = 0;

        for (int i = 0; i < myArray.length / 2; i++) {
            sum += myArray[i] + myArray[myArray.length - i - 1];
        }

        return sum;
    }
}
