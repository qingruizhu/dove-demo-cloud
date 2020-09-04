//package com.dove.demo.server.auth.service.impl;
//
//import com.common.dove.oauth2.base.util.BCryptUtil;
//import com.dove.demo.bgd.a.model.*;
//import com.github.pagehelper.PageHelper;
//import com.dove.demo.bgd.a.enm.UserStatusEnm;
//import com.dove.demo.bgd.a.mapper.FbUserRoleRelaMapper;
//import com.dove.demo.bgd.a.service.abs.AbsFbUserService;
//import com.dove.demo.server.a.dto.UserDto;
//import com.dove.demo.server.a.dto.UserQueryParam;
//import com.dove.demo.server.frisbee.exception.FrisbeeException;
//import com.dove.demo.server.a.service.IUserServiceD;
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Description:
// * @Auther: qingruizhu
// * @Date: 2020/7/23 10:42
// */
//@Service
//public class UserServiceImpl extends AbsFbUserService<UserDto> implements IUserServiceD {
//
//
//    @Resource
//    private FbUserRoleRelaMapper userRoleRelaMapper;
//    @Resource
//    private FbUserRoleRelaDao fbUserRoleRelaDao;
//
//    /**
//     * 模糊查询用户
//     */
//    @Override
//    public List<FbUser> list(UserQueryParam param) {
//        PageHelper.startPage(param.getPageNum(), param.getPageSize());
//        FbUserExample example = new FbUserExample();
//        FbUserExample.Criteria criteria = example.createCriteria();
//        if (StringUtils.isNotEmpty(param.getUsername())) {
//            criteria.andUsernameLike("%" + param.getUsername() + "%");
//        }
//        if (StringUtils.isNotEmpty(param.getPhone())) {
//            criteria.andPhoneLike("%" + param.getPhone() + "%");
//        }
//        if (null != param.getStatus()) {
//            criteria.andStatusEqualTo(param.getStatus());
//        }
//        return mapper.selectByExample(example);
//    }
//
//    @Override
//    public List<Role> getRoleList(String userIdStr) {
//        return fbUserRoleRelaDao.getRoleList(userIdStr);
//    }
//
//    @Override
//    public int updateRole(String userIdStr, List<Long> roleIds) {
//        int count = roleIds == null ? 0 : roleIds.size();
//        //先删除原来->用户-角色
//        FbUserRoleRelaExample userRoleRelaExample = new FbUserRoleRelaExample();
//        userRoleRelaExample.createCriteria().andUserIdStrEqualTo(userIdStr);
//        userRoleRelaMapper.deleteByExample(userRoleRelaExample);
//        //建立新的
//        if (CollectionUtils.isNotEmpty(roleIds)) {
//            List<FbUserRoleRela> list = new ArrayList<>();
//            for (Long roleId : roleIds) {
//                FbUserRoleRela roleRelation = new FbUserRoleRela();
//                roleRelation.setUserIdStr(userIdStr);
//                roleRelation.setRoleId(roleId);
//                list.add(roleRelation);
//            }
//            fbUserRoleRelaDao.insertList(list);
//        }
//        return count;
//    }
//
//    @Override
//    public List<FbPermission> getPermissionList(String userIdStr) {
//        return fbUserRoleRelaDao.getPermissionList(userIdStr);
//    }
//
//    @Override
//    public int insert(UserDto dto) {
//        if (StringUtils.isNotEmpty(dto.getPhone())) {
//            if (CollectionUtils.isNotEmpty(this.selectByKey("phone", dto.getPhone()))) {
//                throw new FrisbeeException("手机号已经被使用");
//            }
//        }
//        if (StringUtils.isNotEmpty(dto.getPassword())) {
//            dto.setPassword(BCryptUtil.encrypt(dto.getPassword()));
//        }
//        dto.setStatus(UserStatusEnm.AVAILABLE.getCode());
//        return this.insertQ(dto);
//    }
//
//    @Override
//    public int update(UserDto dto) {
//        if (StringUtils.isNotEmpty(dto.getPhone())) {
//            List<FbUser> phoneUsers = this.selectByKey("phone", dto.getPhone());
//            if (CollectionUtils.isNotEmpty(phoneUsers)) {
//                if (phoneUsers.size() >= 2) {
//                    throw new FrisbeeException("手机号已经被使用");
//                }
//                FbUser user = phoneUsers.get(0);
//                if (user.getId().longValue() != dto.getId()) {
//                    throw new FrisbeeException("手机号已经被使用");
//                }
//            }
//        }
//        if (StringUtils.isNotEmpty(dto.getPassword())) {
//            dto.setPassword(BCryptUtil.encrypt(dto.getPassword()));
//        }
//        return this.updateQ(dto);
//    }
//
//    @Override
//    public int delete(Long userId) {
//        int count = super.delete(userId);
//        //删除->用户-角色
//        FbUserRoleRelaExample userRoleRelaExample = new FbUserRoleRelaExample();
//        userRoleRelaExample.createCriteria().andUserIdStrEqualTo(String.valueOf(userId));
//        userRoleRelaMapper.deleteByExample(userRoleRelaExample);
//        return count;
//    }
//}
