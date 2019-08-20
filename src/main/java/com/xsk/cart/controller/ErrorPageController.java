package com.xsk.cart.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class ErrorPageController {
    @RequestMapping(value = "/error400Page")
    public ModelAndView error400Page() {
        return new ModelAndView("404");
    }
    @RequestMapping(value = "/error401Page")
    public String error401Page() {
        return "401";
    }
    @RequestMapping(value = "/error404Page")
    public ModelAndView error404Page(Map model) {
        model.put("code","6666666");
        model.put("msg","服务器降级中......");
        return new ModelAndView("404",model);
    }
    @RequestMapping(value = "/error500Page")
    public String error500Page(Model model) {
        return "500";
    }
}
