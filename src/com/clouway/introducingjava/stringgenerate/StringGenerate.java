package com.clouway.introducingjava.stringgenerate;

import java.util.Random;

public class StringGenerate {

    static final String characters = "abcdefghijklmnopqrstuvwxyz";

    /**
        * Generates random string from characters
        *
        * @param lenght int set the desired lenght of the generated string
        * @return generated string
        */
    public static String generateRandomString(int lenght) {

        Random generate = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < lenght; i++) {
            int position = generate.nextInt(characters.length());
            sb.append(characters.charAt(position));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateRandomString(10));
    }
}
