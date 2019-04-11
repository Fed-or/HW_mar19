package com.fedor.homeworks.hw7.dao;

import com.fedor.homeworks.hw7.model.Client;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ClientDao {
    void save(Client client);

    Client get(String name) throws IOException, ClassNotFoundException;
}
