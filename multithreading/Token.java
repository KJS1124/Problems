package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-05-17
 * Time:16:31
 */
public class Token {
    public static void main(String[] args) throws InterruptedException {
        Bucket bucket = new Bucket(10);
        for(int i =0;i<100;i++) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " " + bucket.getToken());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.setName("Thread" + i);
            thread.start();
        }
    }
}

class Bucket {
    AtomicInteger token;
    int size;
    ScheduledExecutorService service;

    public Bucket(int size) {
        this.size = size;
        this.token = new AtomicInteger(size);
        this.service = Executors.newScheduledThreadPool(1);
        this.service.scheduleAtFixedRate(this::addToken, 1, 1, TimeUnit.SECONDS);
    }
    public synchronized boolean getToken() throws InterruptedException {
        while(token.get() == 0) {
            wait();
        }

        token.decrementAndGet();
        return true;
    }

    public synchronized void addToken() {
        if(token.get()<size) {
            token.incrementAndGet();
            notifyAll();
        }
    }
}
