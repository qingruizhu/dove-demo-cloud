package com.dove.demo.server.auth.controller;

import com.common.dove.oauth2.base.OauthUserHolder;
import com.common.dove.oauth2.base.util.BCryptUtil;
import com.dove.common.base.annotation.CommonResultAnnon;
import com.dove.common.base.validate.QueryGroup;
import com.dove.demo.provider.api.uac.IUserServiceApi;
import com.dove.demo.provider.api.uac.dto.UserDto;
import com.dove.demo.provider.api.uac.request.RequestUser;
import com.dove.demo.server.auth.exception.AuthException;
import com.dove.demo.server.auth.service.ICommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(description = "【个人信息】", tags = "☻ ME")
@RestController
@CommonResultAnnon
@RequestMapping("/me")
public class MeController {


    @Reference
    IUserServiceApi userServiceApi;
    @Autowired
    private ICommonService commonService;

    @ApiOperation("查询【我的信息】")
    @GetMapping(value = "/info")
    public UserDto info() {
        RequestUser requestUser = new RequestUser();
        requestUser.setId(OauthUserHolder.uId());
        UserDto user = userServiceApi.select(requestUser);
        user.setPassword(null);
        return user;
    }

    @ApiOperation("修改/设置【手机号】")
    @PostMapping("/updatePhone")
    public void updatePhone(
            @ApiParam("手机号") @RequestParam String phone,
            @ApiParam("验证码") @RequestParam String authCode) {
        // 1.校验验证码
        commonService.checkAuthCode(phone, authCode);
        RequestUser user = new RequestUser();
        user.setPhone(phone);
        user.setId(OauthUserHolder.uId());
        //2.修改
        if (userServiceApi.update(user) <= 0) {
            throw new AuthException("修改手机号失败");
        }
    }

    @ApiOperation("修改【密码】")
    @PostMapping("/updatePassword")
    public void updatePassword(
            @ApiParam("原始密码") @RequestParam String originalPwd,
            @ApiParam("新密码 ") @RequestParam String targetPwd,
            @ApiParam("验证码") @RequestParam String authCode) {
        RequestUser requestUser = new RequestUser();
        requestUser.setId(OauthUserHolder.uId());
        UserDto userDto = userServiceApi.select(requestUser);
        String oldPwd = BCryptUtil.encrypt(originalPwd);
        //1.校验老密码
        if (!userDto.getPassword().equals(oldPwd)) {
            throw new AuthException("旧密码输入有误");
        }
        if (StringUtils.isBlank(userDto.getPhone())) {
            throw new AuthException("手机号不存在");
        }
        // 2.校验验证码
        commonService.checkAuthCode(userDto.getPhone(), authCode);
        // 3.修改密码
        RequestUser newUser = new RequestUser();
        newUser.setId(userDto.getId());
        newUser.setPassword(BCryptUtil.encrypt(targetPwd));
        if (userServiceApi.update(newUser) <= 0) {
            throw new AuthException("修改密码失败");
        }
    }

    @ApiOperation("修改【我的信息】")
    @PostMapping("/updateInfo")
    public void updateInfo(
            @RequestBody @Validated(QueryGroup.Update.class) RequestUser requestUser) {
        requestUser.setId(OauthUserHolder.uId());
        requestUser.setPhone(null);
        requestUser.setPassword(null);
        if (userServiceApi.update(requestUser) <= 0) {
            throw new AuthException("修改信息失败");
        }
    }


}
