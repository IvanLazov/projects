package com.clouway.designpatterns.abstractfactory;

/**
 * IPhone class implements SmartPhone interface
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class IPhone implements SmartPhone {

    /**
     * Shows IPhone's OS version
     */
    public void showOSVersion() {

        System.out.println("iOS 5.0");
    }
}
