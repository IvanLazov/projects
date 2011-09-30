package com.clouway.introducingjava.array;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/7/11
 * Time: 3:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArrayMinimalElement {
    /**
        *  Search the minimal element in array
        * @param myArray
        * @return The minimum element in com.clouway.array
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
