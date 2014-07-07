package ru.spb.samokhvalov.thread;

import ru.spb.samokhvalov.DTO.FirstStep;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by ivan on 08.07.14.
 */
public class Begin implements Runnable {
    private final BlockingQueue<FirstStep> outgoingQueue;

    public Begin(BlockingQueue<FirstStep> incomingQueue) {
        this.outgoingQueue = incomingQueue;
    }

    public void start(){
        Thread thread = new Thread(this, "Begin thread");
        thread.start();
    }

    @Override
    public void run() {
    Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i<=100; i++){
            FirstStep data = new FirstStep(" " + random.nextInt() + " id: " + i, " id: " + i);
            outgoingQueue.offer(data);

        }
    }
}
