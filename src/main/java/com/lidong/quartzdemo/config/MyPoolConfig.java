package com.lidong.quartzdemo.config;

import com.lidong.quartzdemo.pool.MyConnectionPool;
import com.lidong.quartzdemo.pool.MyPooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.time.Duration;

/**
 * @author caolidong
 * @date 2022/1/12
 */
@Configuration
public class MyPoolConfig {

    @Autowired
    private MyPooledObjectFactory myPooledObjectFactory;

    @Autowired
    private GenericObjectPoolConfig config;
    @Bean
    public GenericObjectPoolConfig genericObjectPoolConfig(){
        GenericObjectPoolConfig<Connection> config = new GenericObjectPoolConfig<>();
        config.setMaxIdle(1);
        config.setMaxTotal(5);
        config.setMinEvictableIdleTime(Duration.ofMillis(30000));
        config.setTimeBetweenEvictionRuns(Duration.ofMillis(60000));
        config.setTestOnBorrow(true);
        return config;
    }
    @Bean
    public MyConnectionPool mysConnectionPool(){

        return new MyConnectionPool(myPooledObjectFactory,config);

    }
}
