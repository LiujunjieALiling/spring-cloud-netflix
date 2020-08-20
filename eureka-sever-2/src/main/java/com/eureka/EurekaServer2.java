package com.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@ConfigurationPropertiesScan
public class EurekaServer2{

	public static void main(String[] args){

		new SpringApplicationBuilder(EurekaServer2.class).run(args);
				
	}
}