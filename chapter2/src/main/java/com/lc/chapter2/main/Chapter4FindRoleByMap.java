package com.lc.chapter2.main;

import com.lc.chapter2.mapper.RoleMapper;
import com.lc.chapter2.mapper.UserMapper;
import com.lc.chapter2.pojo.Role;
import com.lc.chapter2.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;

/**
 * 根据角色名称和备注来模糊查询角色.
 * { 多参数查询 }
 *
 * @author zyz.
 */
public class Chapter4FindRoleByMap {

    private static Logger logger = LogManager.getLogger(Chapter4FindRoleByMap.class.getName());

    public static void main(String[] args) {

        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtil.getSqlSession();
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            HashMap<String, String> paramsMap = new HashMap<>();
            paramsMap.put("roleName", "员");
            paramsMap.put("note", "权限");
            List<Role> roleList = mapper.findRoleByMap(paramsMap);
            logger.info("roleList = {}", roleList.toString());

            List<Role> roleByAnnotationList = mapper.findRoleByAnnotation("员", "权限");
            logger.info("roleByAnnotationList = {}", roleByAnnotationList.toString());

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
