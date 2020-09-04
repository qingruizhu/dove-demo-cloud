//package com.dove.demo.server.auth.controller;
//
//import com.dove.book.bgd.page.CommonPage;
//import com.dove.common.base.validate.QueryGroup;
//import com.dove.common.util.data.TreeNodeUtil;
//import com.dove.demo.bgd.a.model.FbPermission;
//import com.dove.demo.bgd.a.service.IFbPermissionService;
//import com.dove.demo.server.a.dto.PermissionDto;
//import com.dove.demo.server.a.node.FbPermissionNode;
//import com.dove.demo.server.a.service.IPermissionServiceD;
//import com.dove.demo.server.frisbee.exception.FrisbeeException;
//import com.github.pagehelper.PageHelper;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.apache.commons.collections.CollectionUtils;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static com.dove.demo.server.frisbee.enm.FrisbeeErrorEnum.*;
//
///**
// * @Description:权限管理
// * @Author qingruizhu
// * @Date 3:09 下午 2020/7/11
// **/
//@Api(description = "【权限信息】", tags = "☻ FbPermission")
//@RestController
//@RequestMapping("/permission")
//public class PermController {
//
//    @Autowired
//    private IPermissionService<PermissionDto> service;
//
//    @Autowired
//    private IPermissionServiceD serviceD;
//
//    @ApiOperation("分页获取权限列表")
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public CommonPage<FbPermission> list(
//            @RequestParam(value = "pid", required = false) Long pid,
//            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
//            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
//        PageHelper.startPage(pageNum, pageSize);
//        FbPermission query = new FbPermission();
//        query.setPid(pid);
//        List<FbPermission> permissions = service.list(query);
//        return CommonPage.restPage(permissions);
//    }
//
//    @ApiOperation("添加权限")
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public void create(@RequestBody @Validated(QueryGroup.Insert.class) PermissionDto dto) {
//        if (service.insertQ(dto) <= 0) {
//            throw new FrisbeeException(PERMISSION_ERROR_CREATE);
//        }
//    }
//
//    @ApiOperation("修改权限")
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public void update(@RequestBody @Validated(QueryGroup.Update.class) PermissionDto dto) {
//        dto.setPid(null);
//        if (service.updateQ(dto) <= 0) {
//            throw new FrisbeeException(PERMISSION_ERROR_UPDATE);
//        }
//    }
//
//    @ApiOperation("根据id删除权限")
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public void delete(@PathVariable Long id) {
//        FbPermission query = new FbPermission();
//        query.setPid(id);
//        if (CollectionUtils.isNotEmpty(service.list(query))) {
//            throw new FrisbeeException("请先删除下级权限");
//        }
//        if (service.delete(id) <= 0) {
//            throw new FrisbeeException(PERMISSION_ERROR_DEL);
//        }
//    }
//
//    @ApiOperation("树状权限列表")
//    @RequestMapping(value = "/treeList", method = RequestMethod.GET)
//    public List<? extends TreeNodeUtil.Node> treeList() {
//        List<FbPermission> permissions = service.list(new FbPermission());
//        List<FbPermissionNode> fbPermissionNodes = permissions.stream().map(permission -> {
//            FbPermissionNode fbPermissionNode = new FbPermissionNode();
//            BeanUtils.copyProperties(permission, fbPermissionNode);
//            return fbPermissionNode;
//        }).collect(Collectors.toList());
//        return TreeNodeUtil.convertTree(fbPermissionNodes);
//    }
//}
