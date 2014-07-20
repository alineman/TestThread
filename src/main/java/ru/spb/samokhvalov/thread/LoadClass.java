package ru.spb.samokhvalov.thread;

import ru.spb.samokhvalov.DTO.FirstStep;

import java.util.AbstractQueue;

/**
 * Created by ivan on 08.07.14.
 */
public class LoadClass {
    private final Integer count;
    private final AbstractQueue<FirstStep> incomingQueue;

    public LoadClass(Integer count, AbstractQueue<FirstStep> incomingQueue) {
        this.count = count;
        this.incomingQueue = incomingQueue;
        for (int i =0; i<count; i++){
            Next thread = new Next(incomingQueue);
            thread.start();
//            thread.run();
        }
    }

}
