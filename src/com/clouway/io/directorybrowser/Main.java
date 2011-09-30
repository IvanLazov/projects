package com.clouway.io.directorybrowser;

public class Main {

    public static void main(String[] args) {
        DirectoryBrowser browser = new DirectoryBrowser();
        browser.listContent("/home/");
    }
}
