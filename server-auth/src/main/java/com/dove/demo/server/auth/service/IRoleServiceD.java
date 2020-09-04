//package com.dove.demo.server.auth.service;
//
//import com.dove.demo.bgd.a.model.FbPermission;
//import com.dove.demo.server.a.node.RolePermissionNode;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * @Description:
// * @Author qingruizhu
// * @Date 8:04 下午 2020/7/23
// **/
//public interface IRoleServiceD {
//    /**
//     * 批量删除角色
//     */
//    int delete(List<Long> ids);
//
//    List<FbPermission> getPermissionList(Long roleId);
//
//    /**
//     * 修改指定角色的权限
//     */
//    @Transactional
//    int updatePermission(Long roleId, List<Long> permissionIds);
//
//    /**
//     * 高亮->角色所拥有的权限
//     */
//    List<RolePermissionNode> lightPermissionList(@Param("roleId") Long roleId);
//
//}
