package com.clouway.xml.sax;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Main {

    public static void main(String[] args) {

        EmployeeSAXParser parser = new EmployeeSAXParser(new ObjectMaker());
        parser.parse();

        System.out.println(parser.getEmployeeList());
    }
}
