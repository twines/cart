package com.xsk.cart.config.interceptor;

import com.xsk.cart.utilities.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RedisSessionInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    StringRedisTemplate redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession = request.getSession();
        if (httpSession != null && httpSession.getAttribute(Const.LOGIN_USER_ID) != null) {
            String loginSessionId = redisTemplate.opsForValue().get("loginUser:" + (long) httpSession.getAttribute(Const.LOGIN_USER_ID));

        }
        return super.preHandle(request, response, handler);
    }
}
