package com.clouway.io.dataclass;

import java.io.*;

/**
 * Ivan Lazov
 * darkpain1989@gmail.com
 */
public class DataClass {

    private ObjectOutputStream output;
    private ObjectInputStream input;

    /**
     * Saves Object o in the OutputStream out
     *
     * @param out OutputStream where to save the object
     * @param o Object the object to save
     */
    public void saveObject(OutputStream out, Object o) {
        try {
            output = new ObjectOutputStream(out);
            output.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Reads from InputStream in, the instance of the desired class
     *
     * @param in InputStream the stream for reading
     * @return Object written in the InputStream
     */
    public Object getObject(InputStream in) {
        Object object = null;

        try {
            input = new ObjectInputStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            object = input.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return object;
    }
}
