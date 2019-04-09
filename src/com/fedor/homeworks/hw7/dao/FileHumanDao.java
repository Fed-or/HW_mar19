package com.fedor.homeworks.hw7.dao;

import com.fedor.homeworks.hw7.di.Component;
import com.fedor.homeworks.hw7.model.Human;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileHumanDao implements HumanDao {

    public void save(Human human) {
        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(new FileOutputStream("storageTwo.dat"))) {
            List<Human> humans = new ArrayList<>();
            humans.add(human);
            outputStream.writeObject(humans);
        } catch (IOException e) {
            System.out.println("Human was not save to base");
        }
    }

    public Human get(String name) throws IOException, ClassNotFoundException {
        Human human = null;
        try (ObjectInputStream inputObjectStream =
                     new ObjectInputStream(new FileInputStream("storageTwo.dat"))) {
            Human[] humans = (Human[]) inputObjectStream.readObject();
            for (Human hmn : humans) {
                if (!hmn.getName().equals(name)) {
                    throw new IllegalArgumentException("Human did not find in base");
                } else {
                    human = hmn;
                }
            }
        }
        return human;
    }
}