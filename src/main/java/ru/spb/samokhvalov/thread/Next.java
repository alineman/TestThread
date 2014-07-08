package ru.spb.samokhvalov.thread;

import org.springframework.beans.factory.BeanNameAware;
import ru.spb.samokhvalov.DTO.FirstStep;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by ivan on 08.07.14.
 */
public class Next implements Runnable {
    private final BlockingQueue<FirstStep> incomingQueue;

    public Next(BlockingQueue<FirstStep> incomingQueue) {
        this.incomingQueue = incomingQueue;
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }


    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int size = incomingQueue.size();
            if (size > 0) {
                FirstStep step = incomingQueue.poll();
                if (step != null) {
                    System.out.println(Thread.currentThread().getName() + " current size: " + size);
                }
            }
        }

    }
}
