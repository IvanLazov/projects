package com.clouway;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class Main {
    
    static Logger logger = Logger.getLogger(Main.class);
    
    public static void main(String[] args) {

        BasicConfigurator.configure();
        logger.info("Logger");

        MyClass myClass = new MyClass();
        System.out.println(myClass.multiply(3, 5));
    }
}
