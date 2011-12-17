package com.clouway.designpatterns.abstractfactory;

/**
 * IPhoneFactory class creates IPhone objects
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class IPhoneFactory implements SmartPhoneFactory {

    /**
     * Creates a new IPhone object
     *
     * @return IPhone object which implements SmartPhone interface
     */
    public SmartPhone createSmartPhone() {

        return new IPhone();
    }
}
