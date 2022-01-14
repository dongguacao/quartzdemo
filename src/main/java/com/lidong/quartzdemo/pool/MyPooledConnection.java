package com.lidong.quartzdemo.pool;

import cn.hutool.db.ds.pooled.ConnectionWraper;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author caolidong
 * @date 2022/1/12
 */
public class MyPooledConnection extends ConnectionWraper{
    private MyConnectionPool myConnectionPool;
    private boolean closed = false;

    public MyPooledConnection(Connection raw,MyConnectionPool myConnectionPool)  {
        this.raw = raw;
        this.myConnectionPool = myConnectionPool;
    }

    @Override
    public void close() throws SQLException {
        myConnectionPool.returnObject(this);
    }

    @Override
    public boolean isClosed() throws SQLException {
        return closed;
    }
}
