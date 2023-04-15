package com.sans.model.request;


import lombok.Data;

/**
 * @author Sans
 */
@Data
public class UserRegisterRequest {

    private String username;
    private String password;
    private String nickname;
    private String email;

}
