package ru.spb.samokhvalov.DTO;

import org.springframework.stereotype.Component;

/**
 * User: isamokhvalov
 * Date: 08.07.14
 * Time: 11:17
 */
@Component
public class DelayedImpl implements Delayed {

    public void delay(int delay) {
        try {
            System.out.println(Thread.currentThread().getName() + " Begin");
            Thread.sleep(delay);
            System.out.println(Thread.currentThread().getName() + " End");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void delays(int delay) {
        try {
            System.out.println(Thread.currentThread().getName() + " sBegin");
            Thread.sleep(delay);
            System.out.println(Thread.currentThread().getName() + " sEnd");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
