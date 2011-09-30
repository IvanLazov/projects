package com.clouway.introducingjava.gcd;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/7/11
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        GCD object1 = new GCD();
        LCM object2 = new LCM();

        int gcdResult = object1.greatestCommonDivisor(14, 21);
        int lcmResult = object2.leastCommonMultiple(14, 21, gcdResult);
        System.out.println("GCD is: " + gcdResult);
        System.out.println("LCM is: " + lcmResult);
    }
}
