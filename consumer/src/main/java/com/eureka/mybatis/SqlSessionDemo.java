package com.eureka.mybatis;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

/**
 * SqlSession
 * @author Ljj
 * @date 2020/4/26 16:58
 * @since 1.0
 */
public class SqlSessionDemo {


    public static void main(String[] args) {



        SqlSessionFactory  sqlSessionFactory = new DefaultSqlSessionFactory(new Configuration());

        SqlSession sqlSession = sqlSessionFactory.openSession();

        String statement = "one.to.one.mapper.OrdersMapper.selectOrderAndUserByOrderID";

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //第一次查询，发出sql语句，并将查询的结果放入缓存中
        User u1 = userMapper.selectUserByUserId(1);


    }


}
