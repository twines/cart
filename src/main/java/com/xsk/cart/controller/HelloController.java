package com.xsk.cart.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;


@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Hello";
    }

    @RequestMapping("/hello")
    public ModelAndView hello() {
        HashMap mp = new HashMap();
        mp.put("name", "Jack Lee");
        ModelAndView view = new ModelAndView("hello",mp);

        return view;
    }

}
