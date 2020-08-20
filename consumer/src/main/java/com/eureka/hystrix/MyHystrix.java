//package com.ljj.demo.springclouddemo.hystrix;
//
//import com.netflix.hystrix.HystrixCommand;
//import com.netflix.hystrix.HystrixCommandGroupKey;
//import rx.Observable;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Future;
//
//
///**
// * Hystrix ：限流、熔断、快速失败
// * @author Ljj
// * @date 2020/4/21 23:16
// * @since 1.0
// */
//public class MyHystrix {
//
//    private Map<String, String> serviceUrl = new HashMap<>();
//
//    {
//        this.serviceUrl.put("1", "2");
//    }
//
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//
//
//        // approach-1    normal
//        String command = new MyHystrixCommand("Normal").execute();
//        System.out.println("正常输出："+command);
//
//        String fallback = new MyHystrixCommand(null).execute();
//        System.out.println("异常输出："+fallback);
//
//        // approach-2    Future
//        Future<String> future = new MyHystrixCommand("Future").queue();
//        System.out.println("异步获取结果：" + future.get());
//
//        // approach-3    RxJava: 吞吐量更高
//        Observable<String> rxJava = new MyHystrixCommand("RxJava").observe();
//        rxJava.subscribe(System.out::println);
//
//
//    }
//
//
//}
//
//
//class MyHystrixCommand extends HystrixCommand<String> {
//
//    private static final String DEFAULT_GROUP = "myHystrixGroup";
//    private String name;
//
//    // 指定一个HystrixCommandGroupKey，这样熔断策略会按照此组执行
//    public MyHystrixCommand(String name) {
//        super(HystrixCommandGroupKey.Factory.asKey(DEFAULT_GROUP));
//        this.name = name;
//    }
//
//    @Override
//    protected String run() throws Exception {
//
//        if (name == null)
//            throw new NullPointerException();
//
//        return "Hello " + name ;
//    }
//
//    @Override
//    protected String getFallback() {
//
//        return "This is a fallback";
//    }
//}