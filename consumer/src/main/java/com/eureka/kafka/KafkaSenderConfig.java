package com.eureka.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * kafka相关配置
 *
 * @author Ljj
 * @date 2020/4/23 16:46
 * @since 1.0
 */
//@Configuration
public class KafkaSenderConfig {


    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;


    @Bean
    public Map<String,Object> producerConfigs(){

        Map<String,Object>  config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);

        return config;
    }



}
