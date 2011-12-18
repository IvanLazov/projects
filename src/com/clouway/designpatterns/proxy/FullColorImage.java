package com.clouway.designpatterns.proxy;

/**
 * FullColorImage class is used by ImageProxy class
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class FullColorImage implements Image {

    private String imageName;
    
    public FullColorImage(String imageName) {

        this.imageName = imageName;
    }

    /**
     * Displays a message that the image was created
     */
    public void createImage() {

        System.out.println(imageName + " image was created");
    }
}
