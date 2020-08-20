package com.eureka.archaius;

import com.netflix.config.*;
import org.apache.commons.configuration.AbstractConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * 测试 Archaius
 *
 * @author Ljj
 * @date 2020/4/20 23:18
 * @since 1.0
 */
@SpringBootTest
public class ArchaiusTest {

    @Test
    public void test1() throws InterruptedException {

        DynamicIntProperty myAge = DynamicPropertyFactory.getInstance().getIntProperty("my.age", 18);
        System.out.println(myAge);
        System.out.println(myAge.get());


        TimeUnit.SECONDS.sleep(80);

        System.out.println("动态修改后的值为：");
        System.out.println(myAge);
        System.out.println(myAge.get());


        // 添加自定义组件
        DynamicConfiguration dynamicConfig = new DynamicConfiguration(new MyDynamicProperty(),new MySchedule());
        // 安装进配置管理器
        ConfigurationManager.install(dynamicConfig);

        MyConfiguration myConfiguration = new MyConfiguration();

        // 组合配置
        ConcurrentCompositeConfiguration finalConfig = new ConcurrentCompositeConfiguration();

        finalConfig.addConfiguration(dynamicConfig, "dynamicConfig");
        finalConfig.addConfiguration(myConfiguration, "systemConfig");

        // register with DynamicPropertyFactory so that finalConfig
        // becomes the source of dynamic properties
        DynamicPropertyFactory.initWithConfigurationSource(finalConfig);
    }

}
// 自定义动态配置属性
class MyDynamicProperty implements PolledConfigurationSource {
    @Override
    public PollResult poll(boolean initial, Object checkPoint) throws Exception {


        return null;
    }
}

// 自定义定时触发器
class MySchedule extends AbstractPollingScheduler  {


    @Override
    protected void schedule(Runnable pollingRunnable) {

    }

    @Override
    public void stop() {

    }
}

// 自定义Configuration
class MyConfiguration extends AbstractConfiguration {
    @Override
    protected void addPropertyDirect(String key, Object value) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(String key) {
        return false;
    }

    @Override
    public Object getProperty(String key) {
        return null;
    }

    @Override
    public Iterator<String> getKeys() {
        return null;
    }
}