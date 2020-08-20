package com.eureka.learn;

import com.google.common.cache.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Guava CacheBuilder
 *
 * {@link CacheBuilder}
 *
 * @author Ljj
 * @date 2020/6/16 15:16
 * @since 1.0
 */
public class CacheBuilderTest {

    static final ConcurrentMap<String,String> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) throws ExecutionException {


        LoadingCache<String, ConcurrentMap<String,String>> readWriteCacheMap = CacheBuilder.newBuilder()
                .initialCapacity(1000)
                .expireAfterWrite(2000, TimeUnit.MILLISECONDS)
                .removalListener(new RemovalListener<String, ConcurrentMap<String,String>>() {

                    @Override
                    public void onRemoval(RemovalNotification<String, ConcurrentMap<String, String>> notification) {



                    }
                }).build(new CacheLoader<String, ConcurrentMap<String, String>>() {
                    @Override
                    public ConcurrentMap<String, String> load(String key) throws Exception {

                        ConcurrentMap map= new ConcurrentHashMap<>();
                        map.put(key,key);
                        return map;
                    }
                });

        readWriteCacheMap.get("1").forEach((key, value) -> System.out.println("key:" + key + ";value: " + value));



        CacheBuilder.from("maximumSize=10000,expireAfterWrite=10m")
                .expireAfterWrite(2000,TimeUnit.MILLISECONDS)
                .removalListener(new RemovalListener<String, ConcurrentMap<String,String>>() {

                    @Override
                    public void onRemoval(RemovalNotification<String, ConcurrentMap<String, String>> notification) {



                    }
                }).build(new CacheLoader<String, ConcurrentMap<String, String>>() {
            @Override
            public ConcurrentMap<String, String> load(String key) throws Exception {


                return null;
            }
        });
    }
}
