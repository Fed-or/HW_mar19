package com.fedor.homeworks.hw7.model;

public class Human {
    private String name;
    private String address;

    public Human(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

   @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
