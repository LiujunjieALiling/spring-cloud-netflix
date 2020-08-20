package com.eureka.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ComputeController {


    @GetMapping(value="/testLoadBalance")
    public String add(@RequestParam Integer a, @RequestParam Integer b) {

		log.info("service-B 接收到请求======>");

		return String.valueOf(Math.addExact(a,b));
    }

}