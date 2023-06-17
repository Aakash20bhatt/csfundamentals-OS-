package com.company.AtomicInteger_Adder_subtractor;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable{

    private Count count;
    public Subtractor(Count count, Lock lock){
        this.count = count;
    }

    @Override
    public void run() {
//        System.out.println("Starting Subtractor");
        for(int i=0; i<100000; i++){
            this.count.value.addAndGet(-i);

        }

//        System.out.println("Ending Subtractor");
    }
}
