package com.dove.demo.bgd.uac.service;

import com.dove.common.base.service.IBaseQService;
import com.dove.common.base.service.IBaseService;
import com.dove.demo.bgd.uac.model.User;
import org.springframework.validation.annotation.Validated;


/**
 * @Description: 用户信息
 * @Author qingruizhu
 * @Date 9:42 上午 2020/8/26
 **/
@Validated
public interface IUserService<Q> extends IBaseService<User>, IBaseQService<User, Q> {
    User selectByKey(String key, Object value);

}
