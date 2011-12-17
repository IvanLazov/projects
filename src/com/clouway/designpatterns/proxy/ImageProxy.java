package com.clouway.designpatterns.proxy;

/**
 * ImageProxy class is a proxy object.
 * We use it to call FullColorImage's method createImage().
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ImageProxy implements Image {

    private Image image; // reference to the real image
    private String imageName;

    public ImageProxy(String imageName) {

        this.imageName = imageName;
    }
    
    /**
     * Create image using reference to the real image
     */
    public void createImage() {

        System.out.println("Let's create image - " + imageName);

        image = new FullColorImage(imageName);
        image.createImage();
    }
}
