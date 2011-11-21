package com.clouway.threads.counter;

/**
 * Counter class increments counter until we stop the counting process
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Counter implements Runnable {

    private int counter;
    private boolean stop = false;

    public void run() {

        while (!stop) {

            try {
                counter++;
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    /**
     * Stop counting
     */
    public void stopCounting() {
        stop = true;
    }

    /**
     * Get counter value
     *
     * @return value of counter
     */
    public int getCounterValue() {
        return counter;
    }
}
