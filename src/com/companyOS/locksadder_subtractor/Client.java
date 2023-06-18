package com.companyOS.locksadder_subtractor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {

    public static void main(String[] args) throws InterruptedException{
        Count count = new Count();

        Lock lock = new ReentrantLock();
        Adder adder = new Adder(count, lock);
        Subtractor subtractor = new Subtractor(count, lock);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);

        t1.start();
        t2.start();

//       Join=> Make sure that main thread will wait for thread(t1,t2) to complete its executions
//       allows one thread to wait until another thread completes its execution

        t1.join();
        t2.join();

        System.out.println(count.num);
    }
}
