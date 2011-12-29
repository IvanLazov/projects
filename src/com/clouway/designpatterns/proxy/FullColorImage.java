package com.clouway.designpatterns.proxy;

/**
 * FullColorImage class presents the real image which will be used by the proxy
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class FullColorImage implements Image {

    /**
     * Displays a message that the image is created
     */
    public void createImage() {

        System.out.println("Image was created");
    }
}
