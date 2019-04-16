package com.fedor.homeworks.hw9.minandmax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinMax {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> listOfNumbers = new ArrayList<>();
                stream.sorted(order).forEach(listOfNumbers :: add);
        if(listOfNumbers.size() > 1){
            minMaxConsumer.accept(listOfNumbers.get(0), listOfNumbers.get(listOfNumbers.size() - 1));
        }
        else
            minMaxConsumer.accept(null, null);
    }

    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(3,5,7,9,12,2);
        findMinMax(num.stream(), Comparator.naturalOrder(),
                (integer, integer2) -> System.out.println("Minimum: " + integer +
                        ", " + "Maximum: " + integer2));
    }
}
