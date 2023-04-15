package com.sans.exception;

import com.sans.common.ErrorCode;


/**
 * 自定义异常类
 *
 * @author sans
 */
public class BusinessException extends RuntimeException {

    private int code;

    private String msg;

    private final ErrorCode errorCode;


    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode, String msg) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getMsg() {
        return msg;
    }
}
