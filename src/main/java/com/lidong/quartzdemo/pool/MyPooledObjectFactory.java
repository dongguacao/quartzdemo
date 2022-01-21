package com.lidong.quartzdemo.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.DestroyMode;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author caolidong
 * @date 2022/1/12
 */
@Component
public class MyPooledObjectFactory extends BasePooledObjectFactory<Connection>{

    private MyConnectionPool myConnectionPool;
    @Override
    public Connection create() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&serverTimezone=UTC",
                "root","123456");
        MyPooledConnection myPooledConnection = new MyPooledConnection(connection, myConnectionPool);
        return myPooledConnection;
    }

    @Override
    public PooledObject<Connection> wrap(Connection connection) {
        return new DefaultPooledObject<>(connection);
    }

    public void setFactory(MyConnectionPool myConnectionPool){
        this.myConnectionPool = myConnectionPool;
    }

    @Override
    public void destroyObject(PooledObject<Connection> p) throws Exception {
        super.destroyObject(p);
    }

    @Override
    public boolean validateObject(PooledObject<Connection> p) {
        try {
             p.getObject().createStatement().execute("select 1");
             return true;
        } catch (SQLException e) {
//            try {
//                myConnectionPool.invalidateObject(p.getObject());
//            } catch (Exception e1) {
//                System.out.println("销毁失败");
//            }
            return false;
        }
    }
}
