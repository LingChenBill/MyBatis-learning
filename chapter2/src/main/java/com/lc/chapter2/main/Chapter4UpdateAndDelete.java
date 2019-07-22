package com.lc.chapter2.main;

import com.lc.chapter2.mapper.RoleMapper;
import com.lc.chapter2.pojo.Role;
import com.lc.chapter2.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 更新与删除。
 *
 * @author zyz.
 */
public class Chapter4UpdateAndDelete {

    private static Logger logger = LogManager.getLogger(Chapter4UpdateAndDelete.class.getName());

    public static void main(String[] args) {

        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtil.getSqlSession();
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);

            // 删除。
            Role role = new Role();
            role.setId(32l);
            role.setRoleName("test6");
            role.setNote("test6Note");
            mapper.updateRole(role);

            mapper.deleteRole(28l);

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
