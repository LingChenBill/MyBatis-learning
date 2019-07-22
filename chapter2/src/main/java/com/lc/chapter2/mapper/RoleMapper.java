package com.lc.chapter2.mapper;

import com.lc.chapter2.params.RoleParam;
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

    // sql元素定义查询。
    List<Role> findRolesBySqlColumns(@Param("roleName") String roleName, @Param("note") String note);

    // sql元素，制定参数来进行查询。
    Role findRolesBySqlColumnsPrefix(Long id);

    // 更新
    int updateRole(Role role);

    // 按id删除。
    int deleteRole(Long id);

    // 插入角色。
    int insertRole(Role role);

    // 自定义主键插入。
    int insetRoleCustom(Role role);

    // 按角色名称和备注模糊查询。
    List<Role> findRoleByMap(Map<String, String> params);

    // 注解查询：按角色名称和备注模糊查询。
    List<Role> findRoleByAnnotation(@Param("roleName") String roleName, @Param("note") String note);

    // 参数Bean查询：按角色名称和备注模糊查询。
    List<Role> findRoleByParams(RoleParam params);

}