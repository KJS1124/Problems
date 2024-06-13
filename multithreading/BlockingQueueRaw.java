package multithreading;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-04-30
 * Time:15:01
 */
public class BlockingQueueRaw {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new BlockingQueue<>(10);

        Thread thread1 = new Thread(() -> {
            for(int i =0;i<=1000;i++)
            try {
                blockingQueue.enqueue("Testing" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i =0;i<=1000;i++)
                try {
                    System.out.println(blockingQueue.dequeue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        });

        thread1.start();
        thread2.start();
    }
}

class BlockingQueue<T> {
    private T queue[];
    private volatile int head;
    private volatile int tail;
    private int size;

    public BlockingQueue(int size) {
        this.size = size;
        this.queue = (T[]) new Object[size];
        this.head = 0;
        this.tail = 0;
    }

    public synchronized void enqueue(T element) throws InterruptedException {
        int nextElement = (tail + 1) % size;
        while (nextElement==head) {
           wait();
        }

        queue[tail] = element;
        tail = nextElement;
        notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (head==tail) {
            wait();
        }

        T element = this.queue[head];
        head++;
        if(head==size) head =0;
        notifyAll();
        return element;
    }
}
