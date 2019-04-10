package com.fedor.homeworks.hw7.dao;

import com.fedor.homeworks.hw7.di.Component;
import com.fedor.homeworks.hw7.model.Human;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileHumanDao implements HumanDao {
    private Human human = null;

    public void save(Human human) {
        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(new FileOutputStream("storageTwo.dat"))) {
            outputStream.writeObject(human);
        } catch (IOException e) {
            System.out.println("Saving Human in base was not successful");
        }
    }

    public Human get(String name) throws IOException, ClassNotFoundException {
        List<Human> humans = new ArrayList<>();
        try (ObjectInputStream inputObjectStream =
                     new ObjectInputStream(new FileInputStream("storageTwo.dat"))) {
            humans.add((Human) inputObjectStream.readObject());
            for (Human hmn : humans) {
                if (hmn.getName().equals(name)) {
                    human = hmn;
                    return human;
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Human did not find in base");
        }
        return human;
    }
}