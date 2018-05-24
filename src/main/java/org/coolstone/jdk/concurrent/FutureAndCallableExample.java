package org.coolstone.jdk.concurrent;

import java.util.concurrent.*;

public class FutureAndCallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<String> callable = () -> {
            // Perform some computation
            System.out.println("Entered Callable");
            Thread.sleep(1000);
            System.out.println("Outed Callable");
            return "Hello from Callable";
        };

        Callable<String> callable2 = new Callable<String>(){
            @Override
            public String call() throws Exception {
                // Perform some computation
                System.out.println("Entered anonymousClass Callable");
                Thread.sleep(3000);
                System.out.println("Outed anonymousClass Callable");
                return "Return anonymousClass some result";
            }
        };

        System.out.println("Submitting Callable");
        Future<String> future = executorService.submit(callable);
        Future<String> future2 = executorService.submit(callable2);


        // This line executes immediately
        System.out.println("Do something else while callable is getting executed");

        System.out.println("Retrieve the result of the future");
        // Future.get() blocks until the result is available
        try {
            System.out.println(future2.get(1, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        String result = future.get();

        System.out.println(result);

        executorService.shutdown();
    }

}