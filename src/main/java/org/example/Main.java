package org.example;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.w3c.dom.css.Counter;

public class Main {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world!");
            }
        }).start();

//        File directory = new File("/Users/szawartka/Documents/git-repos/Testing/src/main/java/org/example");
//        String[] names = directory.list((dir, name) -> name.endsWith(".java"));
//        System.out.println(Arrays.asList(names));
//
//        List<Double> list = Stream.generate(Math::random)
//            .limit(100)
//            .collect(Collectors.toList());
//
//        List<Double> sorted = list.stream()
//            .sorted((s1, s2) -> s1.compareTo(s2))
//            .collect(Collectors.toList());
//
//        sorted.forEach(System.out::println);

//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 5; i++) {
//            CounterOne task = new CounterOne();
//            executorService.submit(task);
//        }
//        executorService.shutdown();
        System.out.println("_________________________________________");
        System.out.println("_________________________________________");
        System.out.println("_________________________________________");
        System.out.println("_________________________________________");
        System.out.println("_________________________________________");
//        ExecutorService executorService2 = Executors.newFixedThreadPool(5);
//        AtomicInteger counter = new AtomicInteger(0);
//        for (int i = 0; i < 5; i++) {
//            CounterTwo task = new CounterTwo(counter);
//            executorService2.submit(task);
//        }
//        executorService2.shutdown();

        ExecutorService executorService3 = Executors.newFixedThreadPool(5);
        ReentrantLock sharedLock = new ReentrantLock();
        for (int i = 0; i < 5; i++) {
            CounterThree task = new CounterThree(sharedLock);
            executorService3.submit(task);
        }
        executorService3.shutdown();
    }
}