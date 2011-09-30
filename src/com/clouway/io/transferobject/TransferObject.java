package com.clouway.io.transferobject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TransferObject {

    /**
     * Transfer content from instance of InputStream to instance of OutputStream
     *
     * @param in InputStream content to transfer from
     * @param out OutputStream where the transferred content is written
     * @param numberOfBytes int bytes to be transferred
     * @param offset int determines how many bytes to be skipped from the beginning of the InputStream
     * @return int the number of transferred bytes
     */
    public int transfer(InputStream in, OutputStream out, int numberOfBytes, int offset) {
        int numberRead;
        int transferredBytes = 0;
        byte[] bytes = new byte[4096];

        if (numberOfBytes == -1) {
            try {
                while ((numberRead = in.read()) != -1) {
                    out.write(numberRead);
                    transferredBytes++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                in.skip(offset);
                transferredBytes = in.read(bytes, 0, numberOfBytes);
                out.write(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return transferredBytes;
    }
}

