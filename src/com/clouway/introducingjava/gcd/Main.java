package com.clouway.introducingjava.gcd;

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
