package com.xsk.cart.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class ErrorPageController {
    @GetMapping(value = "/error400Page")
    public ModelAndView error400Page() {
        return new ModelAndView("404");
    }
    @GetMapping(value = "/error401Page")
    public String error401Page() {
        return "401";
    }
    @GetMapping(value = "/error404Page")
    public ModelAndView error404Page(Map model) {
        model.put("code","6666666");
        model.put("msg","服务器降级中......");
        return new ModelAndView("404",model);
    }
    @GetMapping(value = "/error500Page")
    public String error500Page(Model model) {
        return "500";
    }
}
