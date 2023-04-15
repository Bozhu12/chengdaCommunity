package com.sans.interceptor;

import cn.hutool.core.bean.BeanUtil;
import com.sans.common.UserHolder;
import com.sans.model.dto.UserDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.sans.common.RedisConstants.LOGIN_USER_KEY;
import static com.sans.common.RedisConstants.LOGIN_USER_TTL;

/**
 * token刷新拦截器
 * @author Sans
 */
public class RefreshToTokenInterceptor implements HandlerInterceptor {

    private RedisTemplate redisTemplate;

    public RefreshToTokenInterceptor(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从请求头中获取 Authorization 字段的值
        String token = request.getHeader("Authorization");

        // TODO 根据Token鉴定 是否与登录的设备好对应
        //if (!checkToken(token)) {
        // ...
        //}

        String redisTokenKey = LOGIN_USER_KEY + token;

        // 如果已经登录了 , 那么 token过期周期 , 并放行
        Map<Object, Object> map = redisTemplate.opsForHash().entries(redisTokenKey);
        if (BeanUtil.isEmpty(map)) return true;
        UserDTO userDTO = BeanUtil.fillBeanWithMap(map, new UserDTO(), false);
        if (!BeanUtil.isEmpty(userDTO)) {
            // 存储当前用户状态
            UserHolder.saveUser(userDTO);
            // 并刷新token过期周期
            redisTemplate.expire(redisTokenKey, LOGIN_USER_TTL, TimeUnit.DAYS);
        }

        // 如果鉴权成功 , 则放行请求
        return true;
    }

}
