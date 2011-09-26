package com.clouway.exceptions.linkedlistexceptions;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan Lazov
 * Email: darkpain1989@gmail.com
 */
public class List {

    private ListNode firstNode;
    private ListNode lastNode;
    private int numberOfElements = 0;
    private int listSize = 0;

    /**
     * Constructor creates empty List with fixed length
     *
     * @param size int   the size of the List
     */
    public List(int size) {
        firstNode = lastNode = null;
        listSize = size;
        numberOfElements = 1;
    }

    /**
     * Add a new element in the List
     *
     * @param obj Object   added element
     * @throws FullListException when the List is full
     */
    public void add(Object obj) throws FullListException {
        outOfRange();

        if (isEmpty()) {
            firstNode = lastNode = new ListNode(obj);
            numberOfElements++;
        } else {
            lastNode = lastNode.nextNode = new ListNode(obj);
            numberOfElements++;
        }
    }

    /**
     * Removes an element from the List
     *
     * @throws EmptyListException when the List is empty
     */
    public void remove() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException();
        }

        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            ListNode current = firstNode;

            while (current.nextNode != lastNode) {
                current = current.nextNode;
            }

            lastNode = current;
            current.nextNode = null;
        }
    }

    /**
     * Check whether the element is out of List range
     *
     * @throws FullListException when the added element is out of List range
     */
    public void outOfRange() throws FullListException {
        if (numberOfElements > listSize) {
            throw new FullListException();
        }
    }

    /**
     * Checks whether the List is empty
     *
     * @return firstNode if it references to null (empty List)
     */
    public boolean isEmpty() {
        return firstNode == null;
    }

    /**
     * Prints all elements of the List
     */
    public void printAllElement() {
        if (isEmpty()) {
            System.out.println("Nothing to print");
            return;
        }

        ListNode current = firstNode;

        while (current != null) {
            System.out.printf("%s ", current.object);
            current = current.nextNode;
        }
    }
}