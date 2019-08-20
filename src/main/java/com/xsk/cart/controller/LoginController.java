package com.xsk.cart.controller;

import com.xsk.cart.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class LoginController {
    @RequestMapping("/user/login")
    public ModelAndView login(String name, String pwd, HttpServletRequest request) {
        HttpSession session = request.getSession();

        if(name.equals("root")&&pwd.equals("root")) {
            User user = new User();
            user.setUser(name);
            session.setAttribute("user",user);
//            return "登录成功";
        } else {
//            return "用户名或密码错误!";
        }
        return new ModelAndView("login");
    }
    @RequestMapping("/login")
    public ModelAndView index(Map value) {
        return new ModelAndView("login",value);
    }
}
