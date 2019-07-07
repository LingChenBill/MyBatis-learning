package com.lc.chapter2.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SqlSessionFactory 生成工具类。
 *
 * @author zyz.
 */
public class SqlSessionFactoryUtil {

//    private static Logger logger = LogManager.getLogger(SqlSessionFactoryUtil.class.getName());

    // 类线程锁。
    private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;

    // sqlSessionFactory对象。
    private static SqlSessionFactory sqlSessionFactory = null;

    /**
     * 私有化构造参数。
     * { 避免使用者使用new的方式去创建多个对象。 }
     */
    private SqlSessionFactoryUtil () {}

    /**
     * 构建SqlSessionFactory.
     *
     * @return
     */
    private static SqlSessionFactory getInstance() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            Logger.getLogger(SqlSessionFactoryUtil.class.getName()).log(Level.SEVERE, null, e);
        }

        // 使用synchronized对SqlSessionFactoryUtil类加锁，
        // 避免在多线程环境中，多次初始化造成对象的不唯一。
        synchronized (CLASS_LOCK) {
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }

        return sqlSessionFactory;
    }

    /**
     * 获取SqlSession。
     *
     * @return
     */
    public static SqlSession getSqlSession() {
        if (sqlSessionFactory == null) {
            getInstance();
        }

        return sqlSessionFactory.openSession();
    }
}
