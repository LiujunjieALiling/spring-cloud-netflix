package com.eureka.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * {@link org.springframework.boot.context.properties.ConfigurationProperties}
 *
 * @author Ljj
 * @date 2020/6/5 10:37
 * @since 1.0
 */

@ConfigurationProperties(prefix = "com.ljj.sourcecode.demo")
@Data
public class TestConfigurationPropertiesDemo {

//    @ConstructorBinding
//    public TestConfigurationPropertiesDemo(boolean enabled, String ip, int port){
//        this.enabled = enabled;
//        this.ip = ip;
//        this.port = port;
//    }


    private boolean enabled = true;

    private String ip;

    private int port;


    public String toString(){

        return "[ Ip:"+ip+", Port:"+port+",Enabled:"+enabled+"]";
    }
}

