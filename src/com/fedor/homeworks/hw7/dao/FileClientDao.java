package com.fedor.homeworks.hw7.dao;

import com.fedor.homeworks.hw7.di.Component;
import com.fedor.homeworks.hw7.model.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileClientDao implements ClientDao {
    private Client client = null;

    public void save(Client client) {
        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(new FileOutputStream("storage.dat"))) {
            outputStream.writeObject(client);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Saving client in base was not successful");
        }
    }

    public Client get(String name) {
        List<Client> clients = new ArrayList<>();
        try (ObjectInputStream inputObjectStream =
                     new ObjectInputStream(new FileInputStream("storage.dat"))) {
            clients.add((Client) inputObjectStream.readObject());
            for (Client clnt : clients) {
                if (clnt.getName().equals(name)) {
                    client = clnt;

                    return client;
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Client did not find in base");
        }
        return client;
    }
}