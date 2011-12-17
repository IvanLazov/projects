package com.clouway.designpatterns.proxy;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Main {
    
    public static void main(String[] args) {

        ImageProxy imageOne = new ImageProxy("Summer");
        ImageProxy imageTwo = new ImageProxy("Winter");
        imageOne.createImage();
        imageTwo.createImage();
    }
}
