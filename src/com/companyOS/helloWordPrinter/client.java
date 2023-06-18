package com.companyOS.helloWordPrinter;

public class client {
    public static void main(String[] args) {

        System.out.println("Hello World. Printed by thread: "+ Thread.currentThread().getName());

        HelloWordPrinter hwp = new HelloWordPrinter();
        Thread t = new Thread(hwp);
        t.start();

        System.out.println("After Thread Creation. Printed by thread "+ Thread.currentThread().getName());
    }
}
