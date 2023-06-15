package com.company.introToThreads;

public class client {
    public static void doSomething(){
        System.out.println("Do Something. Printed Thread:" + Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        System.out.println("Hello World, Printed by thread:"+ Thread.currentThread().getName());

        doSomething();
    }
}
