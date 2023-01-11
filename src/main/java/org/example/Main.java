package org.example;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world!");
            }
        }).start();

        File directory = new File("/Users/szawartka/Documents/git-repos/Testing/src/main/java/org/example");
        String[] names = directory.list((dir, name) -> name.endsWith(".java"));
        System.out.println(Arrays.asList(names));

        List<Double> list = Stream.generate(Math::random)
            .limit(100)
            .collect(Collectors.toList());

        List<Double> sorted = list.stream()
            .sorted((s1, s2) -> s1.compareTo(s2))
            .collect(Collectors.toList());

        sorted.forEach(System.out::println);
    }
}