package org.coolstone.jdk.thread;


public class ThreadExample extends Thread {

    ThreadExample(){
        super();
    }
    ThreadExample(String name){
        super(name);
    }

    // run() method contains the code that is executed by the thread.
    @Override
    public void run() {
        System.out.println("Inside : " + Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getThreadGroup() + " " + Thread.currentThread().getClass());
    }

    public static void main(String[] args) {
        System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating thread...");
        Thread thread = new ThreadExample();
        Thread thread3 = new ThreadExample("abc");

        System.out.println("Starting thread...");
        thread.start();
        thread3.start();

    }


}