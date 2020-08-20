package com.eureka.shardingsphere;

import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.MasterSlaveDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * {@link ShardingRuleConfiguration}
 *
 * @author Ljj
 * @date 2020/6/12 17:28
 * @since 1.0
 */
public class ShardingRuleConfigurationTest {

    public static void main(String[] args) {

        ShardingRuleConfiguration shardingRuleConfiguration = new ShardingRuleConfiguration();

        // 配置分库分表
        shardingRuleConfiguration.getTableRuleConfigs().add(getOrderRuleConfiguration());
        shardingRuleConfiguration.getBindingTableGroups().add("t_order");

        // 数据库分片规则: user_id 取模
        shardingRuleConfiguration.setDefaultDatabaseShardingStrategyConfig(
                new InlineShardingStrategyConfiguration("user_id","ds${user_id % 2}")
        );

        // 表分配规则:
        shardingRuleConfiguration.setDefaultTableShardingStrategyConfig(
                new StandardShardingStrategyConfiguration("order_id",null)
        );

        // 创建SHardingDataSource
//        ShardingDataSourceFactory.createDataSource()

    }


    private static TableRuleConfiguration getOrderRuleConfiguration(){

        // 表: t_order_0、t_order_1 ;  数据库: ds0、ds1;
        TableRuleConfiguration rule = new TableRuleConfiguration("t_order","ds${0..1}.t_order${0..1}");
        rule.setKeyGeneratorConfig(generateKey());
        return rule;
    }

    // 主键order_id 生成策略: 雪花算法
    private static KeyGeneratorConfiguration generateKey(){

        return new KeyGeneratorConfiguration("SNOWFLAKE","order_id");
    }


}
