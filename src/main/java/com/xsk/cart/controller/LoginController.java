package com.xsk.cart.controller;

import com.xsk.cart.model.User;
import com.xsk.cart.utilities.CartTool;
import com.xsk.cart.utilities.ModelAndViewTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
public class LoginController {
    private final String SESSION_KEY = "user";

    @PostMapping("/user/login")
    public void login(String name, String pwd, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        User u = (User) session.getAttribute(sessionId);
        if (u != null) {

        } else {
            User user = new User();
            user.setUser(name);
            session.setAttribute(sessionId, user);
        }

//     return    CartTool.redirectTo("/user/login");//此时不能用Restfull
         CartTool.sendRedirect(request,response,"/"); //均可
    }

    @GetMapping("/login")
    public String index() {
        return "login";
    }
}
