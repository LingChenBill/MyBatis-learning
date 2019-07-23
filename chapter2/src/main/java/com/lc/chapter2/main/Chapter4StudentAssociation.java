package com.lc.chapter2.main;

import com.lc.chapter2.mapper.RoleMapper;
import com.lc.chapter2.mapper.StudentMapper;
import com.lc.chapter2.pojo.Role;
import com.lc.chapter2.pojo.Student;
import com.lc.chapter2.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 一对一对应级联.
 * { <association property="studentSeflCard" column="id"
 *                select="com.lc.chapter2.mapper.StudentSelfCardMapper.findStuentSelfCardByStudentId"/> }
 *
 * @author zyz.
 */
public class Chapter4StudentAssociation {

    private static Logger logger = LogManager.getLogger(Chapter4StudentAssociation.class.getName());

    public static void main(String[] args) {

        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtil.getSqlSession();

            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = studentMapper.getStudent(1);


            logger.info("student = {}", student.toString());
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
