package com.clouway.exceptions.linkedlistexceptions;

public class FullListException extends Exception {

    public String getMessage() {
        return "You can't add new element in full list";
    }
}
