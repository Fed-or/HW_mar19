package com.fedor.homeworks.hw7.dao;

import com.fedor.homeworks.hw7.di.Component;
import com.fedor.homeworks.hw7.model.Client;

import java.io.*;

@Component
public class FileClientDao implements ClientDao{

    Client client;

    public void save(Client client)  {
        try(ObjectOutputStream outputStream =
                new ObjectOutputStream(new FileOutputStream("storage.dat"))) {
            outputStream.writeObject(client);
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Saving client in base was not successful");
        }
    }

    public Client get(String name){
        try (ObjectInputStream inputObjectStream =
                     new ObjectInputStream(new FileInputStream("storage.dat"))) {

            Client[] clients = (Client[]) inputObjectStream.readObject();

            for (Client client : clients) {
                if(client.getName().equals(name)){
                    return client;
                }
            }
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Client did not find in base");
        }
        return null;
    }
}
