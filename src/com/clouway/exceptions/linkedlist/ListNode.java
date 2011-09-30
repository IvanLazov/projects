package com.clouway.exceptions.linkedlist;

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
