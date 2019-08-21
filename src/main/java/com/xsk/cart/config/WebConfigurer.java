package com.xsk.cart.config;

import com.xsk.cart.config.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
        registry.addInterceptor(LoginInterceptor())
                .addPathPatterns("/**")//拦截范围
                .excludePathPatterns("/login/**","/register/*","(.*((.css)|(.js)))|(/+\\w+(/login)?)");//被忽略的

        //TODO注册其余的拦截器



    }
    @Bean
    public LoginInterceptor LoginInterceptor() {
        return new LoginInterceptor();
    }

}
