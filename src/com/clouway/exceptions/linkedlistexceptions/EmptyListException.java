package com.clouway.exceptions.linkedlistexceptions;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan Lazov
 * Email: darkpain1989@gmail.com
 */
public class EmptyListException extends Exception {

    public String getMessage() {
        return "You can't remove element from empty list";
    }
}
