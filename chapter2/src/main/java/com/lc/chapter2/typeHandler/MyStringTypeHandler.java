package com.lc.chapter2.typeHandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  MyStringTypeHandler自定义类型转换器。
 */
@MappedTypes({String.class})
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyStringTypeHandler implements TypeHandler<String> {

    private static Logger logger = LogManager.getLogger(MyStringTypeHandler.class.getName());


    @Override
    public void setParameter(PreparedStatement preparedStatement, int index, String value, JdbcType jdbcType) throws SQLException {
        logger.info("使用我的TypeHandler");
        preparedStatement.setString(index, value);
    }

    @Override
    public String getResult(ResultSet resultSet, String colName) throws SQLException {
        logger.info("使用我的TypeHandler, ResultSet 列名获取字符串");
        return resultSet.getString(colName);
    }

    @Override
    public String getResult(ResultSet resultSet, int index) throws SQLException {

        logger.info("使用我的TypeHandler, ResultSet 下标获取字符串");

        return resultSet.getString(index);
    }

    @Override
    public String getResult(CallableStatement callableStatement, int index) throws SQLException {

        logger.info("使用我的TypeHandler, CallableStatement 下标获取字符串");

        return callableStatement.getString(index);
    }
}
