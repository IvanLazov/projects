package com.clouway.io.dataclass;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;
    private String sex;
    private int age;
    private String sisterName;

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getSisterName() {
        return sisterName;
    }

    public void setSisterName(String sisterName) {
        this.sisterName = sisterName;
    }
}
