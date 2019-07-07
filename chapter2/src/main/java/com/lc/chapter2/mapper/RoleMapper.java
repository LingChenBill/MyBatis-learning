package com.lc.chapter2.mapper;

import com.lc.chapter2.pojo.Role;

/**
 * configuration.addMapper(RoleMapper2.class)
 * 注册当前接口为映射器.
 */
public interface RoleMapper {
    Role getRole(Long id);

    Role findRole(String roleName);

    int deleteRole(Long id);

    int insertRole(Role role);
}