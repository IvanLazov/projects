package com.clouway.threads.synchronizedthreadcounter;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        final Counter counter = new Counter();

        ThreadCounter threadCounterOne = new ThreadCounter(counter, 5);
        ThreadCounter threadCounterTwo = new ThreadCounter(counter, 5);

        new Thread(threadCounterOne).start();
        new Thread(threadCounterTwo).start();
    }
}
