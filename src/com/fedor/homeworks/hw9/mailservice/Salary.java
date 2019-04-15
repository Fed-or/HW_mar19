package com.fedor.homeworks.hw9.mailservice;

public class Salary extends AbstractDespatch<Integer> {

    public Salary(String from, String to, int salary) {
        super(from, to, salary);
    }
}
