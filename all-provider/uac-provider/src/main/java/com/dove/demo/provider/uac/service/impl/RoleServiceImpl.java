//package com.dove.demo.provider.uac.service.impl;
//
//import com.dove.demo.bgd.a.mapper.RolePermissionRelaMapper;
//import com.dove.demo.bgd.a.model.FbPermission;
//import com.dove.demo.bgd.a.model.RolePermissionRela;
//import com.dove.demo.bgd.a.model.RolePermissionRelaExample;
//import com.dove.demo.bgd.a.service.abs.AbsRoleService;
//import com.dove.demo.server.a.dto.RoleDto;
//import com.dove.demo.server.a.node.RolePermissionNode;
//import com.dove.demo.server.a.service.IRoleServiceD;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Description:
// * @Auther: qingruizhu
// * @Date: 2020/7/28 10:33
// */
//@Service
//public class RoleServiceImpl extends AbsRoleService<RoleDto> implements IRoleServiceD {
//
//    @Resource
//    private RolePermissionRelaMapper RolePermissionRelaMapper;
//    @Resource
//    private RolePermissionRelaDao RolePermissionRelaDao;
//
//    @Override
//    public int delete(List<Long> ids) {
//        return 0;
//    }
//
//    @Override
//    public List<FbPermission> getPermissionList(Long RoleId) {
//        return RolePermissionRelaDao.getPermissionList(RoleId);
//    }
//
//    @Override
//    public int updatePermission(Long RoleId, List<Long> permissionIds) {
//        //先删除原有关系
//        RolePermissionRelaExample example = new RolePermissionRelaExample();
//        example.createCriteria().andRoleIdEqualTo(RoleId);
//        RolePermissionRelaMapper.deleteByExample(example);
//        //批量插入新关系
//        List<RolePermissionRela> relationList = new ArrayList<>();
//        for (Long permissionId : permissionIds) {
//            RolePermissionRela relation = new RolePermissionRela();
//            relation.setRoleId(RoleId);
//            relation.setPermissionId(permissionId);
//            relationList.add(relation);
//        }
//        return RolePermissionRelaDao.insertList(relationList);
//    }
//
//    @Override
//    public List<RolePermissionNode> lightPermissionList(Long RoleId) {
//        return RolePermissionRelaDao.lightPermissionList(RoleId);
//    }
//
//    @Override
//    @Transactional
//    public int delete(Long RoleId) {
//        int count = super.delete(RoleId);
//        //删除->角色-权限
//        RolePermissionRelaExample example = new RolePermissionRelaExample();
//        example.createCriteria().andRoleIdEqualTo(RoleId);
//        RolePermissionRelaMapper.deleteByExample(example);
//        return count;
//    }
//}
