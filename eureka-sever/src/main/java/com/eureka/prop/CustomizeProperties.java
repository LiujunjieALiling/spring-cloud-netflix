package com.eureka.prop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 *
 * @author Ljj
 * @date 2020/6/5 10:48
 * @since 1.0
 */
@Component
@Slf4j
public class CustomizeProperties{


    private final TestConfigurationPropertiesDemo customize1;

    private final TestConfigurationProperties2 customize2;

    @Autowired(required = false)
    private TestThirdPartConfigurationProperties thirdPartConfigurationProperties;

    @Autowired
    private Environment environment;


    public CustomizeProperties(@Autowired(required = false) TestConfigurationPropertiesDemo customize1,
                               @Autowired(required = false) TestConfigurationProperties2 customize2 ) {
        this.customize1 = customize1;
        this.customize2 = customize2;
    }

    @PostConstruct
    public void init(){

        log.info("通过 @EnableConfigurationProperties 获取自定义配置{}",customize1);
        log.info("通过 @ConfigurationPropertiesScan   获取自定义配置 {}",customize2);
        log.info("ThirdPart 自定义配置 :{}",thirdPartConfigurationProperties);

        log.info("Environment :{}",environment.getProperty("java"));

    }
}
