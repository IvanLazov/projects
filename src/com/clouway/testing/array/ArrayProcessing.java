package com.clouway.testing.array;

import java.io.PrintStream;

public class ArrayProcessing {

    /**
     * Search the minimal element in an array
     *
     * @param myArray the array we search
     * @return the minimum element of the array
     */
    public int getMinElement(int[] myArray) {

        int minElement = myArray[0];

        for (int i = 0; i < myArray.length; i++) {

            if (minElement > myArray[i]) {
                minElement = myArray[i];
            }
        }

        return minElement;
    }

    /**
     * Calculates the sum of the elements in the array
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

    /**
     * Prints the array
     *
     * @param myArray the array to print
     * @param out     the stream where the elements will be printed
     */
    public void printArray(int[] myArray, PrintStream out) {

        for (int i = 0; i < myArray.length; i++) {

            out.print(myArray[i] + " ");
        }
    }
}
