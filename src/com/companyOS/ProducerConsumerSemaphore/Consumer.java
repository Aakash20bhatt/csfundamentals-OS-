package com.companyOS.ProducerConsumerSemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private Queue<Object> queue;
    private int maxSize;
    private String name;
    private Semaphore consumerSemaphore;
    private Semaphore producerSemaphore;

    public Consumer(Queue queue, int maxSize, String name, Semaphore consumerSemaphore, Semaphore producerSemaphore){
        this.queue = queue;
        this.maxSize = maxSize;
        this.name = name;
        this.consumerSemaphore = consumerSemaphore;
        this.producerSemaphore = producerSemaphore;
    }

    @Override
    public void run(){
        while(true){
            try {
                consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name+" Removing an element. Queue size: "+queue.size());
            queue.remove();
            producerSemaphore.release();
        }
    }

}
