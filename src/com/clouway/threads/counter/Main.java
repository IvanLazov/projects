package com.clouway.threads.counter;

import java.util.Scanner;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Main {

    public static void main(String[] args) {

        Counter counter = new Counter();
        new Thread(counter).start();

        System.out.println("Enter any symbol to stop the counter...");
        Scanner scanner = new Scanner(System.in);
        String result = scanner.next();

        if (!result.equals("")) {

            counter.stopCounting();
            System.out.println("Counter value: " + counter.getCounterValue());
        }
    }
}
