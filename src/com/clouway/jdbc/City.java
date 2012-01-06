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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (numberOfVisitors != city.numberOfVisitors) return false;
        if (name != null ? !name.equals(city.name) : city.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + numberOfVisitors;
        return result;
    }
}
