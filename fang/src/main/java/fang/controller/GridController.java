package fang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GridController {
    @RequestMapping("/grid")
    public ModelAndView grid(ModelAndView modelAndView) {
        modelAndView.setViewName("learn/grid");
        return modelAndView;
    }

    @RequestMapping("/form")
    public ModelAndView form(ModelAndView modelAndView) {
        modelAndView.setViewName("learn/form");
        return modelAndView;
    }
}
