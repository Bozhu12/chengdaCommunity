package com.sans.model.dto;

import lombok.Data;

/**
 * 业务数据
 * @author Sans
 */
@Data
public class UserDTO {

    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 关注用户
     */
    private String userFollowingJson;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 身份, 0游客;1用户;2管理
     */
    private Long role;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 性别
     */
    private Long gender;

}
