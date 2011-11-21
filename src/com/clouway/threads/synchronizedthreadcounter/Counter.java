package com.clouway.threads.synchronizedthreadcounter;

/**
 * Counter is shared resource that serves for synchronizing threads
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Counter {

    /**
     * Counts to specified value. After each count, the thread executing this method stops
     * and allows the other thread to count
     *
     * @param number count to that number
     * @throws InterruptedException If the thread is interrupted
     */
    public synchronized void count(int number) throws InterruptedException {

        int counter = 0;

        while (counter < number) {
            Thread.sleep(1000);
            counter++;
            System.out.println(Thread.currentThread().getName() + " - " + counter);
            notify();

            if (counter == number) {
                Thread.currentThread().interrupt();
            }

            wait();
        }
    }
}
