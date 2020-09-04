package com.dove.demo.server.auth.controller;

import com.dove.common.base.annotation.CommonResultAnnon;
import com.dove.demo.server.auth.dto.SsoDto;
import com.dove.demo.server.auth.exception.AuthException;
import com.dove.demo.server.auth.service.ISsoService;
import com.dove.demo.server.auth.valid.SsoValid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(description = "【登录/注册】", tags = "☻ SSO")
@RestController
@CommonResultAnnon
@RequestMapping("/sso")
public class SsoController {

    private Logger LOG = LoggerFactory.getLogger(SsoController.class);

    @Resource
    private ISsoService ssoService;

//    @ApiOperation(value = "【用户名+密码】登录"/*, consumes = "application/x-www-form-urlencoded"*/)
//    @PostMapping(value = "/login"/*, consumes = "application/x-www-form-urlencoded"*/)
//    public CommonResult<String> login(
//            @RequestBody @Validated(SsoValid.Login.class) SsoDto dto) {
//        try {
//            String token = ssoService.login(dto.getUsername(), dto.getPassword());
//            return CommonResult.success(bearerToken(token));
//        } catch (Exception e) {
//            LOG.error("【{}】登录失败", dto.getUsername(), e);
//            throw new FrisbeeException(FrisbeeErrorEnum.SSO_LOGIN_ERROR_USER);
//        }
//    }

//    @ApiOperation(value = "【手机号+验证码】登录"/*, consumes = "application/x-www-form-urlencoded"*/)
//    @PostMapping(value = "/loginByPhone"/*, consumes = "application/x-www-form-urlencoded"*/)
//    public CommonResult<String> loginByPhone(
//            @RequestBody @Validated(SsoValid.loginByPhone.class) SsoDto dto) {
//        try {
//            String token = ssoService.loginByPhone(dto.getPhone(), dto.getAuthCode());
//            return CommonResult.success(bearerToken(token));
//        } catch (Exception e) {
//            LOG.error("【手机号:{}】登录失败", dto.getPhone(), e);
//            throw new FrisbeeException(FrisbeeErrorEnum.SSO_LOGIN_ERROR_PHONE_AUTHCODE);
//        }
//    }

    @ApiOperation(value = "【用户名+密码】注册"/*, consumes = "application/x-www-form-urlencoded"*/)
    @PostMapping(value = "/regist"/*, consumes = "application/x-www-form-urlencoded"*/)
    public void regist(
            @RequestParam String username,@RequestParam String password,@RequestParam String confirmPwd) {
        if (!password.equals(confirmPwd)) {
            throw new AuthException("两次输入密码不一致");
        }
        ssoService.regist(username,password);
    }

//    @ApiOperation("退出登录")
//    @GetMapping(value = "/logout")
//    public void logout() {
//        ssoService.logout();
//    }

    @ApiOperation(value = "找回密码"/*, consumes = "application/x-www-form-urlencoded"*/)
    @PostMapping("/findPwd"/*, consumes = "application/x-www-form-urlencoded"*/)
    public void findPwd(@RequestBody @Validated(SsoValid.FindPwd.class) SsoDto dto) {
        if (!dto.getPassword().equals(dto.getPwdConfirm())) {
            throw new AuthException("两次输入密码不一样");
        }
        ssoService.findPwd(dto.getPhone(), dto.getAuthCode(), dto.getPassword());
    }


}
