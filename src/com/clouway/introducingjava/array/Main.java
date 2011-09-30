package com.clouway.array;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/7/11
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        int[] myArray = {5, 7, 3, 9, 12};

        ArrayMinimalElement object1 = new ArrayMinimalElement();
        ArraySum object2 = new ArraySum();
        ArrayPrint object3 = new ArrayPrint();

        System.out.println("Minimal Element is: " + object1.getMinElement(myArray));
        System.out.println("Sum of Elements is: " + object2.getSum(myArray));
        object3.printArray(myArray);
    }
}
