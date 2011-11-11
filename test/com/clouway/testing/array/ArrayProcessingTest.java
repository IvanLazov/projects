package com.clouway.testing.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ArrayProcessingTest {

    private ArrayProcessing arrayProcessing;
    private int[] myArray = {5, 7, 3, 9, 12};
    private int[] myArrayTwo = {-1, -2, -3, -5};

    @Before
    public void setUp() {
        arrayProcessing = new ArrayProcessing();
    }

    @Test
    public void getMinimalElementOfArray() {
        assertEquals(3, arrayProcessing.getMinElement(myArray));
    }

    @Test
    public void getSumOfPositiveNumbers() {
        assertEquals(33, arrayProcessing.getSum(myArray));
    }

    @Test
    public void getSumOfNegativeNumbers() {
        assertEquals(-11, arrayProcessing.getSum(myArrayTwo));
    }

    @Test
    public void printElementsOfArray() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        arrayProcessing.printArray(new int[]{5, 6, 20}, new PrintStream(out));
        assertEquals("5 6 20 ", new String(out.toByteArray()));
    }
}
