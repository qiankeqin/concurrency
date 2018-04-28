package com.ximua.concurrency.example.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Configuration
public class RedisConfig {

    @Bean(name="redisPool")
    public JedisPool jedisPool(@Value("${jedis.host}") String host,@Value("${jedis.port}") Integer port){
        return new JedisPool(host,port);
    }



}
