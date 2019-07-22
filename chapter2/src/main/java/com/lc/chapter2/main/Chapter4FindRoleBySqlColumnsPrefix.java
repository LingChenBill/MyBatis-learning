package com.lc.chapter2.main;

import com.lc.chapter2.mapper.RoleMapper;
import com.lc.chapter2.params.RoleParam;
import com.lc.chapter2.pojo.Role;
import com.lc.chapter2.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * sql元素，制定参数
 * { <include refid="role_columns_prefix">
 *     <property name="prefix" value="r"/>
 *   </include>
 *  说明：sql元素定义中，${}而不是#{}
 *  ${prefix}.id, ${prefix}.role_name, ${prefix}.note }
 *
 * @author zyz.
 */
public class Chapter4FindRoleBySqlColumnsPrefix {

    private static Logger logger = LogManager.getLogger(Chapter4FindRoleBySqlColumnsPrefix.class.getName());

    public static void main(String[] args) {

        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtil.getSqlSession();
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            Role rolesBySqlColumnsPrefix = mapper.findRolesBySqlColumnsPrefix(32l);

            logger.info("rolesBySqlColumnsPrefix = {}", rolesBySqlColumnsPrefix.toString());
            logger.info("执行成功!");

        } catch (Exception e) {
            logger.info("执行失败!", e);
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }


    }

}
