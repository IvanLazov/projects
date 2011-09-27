package com.clouway.io.directorybrowser;

/**
 * Ivan Lazov
 * darkpain1989@gmail.com
 */
public class Main {

    public static void main(String[] args) {
        DirectoryBrowser browser = new DirectoryBrowser();
        browser.listContent("/home/");
    }
}
