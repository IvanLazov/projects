package com.clouway.testing.service;

public interface Database {

    void saveData(String userName, String age);

    String getData(String userName);
}
