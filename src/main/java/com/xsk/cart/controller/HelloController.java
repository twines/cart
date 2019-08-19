package com.xsk.cart.controller;


import com.sun.tools.internal.xjc.model.Model;
import com.xsk.cart.domain.UserEntity;
import com.xsk.cart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@RestController
public class HelloController {
    @Autowired
    UserService service;

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

    @RequestMapping("/jps")
    public UserEntity jpsDao() {
        Optional<UserEntity> op = service.FindUserById(Long.valueOf(1));
        if (op.isPresent()) {
            UserEntity userEntity = op.get();
            return userEntity;
        } else {
            return null;
        }
    }

    @RequestMapping("/users")
    public ModelAndView userList(ModelMap modelMap) {
        List<UserEntity> users = service.FindAllUsers();

        modelMap.put("users", users);
        ModelAndView mv = new ModelAndView("userlist", modelMap);
        return mv;
    }
}
