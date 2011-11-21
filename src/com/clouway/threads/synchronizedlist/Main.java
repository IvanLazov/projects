package com.clouway.threads.synchronizedlist;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        final SynchronizedList synchronizedList = new SynchronizedList(1);

        AddingThread addingThread = new AddingThread(synchronizedList);
        RemovingThread removingThread = new RemovingThread(synchronizedList);

        Thread thread1 = new Thread(addingThread);
        thread1.setName("ADD 1: ");

        Thread thread2 = new Thread(addingThread);
        thread2.setName("ADD 2: ");

        Thread thread3 = new Thread(addingThread);
        thread3.setName("ADD 3: ");

        Thread thread4 = new Thread(removingThread);
        thread4.setName("REMOVE 1");


        Thread thread5 = new Thread(removingThread);
        thread5.setName("REMOVE 2");

        thread1.start();
        thread5.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
