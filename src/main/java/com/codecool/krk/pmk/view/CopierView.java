package com.codecool.krk.pmk.view;

import com.codecool.krk.pmk.controller.Choose;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.Scanner;

public class CopierView {
    private Scanner scanner;

    public CopierView(Scanner scanner) {
        this.scanner = scanner;
    }

//    public void updateProgress(double progressPercentage) {
//        final int width = 50; // progress bar width in chars
//
//        System.out.print("\r[");
//        int i = 0;
//        for (; i <= (int)(progressPercentage*width); i++) {
//            System.out.print(".");
//        }
//        for (; i < width; i++) {
//            System.out.print(" ");
//        }
//        System.out.print("]");
//    }

    public FileInputStream getInputStream() throws FileNotFoundException {
        System.out.println("From : ");
        String from = scanner.nextLine();
        return new FileInputStream(new File(from));
    }

    public FileOutputStream getOutputStream() throws FileNotFoundException {
        System.out.println("to : ");
        String to = scanner.nextLine();
        return new FileOutputStream(new File(to));
    }

    public Choose getMenuChoose() {
        Choose choose = null;

        boolean properValue = false;
        while (! properValue) {
            try {
                System.out.println("1) Type \'start\' for new copy operation \n2) Type \'stop\' to end the program \n");
                choose = Choose.valueOf(scanner.nextLine().toUpperCase());
                properValue = true;
            } catch (IllegalArgumentException e) {
                System.out.println("wrong value ! \n");
            }
        }
        return choose;
    }
}
