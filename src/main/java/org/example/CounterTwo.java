package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterTwo implements Runnable {

    private static AtomicInteger counter;
    private static final int limit = 1000;
    private static final int threadPoolSize = 5;

    public CounterTwo(AtomicInteger counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.get() < limit) {
            increaseCounter();
        }
    }

    private void increaseCounter() {
        System.out.println(Thread.currentThread().getName() + " : " + counter.getAndIncrement());
    }
}
