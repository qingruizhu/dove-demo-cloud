package com.dove.demo.server.auth.service;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * @Description:
 * @Author qingruizhu
 * @Date 10:47 上午 2020/7/23
 **/
@Validated
public interface ISsoService {


    void regist(@NotBlank String username, @NotBlank String password);


    void findPwd(String phone, String authCode, String password);

}
