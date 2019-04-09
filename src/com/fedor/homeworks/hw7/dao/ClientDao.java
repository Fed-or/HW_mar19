package com.fedor.homeworks.hw7.dao;

import com.fedor.homeworks.hw7.model.Client;

public interface ClientDao {
    void save(Client client);

    Client get(String name);
}
