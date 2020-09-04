package com.dove.demo.server.auth.dto;

import com.dove.demo.server.auth.valid.SsoValid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel
public class SsoDto implements Serializable {

    private static final long serialVersionUID = 1L;
//    @NotBlank(groups = {Select.class}, message = "【id】不能为空")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")

    @NotBlank(groups = { SsoValid.Login.class}, message = "【用户名】不能为空")
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "密码")
    @NotBlank(groups = {SsoValid.Login.class,  SsoValid.FindPwd.class}, message = "【密码】不能为空")
    private String password;

    @ApiModelProperty(value = "手机号")
    @NotBlank(groups = {SsoValid.loginByPhone.class,  SsoValid.FindPwd.class}, message = "【手机号】不能为空")
    private String phone;
    @ApiModelProperty(value = "验证码")
    @NotBlank(groups = {SsoValid.loginByPhone.class,  SsoValid.FindPwd.class}, message = "【验证码】不能为空")
    private String authCode;

    @ApiModelProperty(value = "确认密码")
    @NotBlank(groups = { SsoValid.FindPwd.class}, message = "【验证码】不能为空")
    private String pwdConfirm;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getPwdConfirm() {
        return pwdConfirm;
    }

    public void setPwdConfirm(String pwdConfirm) {
        this.pwdConfirm = pwdConfirm;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String realname) {
        this.username = realname;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("phone=").append(phone);
        sb.append(", password=").append(password);
        sb.append(", authCode=").append(authCode);
        sb.append(", pwdConfirm=").append(pwdConfirm);
        sb.append(", username=").append(username);
        sb.append("]");
        return sb.toString();
    }
}