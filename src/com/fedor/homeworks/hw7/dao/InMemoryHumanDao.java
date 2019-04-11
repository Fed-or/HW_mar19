package com.fedor.homeworks.hw7.dao;

import com.fedor.homeworks.hw7.model.Human;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHumanDao implements HumanDao {
    private static final List<Human> inMemoryHumanDao = new ArrayList<>();

    @Override
    public void save(Human human) {
        inMemoryHumanDao.add(human);

    }

    @Override
    public Human get(String name) {
        for (Human human: inMemoryHumanDao) {
            if (human.getName().equals(name)) {
                return human;
            } else
                System.out.println("This human is not in base");
        }
        return null;
    }
}
