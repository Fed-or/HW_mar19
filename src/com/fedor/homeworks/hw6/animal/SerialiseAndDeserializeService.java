package com.fedor.homeworks.hw6.animal;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerialiseAndDeserializeService{
    public static void main(String[] args) throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objects.bin"));
        Animal[] animals = {new Animal("Dog"), new Animal("Cat"),
                new Animal("Duck"), new Animal("Bear")};
        int numberOfAnimals = animals.length;
        System.out.println("Number of Animals are: " + numberOfAnimals);
        oos.writeInt(numberOfAnimals);
        for (int i = 0; i < numberOfAnimals; i++) {
            oos.writeObject(animals[i]);
        }
        oos.close();

        Path path = Paths.get("objects.bin");
        byte[] getByteArrayAnimals = Files.readAllBytes(path);

        Animal[] animalFromByteArray = deserializeAnimalArray(getByteArrayAnimals);
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        try {
            ObjectInputStream is = new ObjectInputStream(new ByteArrayInputStream(data));
            int numberOfAnimalsFromByte = is.readInt();
            System.out.println("Number of Animals: " + numberOfAnimalsFromByte);
            Animal[] animalsDeserialize = new Animal[numberOfAnimalsFromByte];
            for (int i = 0; i < numberOfAnimalsFromByte; i++) {
                animalsDeserialize[i] = (Animal) is.readObject();
            }
            return animalsDeserialize;
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException();
        }
    }
}
