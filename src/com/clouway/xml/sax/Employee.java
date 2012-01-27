package com.clouway.xml.sax;

import java.util.List;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Employee {

    private String firstName;
    private String lastName;
    private String age;
    private String position;
    private List<Employer> employerList;
    private List<Address> addressList;
    
    public void setEmployerList(List<Employer> employerList) {
        
        this.employerList = employerList;
    }
    
    public void setAddressList(List<Address> addressList) {

        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                ", position='" + position + '\'' +
                ", employerList=" + employerList +
                ", addressList=" + addressList +
                '}';
    }
}
