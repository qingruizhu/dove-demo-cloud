package com.dove.demo.server.auth.controller;

import com.dove.common.base.annotation.CommonResultAnnon;
import com.dove.common.base.vo.CommonResult;
import com.dove.common.util.random.RandomUtil;
import com.dove.demo.server.auth.service.ICommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "【公共接口】", tags = "☻ Common")
@RestController
@RequestMapping("/common")
public class CommonController {


    @Autowired
    private ICommonService service;
//    @Autowired
//    StringEncryptor stringEncryptor;


    @ApiOperation("获取【验证码】")
    @GetMapping(value = "/getAuthCode")
    public CommonResult getAuthCode(
            @ApiParam("手机号") @RequestParam(required = false) String randomPrefix,
            @ApiParam("验证码长度") @RequestParam(defaultValue = "4") int randomLen,
            @ApiParam("验证码组成类型") @RequestParam(defaultValue = RandomUtil.RANDOM_TYPE_NUM) String randomType) {
        String randomCode = RandomUtil.generateRandom(randomLen, randomType);
        if (StringUtils.isBlank(randomPrefix)) {
            return CommonResult.success(randomCode, "获取随机码成功");
        }
        if (service.cacheAuthCode(randomPrefix, randomCode)) {
            return CommonResult.success(randomCode, "获取验证码成功");
        }
        return CommonResult.failed("获取验证码失败");
    }

    @ApiOperation("校验【验证码】")
    @PostMapping(value = "/checkAuthCode")
    @CommonResultAnnon
    public CommonResult checkAuthCode(
            @ApiParam("手机号或用户名") @RequestParam String authPrefix,
            @ApiParam("验证码") @RequestParam String authCode) {
        service.checkAuthCode(authPrefix, authCode);
        return CommonResult.success();
    }

}
