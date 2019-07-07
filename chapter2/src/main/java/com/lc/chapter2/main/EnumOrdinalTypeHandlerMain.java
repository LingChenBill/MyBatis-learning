package com.lc.chapter2.main;

import com.lc.chapter2.enums.Sex;
import com.lc.chapter2.mapper.UserMapper;
import com.lc.chapter2.pojo.User;
import com.lc.chapter2.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

/**
 * 测试Sex枚举类型的自定义类型处理器。
 *
 * @author zyz.
 *
 */
public class EnumOrdinalTypeHandlerMain {

    private static Logger logger = LogManager.getLogger(EnumOrdinalTypeHandlerMain.class.getName());

    public static void main(String[] args) {

        SqlSession sqlSession = null;

        try {

            sqlSession = SqlSessionFactoryUtil.getSqlSession();

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            User user = new User();
            user.setUserName("zhangsan");
            user.setCnname("张三");
            user.setMobile("18888888888");
            user.setSex(Sex.FEMALE);
            user.setEmail("zhangsan@126.com");
            user.setNote("test EnumOrdinalTypeHandler");
//            user.setBirthday(new Date());

            userMapper.insertUser(user);

            User selectUser = userMapper.getUser(2l);

            logger.info("查询User成功 selectUser = {}", selectUser.toString());

            sqlSession.commit();


        } catch (Exception e) {
            logger.info("User 插入查询失败，error = {}", e.getCause());
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }


}
