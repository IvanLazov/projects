package com.clouway.designpatterns.abstractfactory;

/**
 * SamsungFactory class creates Samsung objects
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class SamsungFactory implements SmartPhoneFactory {

    /**
     * Creates a new Samsung object
     *
     * @return Samsung object which implements SmartPhone interface
     */
    public SmartPhone createSmartPhone() {

        return new Samsung();
    }
}
