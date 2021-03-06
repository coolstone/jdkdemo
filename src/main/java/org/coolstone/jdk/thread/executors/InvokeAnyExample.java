package org.coolstone.jdk.thread.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAnyExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Callable<String> task1 = () -> {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(2000);
            return "Result of Task1";
        };

        Callable<String> task2 = () -> {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
            return "Result of Task2";
        };

        Callable<String> task3 = () -> {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(5000);
            return "Result of Task3";
        };

        // Returns the result of the fastest callable. (task2 in this case)
        String result = executorService.invokeAny(Arrays.asList(task1, task2, task3));

        System.out.println(result);

        executorService.shutdown();
    }
}