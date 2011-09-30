package com.clouway.objectsinjava.sumator;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        Sumator myObject = new Sumator();

        System.out.println("Integer: " + myObject.sum(5, 10));
        System.out.println("Double: " + myObject.sum(2.1, 5.0));
        System.out.println("String: " + myObject.sum("8", "7"));
        System.out.println("BigInteger: " + myObject.sum(new BigInteger("56"), new BigInteger("12")));
        System.out.println("BigDecimal: " + myObject.sum(new BigDecimal("3.1415"), new BigDecimal("1.5")));
    }
}
