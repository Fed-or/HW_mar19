package com.fedor.homeworks.hw7.di;

import com.fedor.homeworks.hw7.dao.*;
import com.fedor.homeworks.hw7.factory.ClientDaoFactory;
import com.fedor.homeworks.hw7.factory.HumanDaoFactory;
import com.fedor.homeworks.hw7.handler.ConsoleHandler;
import com.fedor.homeworks.hw7.model.Human;

import java.lang.reflect.Field;

public class Injector {
    public static void injectDependency() throws IllegalAccessException {
        Class consoleHandlerClass = ConsoleHandler.class;
        Class fileClientDaoClass = FileClientDao.class;
        Class inMemoryClientDaoClass = InMemoryClientDao.class;
        Class fileHumanDaoClass = FileHumanDao.class;
        Class inMemoryHumanDaoClass = InMemoryHumanDao.class;

        Field[] fields = consoleHandlerClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectClient.class)) {
                clientRef(field, fileClientDaoClass, inMemoryClientDaoClass);
            } else if (field.isAnnotationPresent(InjectHuman.class)) {
                humanRef(field, fileHumanDaoClass, inMemoryHumanDaoClass);
            }
        }
    }

    private static void clientRef(Field field, Class file, Class inMemory) {
        field.setAccessible(true);
        boolean fileDao = file.isAnnotationPresent(Component.class);
        if (fileDao) {
            System.out.println("Working with files allowed");
        }
        boolean inMemoryDao = inMemory.isAnnotationPresent(Component.class);
        if (inMemoryDao) {
            System.out.println("Working with memory allowed");
        }
        ClientDao clientDao = ClientDaoFactory.getClientDao(fileDao, inMemoryDao);
        try {
            field.set(null, clientDao);
        } catch (IllegalAccessException e) {
            System.out.println("Couldn`t set fields");
        }
    }

    private static void humanRef(Field field, Class file, Class inMemory) {
        field.setAccessible(true);
        boolean fileDao = file.isAnnotationPresent(Component.class);
        if (fileDao) {
            System.out.println("Working with files allowed");
        }
        boolean inMemoryDao = inMemory.isAnnotationPresent(Component.class);
        if (inMemoryDao) {
            System.out.println("Working with memory allowed");
        }
        HumanDao humanDao = HumanDaoFactory.getHumanDao(fileDao, inMemoryDao);
        try {
            field.set(null, humanDao);
        } catch (IllegalAccessException e) {
            System.out.println("Couldn`t set fields");
        }
    }
}
