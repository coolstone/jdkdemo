package org.coolstone.jdk.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorsPeriodicExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Executing Task At " + System.nanoTime() + " " + Thread.currentThread().getName());
        };

        System.out.println("scheduling task to be executed every 2 seconds with an initial delay of 0 seconds");
        scheduledExecutorService.scheduleAtFixedRate(task, 0,2, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(task, 0,2, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(task, 0,2, TimeUnit.SECONDS);

    }
}