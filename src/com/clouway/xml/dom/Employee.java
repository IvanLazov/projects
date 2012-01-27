package com.clouway.xml.dom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Employee {
    
    private String firstName;
    private String lastName;
    private int age;
    private String position;
    private List<Employer> employers = new ArrayList<Employer>();
    private List<Address> addresses = new ArrayList<Address>();

    public Employee(String firstName, String lastName, int age, String position, List<Address> addresses, List<Employer> employers) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.position = position;
        this.addresses = addresses;
        this.employers = employers;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", employers=" + employers +
                ", addresses=" + addresses +
                '}';
    }
}
