package com.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class B2_Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(B2_Application.class).run(args);
	}

}
