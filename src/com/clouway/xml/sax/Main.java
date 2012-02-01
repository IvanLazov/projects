package com.clouway.xml.sax;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Main {

    public static void main(String[] args) {

        EmployeeParser parser = new EmployeeParser(new ObjectMaker());
        parser.parseDocument();

        System.out.println(parser.getEmployeeList());
    }
}
