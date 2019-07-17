package com.lc.chapter2.mapper;

import com.lc.chapter2.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * configuration.addMapper(RoleMapper2.class)
 * 注册当前接口为映射器.
 *
 * @author zyz.
 */
public interface RoleMapper {

    // 按id查询。
    Role getRole(Long id);

    // 按角色名查询。
    Role findRole(String roleName);

    // 按id删除。
    int deleteRole(Long id);

    // 插入角色。
    int insertRole(Role role);

    // 按角色名称和备注模糊查询。
    List<Role> findRoleByMap(Map<String, String> params);

    // 注解查询：按角色名称和备注模糊查询。
    List<Role> findRoleByAnnotation(@Param("roleName") String roleName, @Param("note") String note);

}