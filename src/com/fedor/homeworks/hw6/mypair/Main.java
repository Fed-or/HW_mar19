package com.fedor.homeworks.hw6.mypair;

public class Main{
    public static void main(String[] args) {


        MyPair<Integer, String> pair = MyPair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        System.out.println(i + ", " + s);


        MyPair<Integer, String> pair2 = MyPair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(mustBeTrue + ", " + mustAlsoBeTrue);
    }
}
