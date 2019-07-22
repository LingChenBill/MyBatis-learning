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
 * sql元素，查询条件引入。
 * { <include refid="role_columns"/>
 *   对于多种字段在不同的sql查询语句中都会出现时，可以通过sql元素来定义，
 *   在不同的sql查询语句中，直接引用即可。}
 *
 * @author zyz.
 */
public class Chapter4FindRoleBySqlColumns {

    private static Logger logger = LogManager.getLogger(Chapter4FindRoleBySqlColumns.class.getName());

    public static void main(String[] args) {

        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtil.getSqlSession();
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            RoleParam params = new RoleParam();
            params.setRoleName("员");
            params.setNote("权限");
            List<Role> rolesBySqlColumns = mapper.findRolesBySqlColumns("test", "test");

            logger.info("rolesBySqlColumns = {}", rolesBySqlColumns.toString());
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
