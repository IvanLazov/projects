package com.clouway.designpatterns.proxy;

/**
 * ImageClient class is used to create proxy object.
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ImageClient implements Image {

    private Image image;

    public ImageClient(Image image) {
        this.image = image;
    }

    public void createImage() {
        image.createImage();
    }
}
