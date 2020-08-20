package com.eureka.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 方式三
 *
 * {@link ConfigurationProperties}
 *
 * @author Ljj
 * @date 2020/6/5 10:37
 * @since 1.0
 */
@Configuration
public class TestThirdPartConfigurationPropertiesConfiguration {


    @ConfigurationProperties(prefix = "com.ljj.sourcecode.third.part")
    @Bean
    public TestThirdPartConfigurationProperties thirdPartConfigurationProperties(){

        return new TestThirdPartConfigurationProperties();
    }

}

