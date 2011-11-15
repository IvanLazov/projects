package com.clouway.testing.service;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface Validator {

    void validateAge(String age) throws InvalidAgeException;
}
