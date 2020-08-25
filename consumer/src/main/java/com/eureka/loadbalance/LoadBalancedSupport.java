package com.eureka.loadbalance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

/**
 * @author Ljj
 * @date 2020/8/9 22:48
 * @since 1.0
 */
@RestController
@RequestMapping
public class LoadBalancedSupport {

    @Autowired
    private RestTemplate  primaryRestTemplate;

    @Autowired
    @Qualifier("secondRestTemplate")
    private RestTemplate  secondRestTemplate;


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

}
