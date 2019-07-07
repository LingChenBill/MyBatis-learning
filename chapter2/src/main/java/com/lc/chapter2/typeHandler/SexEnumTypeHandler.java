package com.lc.chapter2.typeHandler;

import com.lc.chapter2.enums.Sex;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Sex枚举自定义枚举处理器。
 *
 * @author zyz.
 */
public class SexEnumTypeHandler implements TypeHandler<Sex> {


    @Override
    public void setParameter(PreparedStatement ps, int index, Sex sex, JdbcType jdbcType) throws SQLException {
        ps.setInt(index, sex.getId());
    }

    @Override
    public Sex getResult(ResultSet rs, String columnName) throws SQLException {
        int id = rs.getInt(columnName);
        return Sex.getSex(id);
    }

    @Override
    public Sex getResult(ResultSet rs, int columnIndex) throws SQLException {
        int id = rs.getInt(columnIndex);
        return Sex.getSex(id);
    }

    @Override
    public Sex getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int id = cs.getInt(columnIndex);
        return Sex.getSex(id);
    }
}
