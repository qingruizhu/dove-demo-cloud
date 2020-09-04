package com.dove.demo.server.a.controller;

import com.dove.demo.provider.api.uac.IUserServiceApi;
import com.dove.demo.provider.api.uac.dto.UserDto;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/8/26 17:41
 */
@RestController
@RequestMapping("/user")
public class TestController {

    @Reference
    IUserServiceApi userServiceApi;

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public UserDto select() {
        return userServiceApi.select(null);
    }
}
