package com.eureka.loadbalance;

import com.eureka.annotation.MyLoadBalanced;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Ljj
 * @date 2020/8/9 22:48
 * @since 1.0
 */
@RestController
@RequestMapping
@Slf4j
public class LoadBalancedSupport implements ApplicationContextAware {

    @Autowired
    private RestTemplate  primaryRestTemplate;

    @Autowired
    @Qualifier("secondRestTemplate")
    private RestTemplate  secondRestTemplate;

    @MyLoadBalanced
    @Autowired
    private List<RestTemplate> restTemplateList = new ArrayList<>();


    private ApplicationContext applicationContext;

    @GetMapping("/loadBalance")
    public Map<String,String> loadBalanced(){

        String str = primaryRestTemplate.getForObject("http://provider/testLoadBalance?a=10&b=20", String.class);

        return Collections.singletonMap(str,"0");
    }

    @GetMapping("/noLoadBalance")
    public Map<String,String> noLoadBalanced(){

        String str = secondRestTemplate.getForObject("http://provider/testLoadBalance?a=10&b=20", String.class);

        return Collections.singletonMap(str,"0");
    }

    @GetMapping("/customLoadBalance")
    public Map<String,String> customLoadBalance(){

        restTemplateList.forEach(restTemplate -> log.info("注入得bean与容器中得bean是否相同：{}",restTemplate.equals(applicationContext.getBean("myRestTemplate"))));

        return Collections.singletonMap("SUCCESS","0");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.applicationContext = applicationContext;
    }
}
