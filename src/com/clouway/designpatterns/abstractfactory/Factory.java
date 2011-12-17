package com.clouway.designpatterns.abstractfactory;

/**
 * Factory class uses SmartPhoneFactory interface to create SmartPhone objects
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Factory {

    SmartPhone smartPhone;

    /**
     * Constructor saves the created smartPhone object from the smartPhoneFactory
     *
     * @param smartPhoneFactory  used to create the SmartPhone object
     */
    public Factory(SmartPhoneFactory smartPhoneFactory) {

        smartPhone = smartPhoneFactory.createSmartPhone();
    }

    /**
     * Returns the created SmartPhone object
     *
     * @return object of type smartPhone
     */
    public SmartPhone getSmartPhone() {

        return smartPhone;
    }
}
