package com.clouway.designpatterns.abstractfactory;

/**
 * SmartPhoneFactory class is an abstract factory for creating
 * different objects that implements SmartPhone's interface
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface SmartPhoneFactory {
    
    SmartPhone createSmartPhone();
}
