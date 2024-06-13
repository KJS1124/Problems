import java.util.*;
import java.lang.*;
import java.io.*;


class BlockingQueue {
    private List queue = new LinkedList();
    private int limit;
//    java.util.concurrent.BlockingQueue
    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    public void enqueue(Object item) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
    }

    public synchronized Object dequeue() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }

        return this.queue.remove(0);
    }
}

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BlockingQueue bq = new BlockingQueue(10);
        bq.enqueue(new Object());
    }
}