package com.clouway.jdbc;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class City {
    
    private String name;
    private int numberOfVisitors;
    
    public City(String name, int numberOfVisitors) {

        this.name = name;
        this.numberOfVisitors = numberOfVisitors;
    }

    public String getName() {

        return name;
    }

    public int getNumberOfVisitors() {

        return numberOfVisitors;
    }
}
