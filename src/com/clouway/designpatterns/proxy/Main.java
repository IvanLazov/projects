package com.clouway.designpatterns.proxy;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Main {
    
    public static void main(String[] args) {

        ImageClient imageOne = new ImageClient(new Image() {
            public void createImage() {
                System.out.println("tetestsetset");
            }
        });

        imageOne.createImage();

        imageOne = new ImageClient(new FullColorImage());
        imageOne.createImage();
    }
}
