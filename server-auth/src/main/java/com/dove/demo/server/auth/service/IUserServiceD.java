//package com.dove.demo.server.auth.service;
//
//import com.dove.demo.bgd.a.model.FbPermission;
//import com.dove.demo.bgd.a.model.Role;
//import com.dove.demo.bgd.a.model.FbUser;
//import com.dove.demo.server.a.dto.UserDto;
//import com.dove.demo.server.a.dto.UserQueryParam;
//
//import java.util.List;
//
///**
// * @Description:
// * @Auther: qingruizhu
// * @Date: 2020/7/27 23:10
// */
//public interface IUserServiceD {
//    int insert(UserDto dto);
//
//    int update(UserDto dto);
//
//    /**
//     * 模糊查询用户
//     */
//    List<FbUser> list(UserQueryParam param);
//
//    List<Role> getRoleList(String userIdStr);
//
//    int updateRole(String userIdStr, List<Long> roleIds);
//
//    List<FbPermission> getPermissionList(String userIdStr);
//
//}
