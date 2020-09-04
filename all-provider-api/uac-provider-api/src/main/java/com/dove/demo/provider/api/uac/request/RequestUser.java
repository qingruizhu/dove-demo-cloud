package com.dove.demo.provider.api.uac.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RequestUser implements Serializable {
    private Long id;
    //
    private String username;
    // 手机号
    private String phone;
    // 状态:1-有效,2-无效
    private Integer status;
    // 密码
    private String password;
    //
    private Date loginTime;


    private static final long serialVersionUID = 1L;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}