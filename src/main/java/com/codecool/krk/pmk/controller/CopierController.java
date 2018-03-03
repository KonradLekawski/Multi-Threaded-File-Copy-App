package com.codecool.krk.pmk.controller;


import com.codecool.krk.pmk.service.CopierService;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CopierController {
    private CopierService service;


    public CopierController(CopierService service) {
        this.service = service;
    }


    public void start(Scanner scanner) throws FileNotFoundException {
        service.start(scanner);
    }
}

