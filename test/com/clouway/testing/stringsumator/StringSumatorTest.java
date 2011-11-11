package com.clouway.testing.stringsumator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringSumatorTest {

    private StringSumator sumator;

    @Before
    public void setUp() {
        sumator = new StringSumator();
    }

    @Test
    public void happyPath() {
        assertEquals("15.0", sumator.sumStrings("5", "10"));
    }

    @Test(expected = NumberFormatException.class)
    public void alphabetValuesCannotBeProvided() {
        sumator.sumStrings("10", "A");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullValuesCannotBeProvided() {
        sumator.sumStrings("20", null);
    }
}
