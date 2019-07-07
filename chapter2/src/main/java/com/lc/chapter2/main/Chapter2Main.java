package com.lc.chapter2.main;

import com.lc.chapter2.mapper.RoleMapper;
import com.lc.chapter2.pojo.Role;
import com.lc.chapter2.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 实例类入口.
 *
 * @author  zyz.
 */
public class Chapter2Main {

    private static Logger logger = LogManager.getLogger(Chapter2Main.class.getName());

    public static void main(String[] args) {

        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtil.getSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setRoleName("部门员工");
            role.setNote("员工权限");

            roleMapper.insertRole(role);

            Role selectRole = roleMapper.getRole(1l);

            logger.info("执行成功!  selectRole = {}", selectRole.toString());

            Role findRole = roleMapper.findRole("管理员");
            logger.info("执行成功! findRole = {}", findRole.toString());

            roleMapper.deleteRole(3l);

            sqlSession.commit();
        } catch (Exception e) {
            logger.info("执行失败!", e);
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

        logger.info("执行成功!");

    }

}
