package com.codecool.krk.pmk.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copier implements Runnable {
    private InputStream inputStream;
    private OutputStream outputStream;
    private Integer size;
    private int portionAmount;
    private int portionSize;

    public Copier(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.portionSize = 512;
    }

    public void run() {

        try {
            size = inputStream.available();
            System.out.println(size);
            copyPortion();
            copyRest();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void copyPortion() throws IOException {

        portionAmount = size / portionSize;
        System.out.println(portionAmount);

        byte[] portion = new byte[portionSize];

        for (int i = 0; i < portionAmount; i ++) {
            inputStream.read(portion);
            outputStream.write(portion);
        }

    }

    private void copyRest() throws  IOException {
        byte[] rest = new byte[size % portionAmount];

        if(rest.length > 0) {
            inputStream.read(rest);
            outputStream.write(rest);
        }
    }

}
