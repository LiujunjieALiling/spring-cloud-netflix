package com.eureka.prop;

import lombok.Data;

/**
 * {@link TestThirdPartConfigurationPropertiesConfiguration}
 *
 * @author Ljj
 * @date 2020/6/5 10:37
 * @since 1.0
 */
@Data
public class TestThirdPartConfigurationProperties {


    private boolean enabled = true;


    private String ip;

    private int port;


    public String toString(){

        return "[ Ip:"+ip+", Port:"+port+"Enabled:"+enabled+"]";
    }
}

