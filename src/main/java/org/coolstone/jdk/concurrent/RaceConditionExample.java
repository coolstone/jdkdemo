package org.coolstone.jdk.concurrent;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RaceConditionExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        Counter counter = new Counter();

        for (int i = 0; i < 1000; i++) {

            //executorService.submit(() -> counter.increment());
            executorService.submit(() ->counter.increment());
        }


        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

        for (int i = 0; i < 1000; i++) {

            //executorService.submit(() -> counter.increment());
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    synchronizedCounter.increment();
                 }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("Final count is : " + counter.getCount());
        System.out.println("Final synchronizedCounter count is : " + synchronizedCounter.getCount());


    }
}

class SynchronizedCounter {
    int count = 0;


//    public synchronized void increment() {
//        count = count + 1;
//    }

    public void increment() {
        // Synchronized Block -

        // Acquire Lock
        synchronized (this) {
            count = count + 1;
        }
        // Release Lock
    }

    public int getCount() {
        return count;
    }
}

class Counter {
    int count = 0;

    public void increment() {
        count = count + 1;
    }

    public int getCount() {
        return count;
    }
}