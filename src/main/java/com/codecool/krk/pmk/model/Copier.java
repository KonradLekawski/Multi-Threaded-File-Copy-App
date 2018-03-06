package com.codecool.krk.pmk.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copier implements Runnable {
    private InputStream inputStream;
    private OutputStream outputStream;
    private Integer size;
    private int portionSize;
    private int sumPortion;


    public Copier(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.portionSize = 512;
        this.sumPortion = 0;
    }

    public void run() {

        try {
            size = inputStream.available();
            copyPortion();
            copyRest();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void copyPortion() throws IOException, InterruptedException {

        int portionAmount = size / portionSize;
        byte[] portion = new byte[portionSize];

        for (int i = 0; i < portionAmount; i ++) {
            inputStream.read(portion);
            outputStream.write(portion);
            sumPortion += portionSize;
//            this.buildStatusBar(this.countPercent());
        }

    }

    private void copyRest() throws  IOException, InterruptedException {
        byte[] rest = new byte[size % portionSize];

        if(rest.length > 0) {
            inputStream.read(rest);
            outputStream.write(rest);
            sumPortion += size % portionSize;
//            this.buildStatusBar(this.countPercent());
        }
    }

//    private void buildStatusBar(double progressPercentage) throws InterruptedException {
//
//        copierView.updateProgress(progressPercentage);
//        Thread.sleep(20);
//
//    }

    private double countPercent() {
        double countPercent = (double) sumPortion/size;
        return Math.round(countPercent*100.0)/100.0;
    }

}
