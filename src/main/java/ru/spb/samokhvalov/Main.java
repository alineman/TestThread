package ru.spb.samokhvalov;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ivan on 08.07.14.
 */
public class Main {
    public static void main(String[] args){
        System.out.println("Hello, world!");
        System.out.println("Producer Consumer Demo Code...");
        new ClassPathXmlApplicationContext("context.xml");

    }
}
