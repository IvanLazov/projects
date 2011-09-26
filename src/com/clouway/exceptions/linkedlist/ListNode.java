package com.clouway.exceptions.linkedlist;

/**
 * Ivan Lazov
 * darkpain1989@gmail.com
 */
public class ListNode {

    Object object;
    ListNode nextNode;

    public ListNode(Object obj) {
        this(obj, null);
    }

    public ListNode(Object obj, ListNode node) {
        object = obj;
        nextNode = node;
    }
}
