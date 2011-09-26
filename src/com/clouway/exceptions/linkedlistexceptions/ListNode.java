package com.clouway.exceptions.linkedlistexceptions;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan Lazov
 * Email: darkpain1989@gmail.com
 */
public class ListNode {

    Object object;
    ListNode nextNode;

    /**
     * Constructor creates ListNode object
     *
     * @param obj Object   element to create
     */
    public ListNode(Object obj) {
        this(obj, null);
    }

    /**
     * Constructor creates ListNode object
     *
     * @param obj Object   element to create
     * @param node ListNode   reference to next node in the List
     */
    public ListNode(Object obj, ListNode node) {
        object = obj;
        nextNode = node;
    }
}
