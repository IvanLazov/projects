package com.clouway.designpatterns.singleton;

/**
 * Singleton class can be created only once
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Singleton {

    private static boolean instanceFlag = false; // monitors creation of instance

    private Singleton() {
        
        System.out.println("Singleton created");
    }

    /**
     * Creates an instance of Singleton class
     *
     * @return an instance of Singleton
     */
    public static Singleton createInstance() {
        
        if (!instanceFlag) {

            instanceFlag = true;
            return new Singleton();
        } else {

            return null;
        }
    }
}
