package com.eureka.learn;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Ljj
 * @date 2020/6/10 10:49
 * @since 1.0
 */
public class PrintChar {


    private static final Semaphore A = new Semaphore(1);
    private static final Semaphore B = new Semaphore(0);
    private static final Semaphore C = new Semaphore(0);


    public static void main(String[] args) {


        new Thread(()->{

            try {

                A.acquire();
                System.out.println("a");
                B.release();

            } catch (InterruptedException e) {

                e.printStackTrace();
            }


        },"线程A").start();

        new Thread(()->{

            try {

                C.acquire();
                System.out.println("c");

            } catch (InterruptedException e) {

                e.printStackTrace();
            }


        },"线程C").start();

        new Thread(()->{

            try {

                B.acquire();
                System.out.println("b");
                C.release();

            } catch (InterruptedException e) {

                e.printStackTrace();
            }


        },"线程B").start();


    }



}
