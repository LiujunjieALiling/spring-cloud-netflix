package com.eureka.caseinterview;


import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class PrintChar {

    private static final Semaphore A = new Semaphore(1);
    private static final Semaphore B = new Semaphore(0);
    private static  AtomicInteger count = new AtomicInteger();


    public static void main(String[] args) throws InterruptedException {

        for (; ; ) {
            TimeUnit.SECONDS.sleep(1);
            new Thread(() -> {
                try {
                    A.acquire();
                    System.out.print("A");
                    TimeUnit.SECONDS.sleep(1);
                    B.release(4);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

            }, "线程A").start();

            new Thread(() -> {
                try {
                    B.acquire();
                    System.out.print("B");
                    if (count.incrementAndGet() % 4 ==0)
                        A.release(1);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

            }, "线程B").start();

        }

    }
}
