package com.clouway.threads.synchronizedthreadcounter;

/**
 * ThreadCounter implements interface Runnable.
 * This interface provides method run() which will be executed by threads.
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ThreadCounter implements Runnable {

    private int number;
    private Counter counter;

    public ThreadCounter(Counter counter, int number) {
        this.counter = counter;
        this.number = number;
    }

    public void run() {

        try {
            counter.count(number);
        } catch (InterruptedException e) {

        }
    }
}
