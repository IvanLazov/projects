package com.clouway.testing.service;

public interface Validator {

    void validateAge(String age) throws InvalidAgeException;
}
