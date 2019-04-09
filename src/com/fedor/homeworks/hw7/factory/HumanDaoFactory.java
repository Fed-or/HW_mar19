package com.fedor.homeworks.hw7.factory;

import com.fedor.homeworks.hw7.dao.FileHumanDao;
import com.fedor.homeworks.hw7.dao.HumanDao;
import com.fedor.homeworks.hw7.dao.InMemoryHumanDao;
import com.fedor.homeworks.hw7.service.PropertyLoader;

import java.io.IOException;

public class HumanDaoFactory {

    private static final HumanDao inMemoryDao = new InMemoryHumanDao();
    private static final HumanDao fileDao = new FileHumanDao();


    public static HumanDao getHumanDao(boolean isFileDao, boolean isInMemory) {
        try {
            String dbName = PropertyLoader.getProperty("db.name");
            if (dbName.equals("memory") && isInMemory) {
                return inMemoryDao;
            }
        } catch (IOException e) {
            System.out.println("Don`t access to file");
        }
        if (isFileDao) {
            return fileDao;
        } else {
            throw new ComponentNotFoundException();
        }
    }
}

