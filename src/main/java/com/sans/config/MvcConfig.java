package com.sans.config;

import com.sans.interceptor.LoginInterceptor;
import com.sans.interceptor.RefreshToTokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 提供给拦截器使用
     */
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 拦截登录
     * 排除 获取验证码/登录 请求
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 先 验证token , 后判定 权限
        registry.addInterceptor(new LoginInterceptor())
                // 跳过指定uri
                .excludePathPatterns(
                        "/users/login"
                )
                .order(1);
        registry.addInterceptor(new RefreshToTokenInterceptor(redisTemplate)).order(0);
    }
}

