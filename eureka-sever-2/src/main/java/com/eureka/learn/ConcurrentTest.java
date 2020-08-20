package com.eureka.learn;

import lombok.Data;

/**
 * @author Ljj
 * @date 2020/6/21 17:30
 * @since 1.0
 */
public class ConcurrentTest {

    public static void main(String[] args) {




        for (int i = 0; i<10; i++){

            new Thread(()->{

            },"线程"+i).start();

        }
    }

}

@Data
class ShareObject{



}
