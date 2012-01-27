package com.clouway.xml.sax;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Employer {

    private String name;
    private String startDate;
    private String endDate;

    @Override
    public String toString() {
        return "Employer{" +
                "name='" + name + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
