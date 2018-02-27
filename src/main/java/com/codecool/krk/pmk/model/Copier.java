package com.codecool.krk.pmk.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copier implements Runnable {
    private InputStream inputStream;
    private OutputStream outputStream;

    public Copier(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }


    public void run() {

        try {

            int c;

            while(((c = inputStream.read())) != -1 && !Thread.currentThread().isInterrupted()) {
                outputStream.write(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

}
