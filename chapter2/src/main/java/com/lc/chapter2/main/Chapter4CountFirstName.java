package com.lc.chapter2.main;

import com.lc.chapter2.mapper.RoleMapper;
import com.lc.chapter2.mapper.UserMapper;
import com.lc.chapter2.pojo.Role;
import com.lc.chapter2.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 统计一个姓氏的用户数量.
 *
 * @author  zyz.
 */
public class Chapter4CountFirstName {

    private static Logger logger = LogManager.getLogger(Chapter4CountFirstName.class.getName());

    public static void main(String[] args) {

        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int count = userMapper.countFirstName("z");
            logger.info("z user numbers: {}", count);

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
