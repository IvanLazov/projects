package com.clouway.xml.dom;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Address {
    
    private String street;
    private String streetNo;
    private String section;
    private String city;

    public Address(String street, String streetNo, String section, String city) {

        this.street = street;
        this.streetNo = streetNo;
        this.section = section;
        this.city = city;
    }

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
