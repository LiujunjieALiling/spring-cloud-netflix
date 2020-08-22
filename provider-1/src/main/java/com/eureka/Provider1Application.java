package com.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
public class Provider1Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Provider1Application.class).run(args);
	}

}

