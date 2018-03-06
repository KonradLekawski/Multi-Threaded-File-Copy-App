package com.codecool.krk.pmk.controller;


import com.codecool.krk.pmk.exception.ExitApp;
import com.codecool.krk.pmk.exception.NotTerminatedException;
import com.codecool.krk.pmk.service.CopierService;
import com.codecool.krk.pmk.view.CopierView;
import java.io.FileNotFoundException;

public class CopierController {
    private CopierService service;
    private CopierView view;

    public CopierController(CopierService service, CopierView view) {
        this.service = service;
        this.view = view;
    }

    public void start() throws FileNotFoundException, ExitApp, NotTerminatedException {

        switch (view.getMenuChoose()){
            case START:
                service.start();
                break;

            case STOP:
                service.end();
                break;
        }
    }
}

