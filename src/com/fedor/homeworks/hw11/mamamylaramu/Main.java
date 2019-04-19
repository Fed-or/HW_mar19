package com.fedor.homeworks.hw11.mamamylaramu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Charset charset = Charset.forName("UTF-8");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, charset));
        String cleanString = reader.readLine().toLowerCase().replaceAll("[^\\p{L}\\p{Digit}]+", " ");
        String[] allWordsInString = cleanString.split(" ");
        Arrays.stream(allWordsInString)
                .flatMap(s -> Stream.of(s.split(" ")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                .reversed()
                .thenComparing(Map.Entry.comparingByKey()))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEachOrdered(System.out::println);
        reader.close();
    }
}
