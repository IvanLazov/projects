package com.clouway.threads.synchronizedlist;

/**
 *  RemovingThread uses SynchronizedList method remove(), to remove the last element from the list
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class RemovingThread implements Runnable {

    private final SynchronizedList synchronizedList;

    public RemovingThread(SynchronizedList synchronizedList) {
        this.synchronizedList = synchronizedList;
    }

    public void run() {

        try {
            Thread.sleep(1000);
            synchronizedList.remove();
        } catch (InterruptedException exception) {

        }
    }
}
