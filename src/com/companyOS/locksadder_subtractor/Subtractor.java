package com.companyOS.locksadder_subtractor;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable{

    private Count count;
    private Lock lock;

    public Subtractor(Count count, Lock lock){
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
//        System.out.println("Starting Subtractor");
        for(int i=0; i<100000; i++){
            lock.lock();
            this.count.num--;
            lock.unlock();

        }

//        System.out.println("Ending Subtractor");
    }
}
