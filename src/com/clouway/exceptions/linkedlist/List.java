package com.clouway.exceptions.linkedlist;

/**
 * Ivan Lazov
 * darkpain1989@gmail.com
 */
public class List {

    private ListNode firstNode;
    private ListNode lastNode;
    private int listSize;

    public List(int size) {
        firstNode = lastNode = null;
        listSize = size;
    }

    /**
     * Add element at the end of the list
     * @param obj Object element added in the list
     */
    public void add(Object obj) {
        if (isEmpty()) {
            firstNode = lastNode = new ListNode(obj);
        } else {
            lastNode = lastNode.nextNode = new ListNode(obj);
        }
    }

    /**
     * Remove element from the end of the list
     */
    public void remove() {
        if (isEmpty()) {
            return;
        }

        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            ListNode current = firstNode;

            while(current.nextNode != lastNode) {
                current = current.nextNode;
            }

            lastNode = current;
            current.nextNode = null;
        }
    }

    /**
     * Print all elements of the list
     */
    public void printAllElement() {
        if (isEmpty()) {
            return;
        }

        ListNode current = firstNode;

        while(current != null) {
            System.out.printf("%s ", current.object);
            current = current.nextNode;
        }
    }

    /**
     * Return true if the list is empty
     * @return firstNode if it's null
     */
    public boolean isEmpty() {
        return firstNode == null;
    }
}
