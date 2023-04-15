package com.sans.common;

/**
 * 错误码
 *
 * @author sans
 */
public enum ErrorCode {

    /**
     * 错误响应信息
     */
    SUCCESS(2000, "ok"),
    // 权限/限制
    NULL_ERROR(4004, "数据不存在"),
    NOT_LOGIN(4001, "未登录"),
    NO_AUTH(4005 , "无权限"),
    DATA_CANNOT_BE_EMPTY(4001, "必选信息不能为空"),
    USERNAME_CANNOT_CONTAIN_SYMBOLS(4001, "用户名不能包含符号"),
    // 错误
    LOGIN_ERROR(4001 , "账号或密码错误"),
    PARAMS_ERROR(4006, "请求错误"),
    SYSTEM_ERROR(5000, "系统异常");

    private final int code;

    /**
     * 状态码信息
     */
    private final String message;


    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
