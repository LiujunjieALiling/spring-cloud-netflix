package com.eureka.mybatis;

/**
 * @author Ljj
 * @date 2020/4/26 17:01
 * @since 1.0
 */
public interface UserMapper {


    User selectUserByUserId(Integer integer);
}
