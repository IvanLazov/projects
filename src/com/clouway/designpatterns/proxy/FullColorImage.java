package com.clouway.designpatterns.proxy;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class FullColorImage implements Image {

    private String imageName;
    
    public FullColorImage(String imageName) {

        this.imageName = imageName;
    }
    
    public void createImage() {

        System.out.println(imageName + " image was created");
    }
}
