package com.fedor.homeworks.hw6.compaireset;

import java.util.HashSet;
import java.util.Set;

public class SymmetricSet {

    public static void main(String[] args) {
        Set<Integer> setFirst = new HashSet<>();
        setFirst.add(20);
        setFirst.add(9);
        setFirst.add(5);
        setFirst.add(1);

        HashSet<Integer> setSecond = new HashSet<>();
        setSecond.add(1);
        setSecond.add(2);
        setSecond.add(10);
        setSecond.add(20);

        System.out.println("First set: " + setFirst);
        System.out.println();
        System.out.println("Second set: " + setSecond);
        System.out.println();

        Set<Integer> result = symmetricDifference(setFirst, setSecond);
        System.out.println(result);
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> setFirst = new HashSet<>(set1);
        Set<T> setSecond = new HashSet<>(set2);
        setFirst.removeAll(set2);
        setSecond.removeAll(set1);
        setFirst.addAll(setSecond);
        return setFirst;
    }
}
