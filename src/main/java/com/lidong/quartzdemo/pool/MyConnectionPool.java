package com.lidong.quartzdemo.pool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;

/**
 * @author caolidong
 * @date 2022/1/12
 */
//@Component
public class MyConnectionPool extends GenericObjectPool<Connection> {

    public MyConnectionPool(MyPooledObjectFactory facroty, GenericObjectPoolConfig<Connection> config) {
        super(facroty, config);
    }

    @PostConstruct
    public void setFactory(){
        PooledObjectFactory<Connection> factory = getFactory();
        if(factory instanceof MyPooledObjectFactory){
            MyPooledObjectFactory myPooledObjectFactory = (MyPooledObjectFactory) factory;
            myPooledObjectFactory.setFactory(this);
        }

    }
}
