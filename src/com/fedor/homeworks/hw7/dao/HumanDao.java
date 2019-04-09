package com.fedor.homeworks.hw7.dao;

import com.fedor.homeworks.hw7.model.Human;

import java.io.FileNotFoundException;

public interface HumanDao {
    void save(Human human);

    Human get(String name) throws FileNotFoundException;
}
