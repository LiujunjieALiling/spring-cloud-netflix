package com.eureka.archaius;

import org.apache.commons.configuration.*;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


/**
 * 测试 Apache Common  Configuration
 */
public class MyPropertyConfiguration {

    public static void main(String[] args) throws ConfigurationException {

        // 1. PropertiesConfiguration
        Configuration configuration = new PropertiesConfiguration("my.properties");

        System.out.println(configuration.getString("common.name", "ljj"));
        System.out.println(configuration.getString("common.age", "25"));
        System.out.println(configuration.getString("common.sex", "male"));
        System.out.println(configuration.getString("common.size", "18"));


        System.out.println("截取前缀之后");
        // 截取前缀
        Configuration subset = configuration.subset("common");

        subset.getKeys().forEachRemaining(s-> {

            System.out.println( s+ "=>" + subset.getString(s));

        });


        System.out.println("===== MapConfiguration =====");


        // 2. MapConfiguration
        Map<String,Object> map = new HashMap<>();
        map.put("map.count","First");
        map.put("map.configName","FIFO");

        Configuration mapConfiguration = new MapConfiguration(map);

        System.out.println(mapConfiguration.getString("map.count"));
        System.out.println(mapConfiguration.getString("map.configName"));


        // MapConfiguration 包装系统属性
        Configuration mapProperties = new MapConfiguration(System.getProperties());
        ConfigurationUtils.dump(mapProperties,System.out);

        System.out.println();
        System.out.println("===== MapConfiguration =====");

        // 截取前缀
        Configuration mapSub = mapConfiguration.subset("map");

        mapSub.getKeys().forEachRemaining(s->{

            System.out.println( s+ "=>" + mapSub.getString(s));
        });


        // 3. ConfigurationUtils
        URL url = ConfigurationUtils.locate("my.properties");
        System.out.println(url.toString());

    }
}

