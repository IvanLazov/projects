package com.clouway.objectsinjava.sumator;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Sumator {

    /**
        * Calculates the sum of two numbers, type Integer
        *
        * @param a Integer first number to sum
        * @param b Integer second number to sum
        * @return sum of a and b
        */
    public Integer sum(Integer a, Integer b) {
        return a + b;
    }

    /**
        * Calculates the sum of two numbers, type Double
        *
        * @param a Double first number to sum
        * @param b Double second number to sum
        * @return sum of a and b
        */
    public Double sum(Double a, Double b) {
        return a + b;
    }

    /**
        * Calculates the sum of two numbers, type String
        *
        * @param a String first number to sum
        * @param b String second number to sum
        * @return sum of a and b
        */
    public String sum(String a, String b) {
        double sum = Double.parseDouble(a) + Double.parseDouble(b);
        return String.valueOf(sum);
    }

    /**
        * Calculates the sum of two numbers, type BigInteger
        *
        * @param a BigInteger first number to sum
        * @param b BigInteger second number to sum
        * @return sum of a and b
        */
    public BigInteger sum(BigInteger a, BigInteger b) {
        BigInteger num1 = a;
        BigInteger num2 = b;
        BigInteger num3 = num1.add(num2);
        return num3;
    }

    /**
        * Calculates the sum of two numbers, type BigDecimal
        * with scale of four digits after the decimal point and specific round
        *
        * @param a BigDecimal first number to sum
        * @param b BigDecimal second number to sum
        * @return sum of a and b
        */
    public BigDecimal sum(BigDecimal a, BigDecimal b) {
        BigDecimal num1 = a;
        BigDecimal num2 = b;
        BigDecimal num3 = num1.add(b);
        return num3.setScale(4, BigDecimal.ROUND_HALF_UP);
    }
}
