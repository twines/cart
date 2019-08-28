package com.intercepors;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URI;
import java.util.regex.Pattern;

@Component
//public class LoginInterceptor implements HandlerInterceptor {
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session == null && needLoginForRequest(request)) {
            //没有登录


            response.sendRedirect("/login");
            return true;
        }
        return false;
    }

    /**
     * 加测request请求的路径
     * @param request
     * @return
     */
    private boolean needLoginForRequest(HttpServletRequest request) {

        String uri = request.getRequestURI();
        //
        boolean result = Pattern.matches("\\w+/user/+(\\w)?", uri);

        return false;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}


//WebRequestInterceptor是一个整合体，是更高一级的而handler则是最基础的
// 更多的是对数据的重组和过滤

@Component
class LoginRequestInterceptor implements WebRequestInterceptor {

    @Override
    public void preHandle(WebRequest request) throws Exception {

    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {

    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {

    }
}
