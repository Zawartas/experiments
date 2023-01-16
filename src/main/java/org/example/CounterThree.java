package org.example;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class CounterThree implements Runnable {

    private ReentrantLock lock;
    private static int counter = 0;
    private static final int limit = 15;
    private static final int threadPoolSize = 5;

    public CounterThree(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (counter < limit) {
            increaseCounter();
        }
    }

    private void increaseCounter() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " holdCount : " + lock.getHoldCount());
            System.out.println(Thread.currentThread().getName() + " : " + counter);
            counter++;
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
//            System.out.println(Thread.currentThread().getName() + " queue: " + lock.getQueueLength());
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " after : " + lock.getHoldCount());
        }
    }
}
