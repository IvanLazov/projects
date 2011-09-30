package com.clouway.introducingjava.quicksort;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/7/11
 * Time: 8:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class QuickSort {

    static int[] myArray = {1, 12, 5, 26, 7, 14, 3, 7, 2};

    public QuickSort() {
        sort(myArray, 0, myArray.length - 1);
    }

    /**
        * Sort com.clouway.array
        * @param myArray
        * @param left int first index
        * @param right int last index
        */
    public void sort(int[] myArray, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;
        int p = myArray[right];

        while (i < j) {
            while (i < j && myArray[i] <= p) {
                i++;
            }

            while (i < j && myArray[j] >= p) {
                j--;
            }

            if (i < j) {
                int t = myArray[i];
                myArray[i] = myArray[j];
                myArray[j] = t;
            }
        }

        int t =  myArray[i];
        myArray[i] = myArray[right];
        myArray[right] = t;

        sort(myArray, left, i - 1);
        sort(myArray, i + 1, right);
    }

    public static void main(String[] args) {
        System.out.println("Elements before sorting: " + Arrays.toString(myArray));
        new QuickSort();
        System.out.println("Elements after sorting: " + Arrays.toString(myArray));
    }
}
