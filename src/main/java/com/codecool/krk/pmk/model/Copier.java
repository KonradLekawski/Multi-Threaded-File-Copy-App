package com.codecool.krk.pmk.model;

import com.codecool.krk.pmk.view.CopierView;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copier implements Runnable {
    private InputStream inputStream;
    private OutputStream outputStream;
    private Integer size;
    private int portionAmount;
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
            sumPortion += portionSize;
            this.buildStatusBar(this.countPercent());z
        }

    }

    private void copyRest() throws  IOException {
        byte[] rest = new byte[size % portionSize];

        if(rest.length > 0) {
            inputStream.read(rest);
            outputStream.write(rest);
            sumPortion += size % portionSize;
            this.buildStatusBar(this.countPercent());
        }
    }

    private void buildStatusBar(double progressPercentage) {
        CopierView copierView = new CopierView();
        try {
            copierView.updateProgress(progressPercentage);
            Thread.sleep(20);

        } catch (InterruptedException e) {}
    }

    private double countPercent() {

        double countPercent = (double) sumPortion/size;
        return Math.round(countPercent*100.0)/100.0;
    }

}
