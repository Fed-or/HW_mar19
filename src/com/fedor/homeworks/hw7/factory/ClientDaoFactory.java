package com.fedor.homeworks.hw7.factory;

import com.fedor.homeworks.hw7.dao.ClientDao;
import com.fedor.homeworks.hw7.dao.FileClientDao;
import com.fedor.homeworks.hw7.dao.InMemoryClientDao;
import com.fedor.homeworks.hw7.service.PropertyLoader;

import java.io.IOException;

public class ClientDaoFactory {

    private static final ClientDao inMemoryDao = new InMemoryClientDao();
    private static final ClientDao fileDao = new FileClientDao();


    public static ClientDao getClientDao(boolean isFileDao, boolean isInMemory) {
        try {
            String dbName = PropertyLoader.getProperty("db.nameClient");
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
