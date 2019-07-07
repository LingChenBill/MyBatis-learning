package com.lc.chapter2.mapper;

import com.lc.chapter2.pojo.User;

/**
 * configuration.addMapper(UserMapper.class)
 * 注册当前接口为映射器.
 */
public interface UserMapper {

    public User getUser(Long id);

    public int insertUser(User user);

}