package com.eureka.backpressure;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 背压
 *
 * @author Ljj
 * @date 2020/4/22 0:14
 * @since 1.0
 */
public class BackPressure {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(1, r -> {

            Thread t = new Thread(r);
            t.setName("自定义线程-RxJava");
            return t;
        });

        // Observerable  被观察者   Observer  观察者   Subscriber   订阅者
        Observable.from(new Integer[]{1,2,3,4,5,6,7})
                .subscribeOn(Schedulers.io()) // 发送事件得线程
                .observeOn(Schedulers.immediate())  // 接收事件得线程
                .map(s->{
                    System.out.println("当前线程名称为：" + Thread.currentThread().getName());
                    return s * s;
                })
                .observeOn(Schedulers.newThread())      // 新线程
                .filter(s-> {

                    System.out.println("当前线程开始过滤 ："+ Thread.currentThread().getName());
                    return s >10;
                })
                .observeOn(Schedulers.from(executorService)) // 任务在自定义的线程池里执行

                .subscribe(System.out::println); // 处理事件：订阅：使用Action处理



        // hold  main thread
        while (true){}



    }
}
