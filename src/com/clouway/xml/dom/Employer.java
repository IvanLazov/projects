package com.clouway.xml.dom;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Employer {

    private String name;
    private String startDate;
    private String endDate;

    public Employer(String name, String startDate, String endDate) {

        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "name='" + name + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
