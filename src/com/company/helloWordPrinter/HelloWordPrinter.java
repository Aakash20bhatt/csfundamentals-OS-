package com.company.helloWordPrinter;

public class HelloWordPrinter implements Runnable{

    public static void doSomething(){
        System.out.println("Do Something. Printed by thread: "+ Thread.currentThread().getName());
    }

    @Override
    public void run(){
        System.out.println("Hello Scaler. Printed by thread: "+ Thread.currentThread().getName());
        doSomething();
    }
}
