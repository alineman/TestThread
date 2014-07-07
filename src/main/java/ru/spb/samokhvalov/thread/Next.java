package ru.spb.samokhvalov.thread;

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
        Thread thread = new Thread(this, "Next thread");
        thread.start();
    }


    @Override
    public void run() {
        int i = 0;
        while (incomingQueue.size()>0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            FirstStep step = incomingQueue.poll();
            System.out.print("step: " + (++i) + " ");
            System.out.println(step);
        }

    }
}
