package fang.controller;

import fang.entity.Daily;
import fang.service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DailyController {
    @Autowired
    DailyService dailyService;


    @GetMapping("/daily/page/{page}/size/{size}")
    public ModelAndView daily(@PathVariable("page") int pageIndex, @PathVariable("size") int size, ModelAndView modelAndView) {
        modelAndView.setViewName("daily/index");
        PageRequest pageRequest = new PageRequest(pageIndex, size);
        Page<Daily> page = dailyService.findAll(pageRequest);
        Map<String, Object> v = new HashMap<>();
        v.put("dailies", page.getContent());
        modelAndView.addAllObjects(v);
        return modelAndView;
    }
}
