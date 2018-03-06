package com.codecool.krk.pmk;

import com.codecool.krk.pmk.controller.CopierController;
import com.codecool.krk.pmk.exception.ExitApp;
import com.codecool.krk.pmk.exception.NotTerminatedException;
import com.codecool.krk.pmk.model.Copier;
import com.codecool.krk.pmk.service.CopierService;
import com.codecool.krk.pmk.view.CopierView;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.*;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4,
                50, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
        Scanner scanner = new Scanner(System.in);
        CopierView view = new CopierView(scanner);
        CopierService service = new CopierService(view,executor);
        CopierController controller = new CopierController(service, view);

        while (true) {
            try {
                controller.start();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (NotTerminatedException e) {
                System.out.println("wait until all operations done");
            } catch (ExitApp e) {
                break;
            }
        }
    }
}
