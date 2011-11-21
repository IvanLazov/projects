package com.clouway.threads.synchronizedlist;

/**
 * SynchronizedList have methods for adding and removing an element from the list.
 * These methods are synchronized and can be used with threads.
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class SynchronizedList {

    private ListElement firstElement;
    private ListElement lastElement;
    private int numberOfElements = 0;
    private int listSize;

    public SynchronizedList(int size) {
        firstElement = lastElement = null;
        listSize = size;
    }

    /**
     * Add element in the list. If there is no place,
     * the thread invoking this method must wait until there is at least one empty place.
     *
     * @param object element to add
     * @throws InterruptedException If the thread waiting is interrupted
     */
    public synchronized void add(Object object) throws InterruptedException {
        if (numberOfElements >= listSize) {
            System.out.println(Thread.currentThread().getName() + " waits... Buffer is full.\n");
            wait();
        }

        if (firstElement == null) {
            firstElement = lastElement = new ListElement(object);
            numberOfElements += 1;
        } else {
            lastElement = lastElement.nextElement = new ListElement(object);
            numberOfElements += 1;
        }

        System.out.println(Thread.currentThread().getName() + " wrote to the buffer.\n");
        notifyAll();
    }

    /**
     * Removes the last element of the list. If the list is empty,
     * the thread invoking this method must wait until there is at least one added element
     *
     * @throws InterruptedException If the thread waiting is interrupted
     */
    public synchronized void remove() throws InterruptedException {
        if (numberOfElements <= 0) {
            System.out.println(Thread.currentThread().getName() + " waits... Buffer is empty.\n");
            wait();
        }

        if (firstElement == lastElement) {
            firstElement = lastElement = null;
            numberOfElements = 0;
        } else {
            ListElement current = firstElement;

            while (current.nextElement != lastElement) {
                current = current.nextElement;
            }

            lastElement = current;
            current.nextElement = null;

            numberOfElements -= 1;
        }

        System.out.println(Thread.currentThread().getName() + " removed from the buffer.\n");
        notifyAll();
    }
}
