package com.eureka.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import rx.Observable;

import java.util.concurrent.Future;

import static junit.framework.Assert.assertEquals;


/**
 * 使用Hystrix
 *
 * @author Ljj
 * @date 2020/7/11 12:05
 * @since 1.0
 */
public class CommandTest {

    public static void main(String[] args) {

        // Synchronous,  等价于 queue().get()
        assertEquals("Hello World!", new CommandHelloWorld("World").execute());
        assertEquals("Hello Bob!", new CommandHelloWorld("Bob").execute());

        // asynchronous，调用 #toObservable() 方法的基础上，调用：Observable#toBlocking() 和 BlockingObservable#toFuture() 返回 Future
        Future<String> f = new CommandHelloWorld("Bob").queue();

        // asynchronous，调用 #toObservable() 方法，并向 Observable 注册 rx.subjects.ReplaySubject 发起订阅。
        Observable<String> o = new CommandHelloWorld("Bob").observe();
    }
}

class CommandHelloWorld extends HystrixCommand<String>{ //  // HystrixObservableCommand

    private String name;
    public CommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {

        return "Hello " + name + "!";
    }
}