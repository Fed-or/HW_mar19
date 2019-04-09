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

    public Human get(String name) {
        try (ObjectInputStream inputObjectStream =
                     new ObjectInputStream(new FileInputStream("storageTwo.dat"))) {
            Human[] humans = (Human[]) inputObjectStream.readObject();
            for (Human human : humans) {
                if (human.getName().equals(name)) {
                    return human;
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Human did not find");

        }
        return null;
    }
}
