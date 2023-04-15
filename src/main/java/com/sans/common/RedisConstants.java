package com.sans.common;

/**
 * Redis自定义前缀key
 * @author Sans
 */
public class RedisConstants {

    public static final String LOGIN_CODE_KEY = "login:code:";
    public static final Long LOGIN_CODE_TTL = 2L;
    public static final String LOGIN_USER_KEY = "login:token:";
    // 单位 7天
    public static final Long LOGIN_USER_TTL = 7L;

}
