package com.codecool.krk.pmk;

import com.codecool.krk.pmk.controller.CopierController;
import com.codecool.krk.pmk.model.Copier;
import com.codecool.krk.pmk.service.CopierService;
import com.codecool.krk.pmk.view.CopierView;

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
        CopierService service = new CopierService();
        CopierController controller = new CopierController(service);

        while (true) {
            try {
                controller.start(scanner);
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }
    }
}
