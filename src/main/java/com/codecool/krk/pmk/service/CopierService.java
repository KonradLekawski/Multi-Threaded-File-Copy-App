package com.codecool.krk.pmk.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.ThreadPoolExecutor;

import com.codecool.krk.pmk.exception.ExitApp;
import com.codecool.krk.pmk.exception.NotTerminatedException;
import com.codecool.krk.pmk.model.Copier;
import com.codecool.krk.pmk.view.CopierView;

public class CopierService {
    private CopierView view;
    private ThreadPoolExecutor executor;

    public CopierService(CopierView view, ThreadPoolExecutor executor) {
        this.view = view;
        this.executor = executor;
    }

    public void start() throws FileNotFoundException {
        FileInputStream inputStream = view.getInputStream();
        FileOutputStream outputStream = view.getOutputStream();
        executor.submit(new Copier(inputStream, outputStream));

    }

    public void end() throws ExitApp, NotTerminatedException {
        executor.shutdownNow();
        if (executor.isTerminated()) {
            throw new ExitApp();
        } else {
            throw new NotTerminatedException();
        }
    }
}
