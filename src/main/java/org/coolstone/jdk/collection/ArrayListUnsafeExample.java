package org.coolstone.jdk.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArrayListUnsafeExample {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> unsafeArrayList =  new ArrayList<>();
        unsafeArrayList.add(1);
        unsafeArrayList.add(2);
        unsafeArrayList.add(3);

        List<Integer> safeArrayList = Collections.synchronizedList(new ArrayList<>());//new ArrayList<>();
        safeArrayList.add(1);
        safeArrayList.add(2);
        safeArrayList.add(3);

        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<Integer>();
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(3);


        // Create a thread pool of size 10
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Create a Runnable task that increments each element of the ArrayList by one
        Runnable task = () -> {
            incrementArrayList(unsafeArrayList);
            incrementSafeArrayList(safeArrayList);
            incrementSafeArrayList(copyOnWriteArrayList);
        };

        // Submit the task to the executor service 100 times.
        // All the tasks will modify the ArrayList concurrently
        for(int i = 0; i < 100; i++) {
            executorService.submit(task);
        }

        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println(unsafeArrayList);
        System.out.println(safeArrayList);
        System.out.println(copyOnWriteArrayList);

    }

    // Increment all the values in the ArrayList by one
    private static void incrementArrayList(List<Integer> unsafeArrayList) {
        for(int i = 0; i < unsafeArrayList.size(); i++) {
            Integer value = unsafeArrayList.get(i);
            unsafeArrayList.set(i, value + 1);
        }
    }

    // Increment all the values in the ArrayList by one
    // 似乎有这个方法已经足够，是否其他场景下需要List也是不可
    private static void incrementSafeArrayList(List<Integer> safeArrayList) {
        synchronized (safeArrayList) {
            for (int i = 0; i < safeArrayList.size(); i++) {
                Integer value = safeArrayList.get(i);
                safeArrayList.set(i, value + 1);
            }
        }
    }
}
