package com.eureka.hystrix.dashboard;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 1. 访问http://localhost:8084/hystrix 可以查看Dashboard
 * 2. 在输入框中填入: (1) http://localhost:8083/actuator/hystrix.stream
 *                 (2) 输入Delay毫秒数
 *                 (3) 输入Title名称
 * 注意：首先要先调用一下想监控的服务的API，否则将会显示一个空的图表.
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixDashboardApplication.class).run(args);
    }

}