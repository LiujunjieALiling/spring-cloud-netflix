package com.eureka.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * @author Ljj
 * @date 2020/8/15 0:16
 * @since 1.0
 */
@Configuration
public class MyRestTemplateConfiguration {

    @Primary
    @Bean
    @LoadBalanced
    public RestTemplate primaryRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public RestTemplate secondRestTemplate(){
        return new RestTemplate();
    }
}
