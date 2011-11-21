package com.clouway.threads.threadcounter;

import java.util.Random;

/**
 * This class is used to create counting threads.
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ThreadCounter implements Runnable {

    private int number; // count to that number value
    private Thread otherThread; // reference to the other counting thread

    /**
     * Initialize the number to which the thread will count
     *
     * @param number the thread will count to that number
     */
    public ThreadCounter(int number) {
        this.number = number;
    }

    public void run() {

        int counter = 0;
        while (counter < number) {

            try {
                Thread.sleep(new Random().nextInt(2000));
                counter++;
                System.out.println(Thread.currentThread().getName() + ": " + counter);
            } catch (InterruptedException e) {
                return;
            }

            if (counter == number) {
                Thread.currentThread().interrupt();
                otherThread.interrupt();
            }
        }
    }

    /**
     * Set reference to the other thread
     *
     * @param thread used to set reference to the other thread
     */
    public void setOtherThread(Thread thread) {
        otherThread = thread;
    }
}
