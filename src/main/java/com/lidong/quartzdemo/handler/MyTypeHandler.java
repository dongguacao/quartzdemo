package com.lidong.quartzdemo.handler;

import com.lidong.quartzdemo.bo.Order;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author caolidong
 * @date 2022/1/18
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(Order.class)
public class MyTypeHandler extends BaseTypeHandler<Order> {
    Logger log = LoggerFactory.getLogger(MyTypeHandler.class);

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Order parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i,parameter.getId());
    }

    @Override
    public Order getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String string = rs.getString(columnName);
        String[] split = string.split(",");
        Order order = new Order();
        order.setName(split[0]);
        return order;
    }

    @Override
    public Order getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String string = rs.getString(columnIndex);
        String[] split = string.split(",");
        Order order = new Order();
        order.setName(split[0]);
        return order;
    }

    @Override
    public Order getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String string = cs.getString(columnIndex);
        String[] split = string.split(",");
        Order order = new Order();
        order.setName(split[0]);
        return order;
    }
//    @Override
//    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
//        ps.setString(i,parameter);
//    }
//
//    @Override
//    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
//        String string = rs.getString(columnName);
//        log.info("1:" + string);
//        return string;
//    }
//
//    @Override
//    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
//        String string = rs.getString(columnIndex);
//        log.info("2:" + string);
//        return string;
//    }
//
//    @Override
//    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
//        String string = cs.getString(columnIndex);
//        log.info("3:" + string);
//        return string;
//    }
}
