package com.lc.chapter2.mapper;

import com.lc.chapter2.pojo.User;

/**
 * configuration.addMapper(UserMapper.class)
 * 注册当前接口为映射器.
 *
 * @author zyz.
 */
public interface UserMapper {

    // 按id查询用户。
    public User getUser(Long id);

    // 插入用户。
    public int insertUser(User user);

    // 统计一个姓氏的用户数量。
    public int countFirstName(String firstName);

}