//package com.dove.demo.server.auth.controller;
//
//import com.dove.book.bgd.page.CommonPage;
//import com.dove.common.base.annotation.CommonResultAnnon;
//import com.dove.common.base.validate.QueryGroup;
//import com.dove.common.util.data.TreeNodeUtil;
//import com.dove.demo.server.a.dto.RoleDto;
//import com.dove.demo.server.a.node.RolePermissionNode;
//import com.dove.demo.server.a.service.IRoleServiceD;
//import com.github.pagehelper.PageHelper;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * @Description:
// * @Author qingruizhu
// * @Date 10:07 上午 2020/7/28
// **/
//
//@Api(description = "【角色信息】", tags = "☻ Role")
//@RestController
//@CommonResultAnnon
//@RequestMapping("/role")
//public class RoleController {
//    @Autowired
//    private IRoleService<RoleDto> service;
//    @Autowired
//    private IRoleServiceD serviceD;
//
//
//    @ApiOperation("获取所有角色")
//    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
//    @ResponseBody
//    public List<Role> listAll() {
//        List<Role> roleList = service.list(new Role());
//        return roleList;
//    }
//
//    @ApiOperation("分页获取角色列表")
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonPage<Role> list(
//            @RequestParam(value = "roleName", required = false) String roleName,
//            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
//            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
//        PageHelper.startPage(pageNum, pageSize);
//        Role role = new Role();
//        role.setName(roleName);
//        List<Role> roleList = service.list(role);
//        return CommonPage.restPage(roleList);
//    }
//
//
//    @ApiOperation("添加角色")
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    @ResponseBody
//    public void create(@RequestBody RoleDto role) {
//        if (service.insertQ(role) <= 0) {
//            throw new FrisbeeException(FrisbeeErrorEnum.ROLE_ERROR_CREATE);
//        }
//    }
//
//    @ApiOperation("修改角色")
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    @ResponseBody
//    public void update(@RequestBody @Validated(QueryGroup.Update.class) RoleDto dto) {
//        if (service.updateQ(dto) <= 0) {
//            throw new FrisbeeException(FrisbeeErrorEnum.ROLE_ERROR_UPDATE);
//        }
//    }
//
//    @ApiOperation("删除角色")
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public void delete(@PathVariable("id") Long id) {
//        if (service.delete(id) <= 0) {
//            throw new FrisbeeException(FrisbeeErrorEnum.ROLE_ERROR_DEL);
//        }
//    }
//
//    @ApiOperation("获取相应角色权限")
//    @RequestMapping(value = "/permission/list", method = RequestMethod.GET)
//    @ResponseBody
//    public List<? extends TreeNodeUtil.Node> getPermissionList(@RequestParam Long roleId) {
//        List<RolePermissionNode> nodes = serviceD.lightPermissionList(roleId);
//        return TreeNodeUtil.convertTree(nodes);
//    }
//
//    @ApiOperation("修改角色权限")
//    @RequestMapping(value = "/permission/update", method = RequestMethod.GET)
//    @ResponseBody
//    public void updatePermission(@RequestParam Long roleId,
//                                 @RequestParam("permissionIds") List<Long> permissionIds) {
//        if (serviceD.updatePermission(roleId, permissionIds) <= 0) {
//            throw new FrisbeeException(FrisbeeErrorEnum.ROLE_ERROR_UPDATE_PERMISSION);
//        }
//    }
//
////    @ApiOperation("修改角色状态")
////    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
////    @ResponseBody
////    public CommonResult updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
////        UmsRole umsRole = new UmsRole();
////        umsRole.setStatus(status);
////        int count = service.update(id, umsRole);
////        if (count > 0) {
////            return CommonResult.success(count);
////        }
////        return CommonResult.failed();
////    }
////
//
//}
