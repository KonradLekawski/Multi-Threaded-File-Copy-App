package com.codecool.krk.pmk.service;

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.codecool.krk.pmk.model.Copier;
import com.codecool.krk.pmk.view.CopierView;

public class CopierService {

    public void start(Scanner scanner) throws FileNotFoundException {

        System.out.println("from : ");
        String from = scanner.nextLine();
        System.out.println("to : ");
        String to = scanner.nextLine();

        CopierView copierView = new CopierView();
        FileInputStream inputStream = new FileInputStream(new File(from));
        FileOutputStream outputStream = new FileOutputStream(new File(to));
        (new Thread(new Copier(inputStream, outputStream, copierView))).start();
    }
}
