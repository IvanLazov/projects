package com.clouway.introducingjava.array;

public class ArrayMinimalElement {

    /**
        *  Search the minimal element in array
        *
        * @param myArray int
        * @return The minimum element in array
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
}
