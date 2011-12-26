package com.clouway.designpatterns.singleton;

/**
 * The class presents a simple implementation of the Singleton Design Pattern
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Singleton {

    private static Singleton singleton;

    private Singleton() {

        System.out.println("Singleton created");
    }

    /**
     * Get only one instance of the class
     *
     * @return an instance of Singleton class
     */
    public static Singleton getInstance() {

        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;
    }
}
