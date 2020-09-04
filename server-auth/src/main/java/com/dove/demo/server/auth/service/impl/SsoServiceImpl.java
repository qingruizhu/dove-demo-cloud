package com.dove.demo.server.auth.service.impl;

import com.common.dove.oauth2.base.util.BCryptUtil;
import com.dove.common.redis.service.RedisService;
import com.dove.demo.provider.api.uac.IUserServiceApi;
import com.dove.demo.provider.api.uac.dto.UserDto;
import com.dove.demo.provider.api.uac.request.RequestUser;
import com.dove.demo.server.auth.exception.AuthException;
import com.dove.demo.server.auth.service.ISsoService;
import com.dove.demo.server.auth.util.RedisKeySso;
import org.apache.commons.collections.CollectionUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author qingruizhu
 * @Date 11:17 上午 2020/7/23
 **/
@Service
public class SsoServiceImpl implements ISsoService {
    private Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Autowired
    RedisService redisService;
    @Reference
    IUserServiceApi userServiceApi;


    @Override
    public void regist(String username, String password) {
        RequestUser requestUser = new RequestUser();
        requestUser.setUsername(username);
        UserDto userDto = userServiceApi.select(requestUser);
        if (null!=userDto) {
            throw new AuthException("用户名已存在");
        }
        requestUser.setPassword(BCryptUtil.encrypt(password));
        requestUser.setStatus(1);
        if (userServiceApi.insert(requestUser) <= 0) {
            throw new AuthException("注册失败");
        }
    }


    @Override
    public void findPwd(String phone, String authCode, String password) {
        RequestUser requestUser = new RequestUser();
        requestUser.setPhone(phone);
        UserDto userDto = userServiceApi.select(requestUser);
        if (null == userDto) {
            throw new AuthException("手机号不存在");
        }
        if (null != userDto.getStatus() && userDto.getStatus() == 1) {
            checkAuthCode(phone, authCode);
            requestUser.setPassword(BCryptUtil.encrypt(password));
            requestUser.setId(userDto.getId());
            if (userServiceApi.update(requestUser) <= 0) {
                throw new AuthException("找回密码失败");
            }
            return;
        }
        throw new AuthException("该账号禁用");

    }

    /**
     * 验证authCode
     */
    private void checkAuthCode(String phone, String authCode) {
        if (redisService.exist(RedisKeySso.authCode(phone))) {
            String cacheCode = redisService.get(RedisKeySso.authCode(phone));
            if (!cacheCode.equalsIgnoreCase(authCode)) {
                throw new AuthException("验证码错误");
            }
            return;
        }
        throw new AuthException("验证码错误");
    }


}
