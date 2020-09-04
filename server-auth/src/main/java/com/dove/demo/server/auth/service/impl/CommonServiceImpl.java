package com.dove.demo.server.auth.service.impl;

import com.dove.common.core.exception.DoveException;
import com.dove.common.redis.service.RedisService;
import com.dove.demo.server.auth.service.ICommonService;
import com.dove.demo.server.auth.util.RedisKeySso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * @Description: 公共业务
 * @Auther: qingruizhu
 * @Date: 2020/4/30 09:28
 */
@Service
public class CommonServiceImpl implements ICommonService {

    @Autowired
    private RedisService redisService;
    @Value("${sso.authcode.expiration:60}")
    private long authCodeExpire;

    @Override
    public boolean cacheAuthCode(String randomPrefix, String randomCode) {
        //TODO 发送短信
        return redisService.set(RedisKeySso.authCode(randomPrefix), randomCode, authCodeExpire);
    }

    @Override
    public void checkAuthCode(String authPrefix, String authCode) {
        if (!redisService.exist(RedisKeySso.authCode(authPrefix))) {
            throw new DoveException("验证码失效");
        }
        String cacheCode = redisService.get(RedisKeySso.authCode(authPrefix));
        if (!cacheCode.equalsIgnoreCase(authCode)) {
            throw new DoveException("验证码错误");
        }
    }
}
