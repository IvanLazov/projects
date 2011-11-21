package com.clouway.threads.threadcounter;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        ThreadCounter threadCounterOne = new ThreadCounter(5);
        ThreadCounter threadCounterTwo = new ThreadCounter(20);

        Thread threadOne = new Thread(threadCounterOne);
        Thread threadTwo = new Thread(threadCounterTwo);

        threadCounterOne.setOtherThread(threadTwo);
        threadCounterTwo.setOtherThread(threadOne);

        threadOne.start();
        threadTwo.start();
    }
}
