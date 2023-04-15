package com.sans.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回类
 *
 * @param <T>
 * @author sans
 */
@Data
public class BaseResponse<T> implements Serializable {

    private int code;

    private T data;

    private String message;


    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(T data) {
        this(200, data, "ok");
    }


    // 成功
    public static <T> BaseResponse<T> ok() {
        return new BaseResponse<>(null);
    }
    public static <T> BaseResponse<T> ok(T data) {
        return new BaseResponse<>(data);
    }

    // 业务异常
    public static <T> BaseResponse<T> fail(ErrorCode errorCode, String msg) {
        return new BaseResponse<>(errorCode.getCode(), null, msg);
    }
    // 系统异常
    public static <T> BaseResponse<T> fail() {
        return new BaseResponse<>(ErrorCode.SYSTEM_ERROR.getCode(), null, ErrorCode.SYSTEM_ERROR.getMessage());
    }
}
