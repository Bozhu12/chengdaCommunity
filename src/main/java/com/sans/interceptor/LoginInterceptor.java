package com.sans.interceptor;

import com.sans.common.ErrorCode;
import com.sans.common.UserHolder;
import com.sans.exception.BusinessException;
import com.sans.model.dto.UserDTO;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * @author Sans
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws BusinessException {
        UserDTO user = UserHolder.getUser();
        if (user == null) throw new BusinessException(ErrorCode.NOT_LOGIN);
        return true;
    }
}
