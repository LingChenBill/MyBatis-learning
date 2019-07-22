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
 * 插入后自动回填主键
 * { xml中配置useGeneratedKeys="true" keyProperty="id"，就可以插入后自动生成id进行回填。 }
 *
 * @author zyz.
 */
public class Chapter4InsertRole {

    private static Logger logger = LogManager.getLogger(Chapter4InsertRole.class.getName());

    public static void main(String[] args) {

        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtil.getSqlSession();
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);

            Role role = new Role();
            role.setRoleName("test4");
            role.setNote("test4Note");
            mapper.insertRole(role);

            // xml中配置useGeneratedKeys="true" keyProperty="id"，就可以插入后自动生成id进行回填。
            logger.info("role id = {}", role.getId());

            logger.info("执行成功!");

            sqlSession.commit();
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
