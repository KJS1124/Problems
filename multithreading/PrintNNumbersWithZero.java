package multithreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-04-28
 * Time:21:43
 */
public class PrintNNumbersWithZero {
    public static void main(String[] args) throws InterruptedException {
        JobSemaphore job = new JobSemaphore(10000);
        Thread thread1 = new Thread(() -> {
            try {
                job.printZero();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                job.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread thread3 = new Thread(() -> {
            try {
                job.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }
}

class Job {
    ReentrantLock lock;
    Condition isZero;
    Condition isEven;
    Condition isOdd;
    int n;
    AtomicInteger counter;

    Job(int n) {
        this.n = n;
        this.lock = new ReentrantLock();
        this.isZero = lock.newCondition();
        this.isEven = lock.newCondition();
        this.isOdd = lock.newCondition();
        this.counter = new AtomicInteger(0);
    }

    public void printZero() throws InterruptedException {
        lock.lock();
        System.out.println("zero");
        for (int i = 0; i < n; i++) {
            if (this.counter.get() != 0) isZero.await();
            System.out.println(0);
            if (this.counter.get() == 0) {
                this.counter.getAndIncrement();
            }
            if (this.counter.get() % 2 == 0) {
                isEven.signal();
            } else {
                isOdd.signal();
            }
        }
        lock.unlock();
    }

    public void printOdd() throws InterruptedException {
        lock.lock();
        System.out.println("odd");
        for (int i = 0; i < n/2; i++) {
            while (this.counter.get() % 2 != 1)
                isOdd.await();
            System.out.println(this.counter.getAndIncrement());

            isZero.signal();
        }
        lock.unlock();
    }

    public void printEven() throws InterruptedException {
        lock.lock();
        System.out.println("even");
        isEven.await();
        for (int i = 0; i < n/2; i++) {
            while (this.counter.get() % 2 != 0)
                isEven.await();
            System.out.println(this.counter.getAndIncrement());
            isZero.signal();
        }
        lock.unlock();
    }
}


class JobSemaphore {
    private Semaphore zero;
    private Semaphore odd;
    private Semaphore even;
    private int n;

    public JobSemaphore(int n) {
        this.zero = new Semaphore(1);
        this.odd = new Semaphore(0);
        this.even = new Semaphore(0);
        this.n = n;
    }

    public void printZero() throws InterruptedException {
        for(int i=0;i<=n;i++) {
            this.zero.acquire();
            System.out.println(0);
            if((i+1)%2==0) {
                even.release();
            } else {
                odd.release();
            }
        }
    }

    public void printOdd() throws InterruptedException {
        for(int i=1;i<=n;i+=2) {
            this.odd.acquire();
            System.out.println(i);
            this.zero.release();
        }
    }

    public void printEven() throws InterruptedException {
        for(int i=2;i<=n;i+=2) {
            this.even.acquire();
            System.out.println(i);
            this.zero.release();
        }
    }

}