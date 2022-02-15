package com.lidong.quartzdemo.cache;

import org.apache.ibatis.cache.Cache;

/**
 * @author caolidong
 * @date 2022/1/26
 */
public class MyCache implements Cache{


    private final String id;

    public MyCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {

    }

    @Override
    public Object getObject(Object key) {
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }
}
