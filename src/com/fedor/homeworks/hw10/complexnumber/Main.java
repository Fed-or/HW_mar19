package com.fedor.homeworks.hw10.complexnumber;

public class Main {
    public static void main(String[] args) {
        ComplexNumber numberOne = new ComplexNumber(1,1);
        ComplexNumber numberTwo = new ComplexNumber(1,1);

        System.out.println(numberOne.equals(numberTwo));
        System.out.println(numberOne.hashcode());
        System.out.println(numberTwo.hashcode());
    }
}
