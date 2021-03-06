package com.eureka.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@SpringBootApplication(proxyBeanMethods = false)
@EnableCircuitBreaker
@RestController
public class Hystrix2Application {

	public static void main(String[] args) {
		SpringApplication.run(Hystrix2Application.class, args);
	}



	/**
	 * 注解模式
	 *
	 * @param time 阻塞时间
	 * @return 返回数据
	 * @throws Exception 中断异常
	 */
	@GetMapping
	@HystrixCommand(commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "50") // default 1000

	},fallbackMethod = "fallbackMethod")
	public String hystrix(@RequestParam(required =false,defaultValue = "10") int time) throws Exception{


		TimeUnit.MILLISECONDS.sleep(time);// 模拟超时

		System.out.printf(" hystrix() -time  %d %n",time);
		return "正常返回";
	}



	public String fallbackMethod(int time){

		System.out.printf(" fallbackMethod() -time  %d %n",time);
		return "超时熔断返回";
	}
}


