package com.xsk.cart.config.session;


import com.xsk.cart.utilities.CartTool;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "sessionFilter", urlPatterns = {"/*"})
public class SessionFilter implements javax.servlet.Filter {
    //标示符：表示当前用户未登录(可根据自己项目需要改为json样式)
    String NO_LOGIN = "您还未登录";

    //不需要登录就可以访问的路径(比如:注册登录等)
    String[] includeUrls = new String[]{"/login", "/register", "/error500Page", "/error404Page", "/error401Page"};


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public boolean isNeedFilter(String uri) {
        boolean isStaticResource = uri.split(".").length > 0;

        for (String includeUrl : includeUrls) {
            if (includeUrl.equals(uri)|| isStaticResource ==false) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();
        System.out.println("filter url:" + uri);

        if (session != null && session.getAttribute(session.getId()) != null) {
            filterChain.doFilter(request, response);
            return;
        }
        //不对POST拦截
        if (request.getMethod().toUpperCase().equals("POST")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //cookie遍历
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("sessionId")) {
                    String cookieInfo = cookie.getValue();
                    System.out.println(cookieInfo);
                }
            }
        }

        //是否需要过滤
        boolean needFilter = isNeedFilter(uri);


        if (!needFilter) { //不需要过滤直接传给下一个过滤器
            filterChain.doFilter(servletRequest, servletResponse);
        } else { //需要过滤器
            // session中包含user对象,则是登录状态
            if (session != null && session.getAttribute("user") != null) {
                // System.out.println("user:"+session.getAttribute("user"));
                filterChain.doFilter(request, response);
            } else {
                String requestType = request.getHeader("X-Requested-With");
                //判断是否是ajax请求
                if (requestType != null && "XMLHttpRequest".equals(requestType)) {
                    response.getWriter().write(this.NO_LOGIN);
                } else {
                    //重定向到登录页(需要在static文件夹下建立此html文件)
//                    response.sendRedirect(request.getContextPath() + "/user/login");
                    CartTool.sendRedirect(request, response, "/login");
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}
