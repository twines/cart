package com.xsk.cart.utilities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;

public class CartTool {
    public static String redirectTo(String dest) {
        if (dest.startsWith("redirect:")) {
            return dest;
        }
        return "redirect:" + dest;
    }

    public static void sendRedirect(HttpServletRequest request, HttpServletResponse response, String dest) throws IOException {
        String origin = request.getRequestURI();

        HttpSession session = request.getSession();
        if (session != null && origin.startsWith("/user/login") == false ) {
            session.setAttribute(ORIGIN_PATH, origin);
        }
        response.sendRedirect(request.getContextPath() + dest);
    }

    public static final String ORIGIN_PATH = "origin";


}
