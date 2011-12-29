package com.clouway.designpatterns.abstractfactory;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Application {

    /**
     * Choose factory for creating SmartPhone objects
     *
     * @param factory the factory which will build the SmartPhone object
     * @return factory object that implements SmartPhoneFactory interface
     */
    public static SmartPhoneFactory chooseSmartPhoneFactory(String factory) {

        if (factory.equals("IPhone")) {
            return new IPhoneFactory();
        } else  {
            return new SamsungFactory();
        }
    }

    interface MobileAbstractFactory {
        Samsung createSamsung();

        IPhone createIPhone();
    }

    class CommonSeriesMobileFactoryMobile implements MobileAbstractFactory {

        public Samsung createSamsung() {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public IPhone createIPhone() {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    public static void main(String[] args) {

        Factory factory = new Factory(chooseSmartPhoneFactory("IPhone"));

        SmartPhone smartPhone = factory.getSmartPhone();
        smartPhone.showOSVersion();
    }
}
