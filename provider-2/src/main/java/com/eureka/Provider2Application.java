package com.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class Provider2Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Provider2Application.class).run(args);
	}

}
