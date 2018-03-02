package com.codecool.krk.pmk;

import com.codecool.krk.pmk.model.Copier;
import com.sun.org.apache.xpath.internal.SourceTree;
import sun.text.CodePointIterator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("from : ");
        String from = scanner.nextLine();
        System.out.println("to : ");
        String to = scanner.nextLine();

        try {
            FileInputStream inputStream = new FileInputStream(new File(from));
            FileOutputStream outputStream = new FileOutputStream(new File(to));
            (new Thread(new Copier(inputStream, outputStream))).start();

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
        }

    }
}
