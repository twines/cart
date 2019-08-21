package com.xsk.cart.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {
    public static final String DEFAULT_ERROR_VIEW = "error"; // 定义错误显示页，error.html
    class ErrorInfo {
        private Integer code;
        private String message;
        private String url;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public ModelAndView index(HttpServletRequest request, ErrorInfo e) { // 出现异常之后会跳转到此方法
        ModelAndView mav = new ModelAndView("error"); // 设置跳转路径
        mav.addObject("exception", e); // 将异常对象传递过去
        mav.addObject("url", request.getRequestURL()); // 获得请求的路径
        return mav;
    }

    @ExceptionHandler(Exception.class) // 所有的异常都是Exception子类
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
        ErrorInfo info = new ErrorInfo();
        info.setCode(100);     // 标记一个错误信息类型
        info.setMessage(e.getMessage());
        info.setUrl(request.getRequestURL().toString());
        ModelAndView mav = new ModelAndView("error"); // 设置跳转路径
        mav.addObject("exception", info); // 将异常对象传递过去
        mav.addObject("url", request.getRequestURL()); // 获得请求的路径
        return mav;
    }
}
