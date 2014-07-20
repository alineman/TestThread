package ru.spb.samokhvalov.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.spb.samokhvalov.DTO.Delayed;
import ru.spb.samokhvalov.DTO.FirstStep;
import ru.spb.samokhvalov.DTO.StaticDelay;

import java.util.AbstractQueue;

/**
 * Created by ivan on 08.07.14.
 */
@Component
public class Next implements Runnable {

    @Autowired
    Delayed delayed;

    private final AbstractQueue<FirstStep> incomingQueue;

    public Next(AbstractQueue<FirstStep> incomingQueue) {
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
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            int size = incomingQueue.size();
            if (size > 0) {
                FirstStep step = incomingQueue.poll();
                long t = System.currentTimeMillis();
                StaticDelay.delay(500);
                System.out.println(Thread.currentThread().getName() + " time: " + (System.currentTimeMillis() - t));
                if (step != null) {
                    System.out.println(Thread.currentThread().getName() + " current size: " + size);
                }
            }
        }

    }
}
