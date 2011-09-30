package com.clouway.io.transferobject;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        TransferObject application = new TransferObject();

        InputStream input = new FileInputStream("transferIn.txt");
        OutputStream output = new FileOutputStream("transferOut.txt");

        int numberOfBytesTransfered = application.transfer(input, output, 2, 7);
        System.out.println("Number of bytes transfered: " + numberOfBytesTransfered);
    }
}
