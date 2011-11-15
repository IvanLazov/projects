package com.clouway.testing.service;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface Database {

    void saveData(String userName, String age);

    String getData(String userName);
}
