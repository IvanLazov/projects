package com.clouway.io.transferobject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Ivan Lazov
 * darkpain1989@gmail.com
 */
public class TransferObject {

    /**
     * Transfer content from instance of InputStream to instance of OutputStream
     *
     * @param input InputStream content to transfer from
     * @param output OutputStream where the transferred content is written
     * @param numberOfBytes int bytes to be transferred
     * @param offset int determines how many bytes to be skipped from the beginning of the InputStream
     * @return int the number of transferred bytes
     */
    public int transfer(InputStream input, OutputStream output, int numberOfBytes, int offset) {
        int numberRead;
        int transferedBytes = 0;
        byte[] bytes = new byte[4096];

        if (numberOfBytes == -1) {
            try {
                while ((numberRead = input.read()) != -1) {
                    output.write(numberRead);
                    transferedBytes++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                numberRead = input.read(bytes);

                for (int i = 0; i < numberOfBytes; i++) {
                    output.write(bytes[offset + i]);
                    transferedBytes++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return transferedBytes;
    }
}

