package com.sans.model.request;

import lombok.Data;

/**
 * 登录请求
 * @author Sans
 */
@Data
public class UserLoginRequest {

    public String username;
    public String password;

}
