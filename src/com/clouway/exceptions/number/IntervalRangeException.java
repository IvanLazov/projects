package com.clouway.exceptions.number;

public class IntervalRangeException extends Exception {

    public String getMessage() {
        return "Number is out of interval range";
    }
}
