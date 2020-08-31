package com.eureka.hystrix.config;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCacheAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author Ljj
 * @date 2020/8/9 18:33
 * @since 1.0
 */
@Configuration
public class ListConfigurations {


    @Primary
    @Bean
    public HystrixCacheAspect primaryCacheAspect(){

        return new HystrixCacheAspect();
    }

    @Bean
    public HystrixCacheAspect secondCacheAspect(){

        return new HystrixCacheAspect();
    }
}
