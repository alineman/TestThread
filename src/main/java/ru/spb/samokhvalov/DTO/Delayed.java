package ru.spb.samokhvalov.DTO;

/**
 * User: isamokhvalov
 * Date: 08.07.14
 * Time: 11:16
 */
public interface Delayed {
    /**
     * Delay thread
     * @param delay period in delay in ms
     */

    public void delay(int delay);

    public void delays(int delay);

}
