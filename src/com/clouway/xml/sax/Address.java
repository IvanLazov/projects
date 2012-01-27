package com.clouway.xml.sax;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Address {

    private String street;
    private String streetNo;
    private String section;
    private String city;

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", streetNo='" + streetNo + '\'' +
                ", section='" + section + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
