package com.learn.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.security.entity.UmsPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author：江文谱
 * @date： 2020/5/4 10:46
 * @version： 1.0
 */
@Mapper
public interface UmsAdminRoleRelationDao extends BaseMapper<UmsPermission> {

    /**
     * 获取用户所有权限(包括+-权限)
     */
    @Select("SELECT\n" +
            "            p.*\n" +
            "        FROM\n" +
            "            ums_admin_role_relation ar\n" +
            "            LEFT JOIN ums_role r ON ar.role_id = r.id\n" +
            "            LEFT JOIN ums_role_permission_relation rp ON r.id = rp.role_id\n" +
            "            LEFT JOIN ums_permission p ON rp.permission_id = p.id\n" +
            "        WHERE\n" +
            "            ar.admin_id = #{adminId}\n" +
            "            AND p.id IS NOT NULL\n" +
            "            AND p.id NOT IN (\n" +
            "                SELECT\n" +
            "                    p.id\n" +
            "                FROM\n" +
            "                    ums_admin_permission_relation pr\n" +
            "                    LEFT JOIN ums_permission p ON pr.permission_id = p.id\n" +
            "                WHERE\n" +
            "                    pr.type = - 1\n" +
            "                    AND pr.admin_id = #{adminId}\n" +
            "            )\n" +
            "        UNION\n" +
            "        SELECT\n" +
            "            p.*\n" +
            "        FROM\n" +
            "            ums_admin_permission_relation pr\n" +
            "            LEFT JOIN ums_permission p ON pr.permission_id = p.id\n" +
            "        WHERE\n" +
            "            pr.type = 1\n" +
            "            AND pr.admin_id = #{adminId}")
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
