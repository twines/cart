package fang.controller;

import fang.entity.Month;
import fang.service.MonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MonthController {
    @Autowired
    MonthService monthService;

    @GetMapping("/month")
    public ModelAndView index(ModelAndView modelAndView) {
        Month month = monthService.findFirstByOrderByDateDesc();
        Iterable<Month> monthIterable = monthService.findAll();
        List<Month> monthList = new ArrayList<>();
        for (Month m : monthIterable) {
            monthList.add(m);
        }
        modelAndView.setViewName("month/index");
        Map value = new HashMap();
        value.put("month", month);
        value.put("months", monthList);
        modelAndView.addAllObjects(value);
        return modelAndView;
    }
}
