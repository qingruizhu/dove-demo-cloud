package com.dove.demo.provider.uac.service;

import com.dove.demo.bgd.uac.model.User;
import com.dove.demo.bgd.uac.service.abs.AbsUserService;
import com.dove.demo.provider.api.uac.IUserServiceApi;
import com.dove.demo.provider.api.uac.dto.UserDto;
import com.dove.demo.provider.api.uac.request.RequestUser;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/8/26 09:54
 */
@Service
public class UserServiceImpl extends AbsUserService<RequestUser> implements IUserServiceApi {


    @Override
    public UserDto select(RequestUser requestUser) {
        if (null == requestUser) {
            return null;
        }
        User user = super.selectQ(requestUser);
        if (null == user) {
            return null;
        }
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    @Override
    public int update(RequestUser requestUser) {
        if (null == requestUser) {
            return -1;
        }
        return super.updateQ(requestUser);
    }

    @Override
    public int insert(RequestUser requestUser) {
        if (null == requestUser) {
            return -1;
        }
        return super.insertQ(requestUser);
    }
}
