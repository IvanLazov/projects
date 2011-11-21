package com.clouway.threads.synchronizedlist;

/**
 * AddingThread uses SynchronizedList method add(), to add new element at the end of the list
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class AddingThread implements Runnable {

    private final SynchronizedList synchronizedList;

    public AddingThread(SynchronizedList list) {
        this.synchronizedList = list;
    }

    public void run() {

        int counter = 0;

        try {
            counter++;
            Thread.sleep(1000);
            synchronizedList.add(counter);
        } catch (InterruptedException e) {

        }

    }
}
