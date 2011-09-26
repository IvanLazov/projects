package com.clouway.exceptions.linkedlistexceptions;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan Lazov
 * Email: darkpain1989@gmail.com
 */
public class FullListException extends Exception {

    public String getMessage() {
        return "You can't add new element in full list";
    }
}
