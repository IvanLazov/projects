package com.clouway.designpatterns.singleton;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Main {
    
    public static void main(String[] args) {

        Singleton singleton = Singleton.createInstance();
        
        // Try to create another instance of Singleton class
        Singleton anotherSingleton = Singleton.createInstance();

        if (anotherSingleton == null) {
            System.out.println("Singleton is not created");
        }
    }
}
