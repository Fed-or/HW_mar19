package com.fedor.homeworks.hw7;

import com.fedor.homeworks.hw7.di.Injector;
import com.fedor.homeworks.hw7.handler.ConsoleHandler;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, FileNotFoundException {
        Injector.injectDependency();
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.handle();
    }
}
