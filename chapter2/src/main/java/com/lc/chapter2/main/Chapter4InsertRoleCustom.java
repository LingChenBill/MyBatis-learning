package com.lc.chapter2.main;

import com.lc.chapter2.mapper.RoleMapper;
import com.lc.chapter2.pojo.Role;
import com.lc.chapter2.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 自定义主键，插入后自动回填主键
 * { <selectKey></selectKey>配置。
 *   若t_role表中没有记录，则设置id为1，否则取最大id+2，来设置新的主键id
 *   select if(max(id) is null, 1, max(id) + 2) as newId from t_role
 *   注意：自定义的时候，id也要作为插入项写进sql
 *   insert into t_role(id, role_name,note) values(#{id}, #{roleName},#{note})
 *   }
 *
 * @author zyz.
 */
public class Chapter4InsertRoleCustom {

    private static Logger logger = LogManager.getLogger(Chapter4InsertRoleCustom.class.getName());

    public static void main(String[] args) {

        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtil.getSqlSession();
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);

            Role role = new Role();
            role.setRoleName("test5");
            role.setNote("test5Note");
            mapper.insetRoleCustom(role);

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
