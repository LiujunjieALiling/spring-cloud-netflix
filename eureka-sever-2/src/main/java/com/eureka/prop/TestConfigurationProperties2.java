package com.eureka.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * {@link ConfigurationProperties}
 *
 * @author Ljj
 * @date 2020/6/5 10:37
 * @since 1.0
 */
@Data
@ConfigurationProperties(prefix = "spring.cloud.refresh")
public class TestConfigurationProperties2 {

    private boolean enabled = true;

    private String ip;

    private int port;


    public String toString(){

        return "[ Ip:"+ip+", Port:"+port+"Enabled:"+enabled+"]";
    }
}

