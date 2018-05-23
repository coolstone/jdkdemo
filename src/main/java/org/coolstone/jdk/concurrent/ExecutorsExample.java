package org.coolstone.jdk.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample {
    public static void main(String[] args) {
        System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating Executor Service...");
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        System.out.println("Creating a Runnable...");
        Runnable runnable = () -> {
            System.out.println("Inside : " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Inside2 : " + Thread.currentThread().getName());
        };
        Runnable runnable2 = () -> {
            System.out.println("InsideA : " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("InsideA2 : " + Thread.currentThread().getName());
        };

        System.out.println("Submit the task specified by the runnable to the executor service.");
        executorService.submit(runnable);
        executorService.submit(runnable2);
        executorService.shutdown();
    }
}