package com.clouway.jdbc.person;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Person {
    
    private String name;
    private String idNumber;
    private int age;
    private String email;

    public Person(String name, String idNumber, int age, String email) {

        this.name = name;
        this.idNumber = idNumber;
        this.age = age;
        this.email = email;
    }

    public String getName() {

        return name;
    }

    public String getIdNumber() {

        return idNumber;
    }

    public int getAge() {

        return age;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
