package com.eureka.learn;

import lombok.SneakyThrows;

import java.util.concurrent.*;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 *
 * @author Ljj
 * @date 2020/6/12 15:25
 * @since 1.0
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {



        System.out.println(Thread.currentThread().getName());

        // 异步调用
        System.out.println("CompletableFuture 异步："+CompletableFuture.supplyAsync(() -> Thread.currentThread().getName()).get());

        // 同步调用
        CompletableFuture.runAsync(()-> System.out.println("CompletableFuture 同步："+ Thread.currentThread().getName()));


        // 异步执行结果，获取返回值
        BlockingDeque<Runnable> deque = new LinkedBlockingDeque<>(5);
        ExecutorService executor = Executors.newScheduledThreadPool(10, r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });
        // 异步获取返回结果，并合并
        CompletionService service = new ExecutorCompletionService(executor,deque);

        for (int i=0;i<5;i++){
            service.submit(()->Thread.currentThread().getName());
        }

        for (int i=0;i<5;i++){
            Future future = service.poll(100, TimeUnit.MILLISECONDS);
            if (future!=null){

                System.out.println("CompletionService 获取执行结果："+future.get());
            }else {
                System.out.println("暂未返回结果");
            }
        }
    }
}
