package ru.spb.samokhvalov.thread;

import org.springframework.beans.factory.annotation.Autowired;
import ru.spb.samokhvalov.DTO.Delayed;
import ru.spb.samokhvalov.DTO.FirstStep;
import ru.spb.samokhvalov.DTO.StaticDelay;

import java.util.AbstractQueue;
import java.util.Random;

/**
 * Created by ivan on 08.07.14.
 */
public class Begin implements Runnable {

    @Autowired
    Delayed delayed;

    private final AbstractQueue<FirstStep> outgoingQueue;

    public Begin(AbstractQueue<FirstStep> incomingQueue) {
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
//            System.out.println(Thread.currentThread().getName() + " add: " + (i));
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            long t = System.currentTimeMillis();
            StaticDelay.delay(100);
            System.out.println(Thread.currentThread().getName() + " time: " + (System.currentTimeMillis() - t));

        }
    }
}
