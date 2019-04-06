package com.fedor.homeworks.hw6.mypair;

import java.util.Objects;

public class MyPair<T, S> {
    private T first;
    private S second;

    public MyPair(T first, S second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyPair)) return false;
        MyPair<?, ?> myPair = (MyPair<?, ?>) o;
        return Objects.equals(first, myPair.first) &&
                Objects.equals(second, myPair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    public static <T, S> MyPair<T, S> of(T first, S second) {
        return new MyPair<>(first, second);
    }
}
