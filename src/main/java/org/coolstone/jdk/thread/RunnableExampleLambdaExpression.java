package org.coolstone.jdk.thread;

import java.util.function.*;

public class RunnableExampleLambdaExpression {

    public static void main(String[] args) {
        System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating Runnable...");
        Runnable runnable = () -> {
            System.out.println("Inside : " + Thread.currentThread().getName());
        };

        System.out.println("Creating Thread...");
        Thread thread = new Thread(runnable);

        System.out.println("Starting Thread...");
        thread.start();


        Runnable runnable2  = () -> System.out.println("Hello, World!");
        runnable2.run();

        IntConsumer myIntConsumer = (value) -> System.out.println(value);
        myIntConsumer.accept(2);

        LongConsumer myLongConsumer = (value) -> System.out.println(value);
        myLongConsumer.accept(2L);

        DoubleConsumer myDoubleConsumer = (value) -> System.out.println(value);
        myDoubleConsumer.accept(2);

        Consumer<String> myStringConsumer = (value) -> System.out.println(value);
        myStringConsumer.accept("abc");

    }

}