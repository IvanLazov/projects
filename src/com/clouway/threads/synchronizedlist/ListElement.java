package com.clouway.threads.synchronizedlist;

/**
 * ListElement class represents one element in the list
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ListElement {

    Object object;
    ListElement nextElement;

    public ListElement(Object obj) {
        this(obj, null);
    }

    public ListElement(Object obj, ListElement element) {
        object = obj;
        nextElement = element;
    }
}
