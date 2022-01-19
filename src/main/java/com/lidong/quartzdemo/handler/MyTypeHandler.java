package com.lidong.quartzdemo.handler;

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
@MappedJdbcTypes(JdbcType.CHAR)
@MappedTypes(String.class)
public class MyTypeHandler extends BaseTypeHandler<String> {
    Logger log = LoggerFactory.getLogger(MyTypeHandler.class);
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i,parameter);
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String string = rs.getString(columnName);
        log.info("1:" + string);
        return string;
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String string = rs.getString(columnIndex);
        log.info("2:" + string);
        return string;
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String string = cs.getString(columnIndex);
        log.info("3:" + string);
        return string;
    }
}
