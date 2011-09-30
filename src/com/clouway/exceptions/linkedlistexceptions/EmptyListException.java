package com.clouway.exceptions.linkedlistexceptions;

public class EmptyListException extends Exception {

    public String getMessage() {
        return "You can't remove element from empty list";
    }
}
