package com.clouway.designpatterns.abstractfactory;

/**
 * Samsung class implements SmartPhone interface
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Samsung implements SmartPhone {

    /**
     * Shows Samsung's OS version
     */
    public void showOSVersion() {

        System.out.println("Android 4.0");
    }
}
