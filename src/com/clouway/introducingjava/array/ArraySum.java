package com.clouway.introducingjava.array;

public class ArraySum {

    /**
        *  Calculates the sum of all elements in array
        *
        * @param myArray int
        * @return The sum of all elements in array
        */
    public int getSum(int[] myArray) {
        int sum = 0;

        for (int i = 0; i < myArray.length / 2; i++) {
            sum += myArray[i] + myArray[myArray.length - i - 1];
        }

        return sum;
    }
}
