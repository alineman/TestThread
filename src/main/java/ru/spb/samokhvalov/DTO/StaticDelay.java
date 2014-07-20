package ru.spb.samokhvalov.DTO;

/**
 * User: isamokhvalov
 * Date: 08.07.14
 * Time: 16:16
 */
public class StaticDelay {
    public static void delay(int delay) {
        try {
            System.out.println(Thread.currentThread().getName() + " Begin");
            Thread.sleep(delay);
            System.out.println(Thread.currentThread().getName() + " End");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
