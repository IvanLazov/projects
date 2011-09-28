package com.clouway.io.directorybrowser;

import java.io.File;

/**
 * Ivan Lazov
 * darkpain1989@gmail.com
 */
public class DirectoryBrowser {

    /**
     * Lists the content of a directory.
     *
     * @param path String path to the directory
     */
    public void listContent(String path) {

        File file = new File(path);

        if (file.exists()) {
            System.out.println(file.isDirectory() ? "Directory...\n" : "The entered path references to a file.");

            if (file.isDirectory()) {
                String[] content = file.list();

                for (String contentElement : content) {
                    System.out.println(contentElement);
                }
            }
        } else {
            System.out.println("The path don't exists!");
        }
    }
}
