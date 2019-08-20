package com.xsk.cart.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {


        return "Hello";
    }

    @RequestMapping("/hello")
    public ModelAndView hello() {

        Map map = new HashMap();
        map.put("name", "jack lee");
        List list = new ArrayList();
        for (int index = 0; index < 10; index++) {
            Map iMap = new HashMap();
            iMap.put("value", "我是第" + index);
            list.add(iMap);
        }
        map.put("list", list);
        ModelAndView v = new ModelAndView("hello", map);
        return v;
    }

}
