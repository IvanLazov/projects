package com.clouway.designpatterns.singleton;

/**
 * The class presents a simple implementation of the Singleton Design Pattern
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Singleton {

    private static Singleton singleton;

    static {
        singleton = new Singleton();
    }

    private Singleton() {

        System.out.println("Singleton created");
    }

    /**
     * Return an instance of Singleton
     *
     * @return Singleton instance
     */
    public static Singleton getInstance() {
        return singleton;
    }
}
