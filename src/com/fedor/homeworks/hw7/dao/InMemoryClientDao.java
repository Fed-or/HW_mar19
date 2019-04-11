package com.fedor.homeworks.hw7.dao;

import com.fedor.homeworks.hw7.di.Component;
import com.fedor.homeworks.hw7.model.Client;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryClientDao implements ClientDao {

    private static final List<Client> inMemoryClientDao = new ArrayList<>();

    @Override
    public void save(Client client) {
        inMemoryClientDao.add(client);

    }

    @Override
    public Client get(String name) {
        for (Client client : inMemoryClientDao) {
            if (client.getName().equals(name)) {
                return client;
            } else
                System.out.println("This client is not in base");
        }
        return null;
    }
}
