package com.lc.chapter2.main;

import com.lc.chapter2.mapper.RoleMapper;
import com.lc.chapter2.params.RoleParam;
import com.lc.chapter2.pojo.Role;
import com.lc.chapter2.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;

/**
 * 参数Bean传参查询:根据角色名称和备注来模糊查询角色.
 * { 多参数查询 }
 *
 * @author zyz.
 */
public class Chapter4FindRoleByParams {

    private static Logger logger = LogManager.getLogger(Chapter4FindRoleByParams.class.getName());

    public static void main(String[] args) {

        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtil.getSqlSession();
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            RoleParam params = new RoleParam();
            params.setRoleName("员");
            params.setNote("权限");
            List<Role> roleByParams = mapper.findRoleByParams(params);
            logger.info("roleByParams = {}", roleByParams.toString());
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
