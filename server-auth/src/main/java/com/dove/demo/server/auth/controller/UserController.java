//package com.dove.demo.server.auth.controller;
//
//import com.dove.book.bgd.page.CommonPage;
//import com.dove.common.base.annotation.CommonResultAnnon;
//import com.dove.common.base.validate.QueryGroup;
//import com.dove.demo.bgd.a.model.FbUser;
//import com.dove.demo.bgd.a.model.Role;
//import com.dove.demo.bgd.a.service.IFbUserService;
//import com.dove.demo.server.a.dto.UserDto;
//import com.dove.demo.server.a.dto.UserQueryParam;
//import com.dove.demo.server.a.service.IUserServiceD;
//import com.dove.demo.server.frisbee.exception.FrisbeeException;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.apache.commons.collections.CollectionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Api(description = "【用户信息】", tags = "☻ FbUser")
//@RestController
//@CommonResultAnnon
//@RequestMapping("/user")
//public class UserController {
//
//    @Autowired
//    private IFbUserService<UserDto> service;
//    @Autowired
//    private IUserServiceD serviceD;
//
//    @ApiOperation("用户列表")
//    @RequestMapping(value = "/list", method = RequestMethod.POST)
//    public CommonPage<FbUser> list(@RequestBody UserQueryParam param) {
//        List<FbUser> users = serviceD.list(param);
//        if (CollectionUtils.isNotEmpty(users)) {
//            users.forEach(user -> {
//                user.setPassword(null);
//            });
//        }
//        return CommonPage.restPage(users);
//    }
//
//    @ApiOperation("用户信息")
//    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
//    public FbUser list(@PathVariable Long id) {
//        FbUser user = service.select(id);
//        if (null != user) {
//            user.setPassword(null);
//        }
//        return user;
//    }
//
//    @ApiOperation("创建用户")
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public void create(@RequestBody @Validated({QueryGroup.Insert.class}) UserDto dto) {
//        if (serviceD.insert(dto) <= 0) {
//            throw new FrisbeeException(FrisbeeErrorEnum.USER_ERROR_CREATE);
//        }
//    }
//
//    @ApiOperation("修改用户信息")
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public void update(@RequestBody @Validated({QueryGroup.Update.class}) UserDto dto) {
//        if (serviceD.update(dto) <= 0) {
//            throw new FrisbeeException(FrisbeeErrorEnum.USER_ERROR_UPDATE);
//        }
//    }
//
//    @ApiOperation("删除用户")
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public void updateRole(
//            @PathVariable("id") Long id) {
//        if (service.delete(id) <= 0) {
//            throw new FrisbeeException(FrisbeeErrorEnum.USER_ERROR_DEL);
//        }
//    }
//
//    @ApiOperation("获取指定用户的角色")
//    @RequestMapping(value = "/role/list", method = RequestMethod.GET)
//    @ResponseBody
//    public List<Role> roles(@RequestParam String userIdStr) {
//        List<Role> roles = serviceD.getRoleList(userIdStr);
//        return roles;
//    }
//
//    @ApiOperation("给用户分配角色")
//    @RequestMapping(value = "/role/update", method = RequestMethod.GET)
//    @ResponseBody
//    public void updateRole(
//            @RequestParam("userId") String userIdStr,
//            @RequestParam("roleIds") List<Long> roleIds) {
//        int count = serviceD.updateRole(userIdStr, roleIds);
//        if (count < 0) {
//            throw new FrisbeeException(FrisbeeErrorEnum.USER_ERROR_ROLE_UPDATE);
//        }
//    }
//
//}
