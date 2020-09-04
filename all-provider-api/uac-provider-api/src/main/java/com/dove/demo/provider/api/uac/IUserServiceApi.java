package com.dove.demo.provider.api.uac;


import com.dove.demo.provider.api.uac.dto.UserDto;
import com.dove.demo.provider.api.uac.request.RequestUser;

/**
 * @Description: 用户
 * @Auther: qingruizhu
 * @Date: 2020/8/26 09:53
 */
public interface IUserServiceApi {

    /**
     * 条件查询用户
     *
     * @param requestUser
     * @return
     */
    UserDto select(RequestUser requestUser);

    /**
     * 根据id修改用户信息
     *
     * @param requestUser
     * @return
     */
    int update(RequestUser requestUser);

    /**
     * 新增 用户
     *
     * @param requestUser
     * @return
     */
    int insert(RequestUser requestUser);
}
