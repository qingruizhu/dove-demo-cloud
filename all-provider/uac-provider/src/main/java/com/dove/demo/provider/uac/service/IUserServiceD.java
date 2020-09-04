//package com.dove.demo.provider.uac.service;
//
//import com.dove.demo.bgd.uac.model.Permission;
//import com.dove.demo.bgd.uac.model.Role;
//import com.dove.demo.bgd.uac.model.User;
//import com.dove.demo.provider.api.uac.dto.UserDto;
//import com.dove.demo.provider.uac.dto.UserQueryParam;
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
//    List<User> list(UserQueryParam param);
//
//    List<Role> getRoleList(String userIdStr);
//
//    int updateRole(String userIdStr, List<Long> roleIds);
//
//    List<Permission> getPermissionList(String userIdStr);
//
//}
