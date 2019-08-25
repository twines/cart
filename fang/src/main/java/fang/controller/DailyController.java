package fang.controller;

import fang.entity.Daily;
import fang.service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
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

    @GetMapping("/daily")
    @ResponseBody
    public  LauiTableData<Daily> json(@RequestParam("page") int pageIndex, @RequestParam("size") int size) {
        PageRequest pageRequest = new PageRequest(pageIndex, size);
        Page<Daily> page = dailyService.findAll(pageRequest);

        LauiTableData<Daily> d = new LauiTableData<Daily>(0, (int) page.getTotalElements(), "success", page.getContent());
        return d;
//        return page.getContent();
    }

    class LauiTableData<T extends  Object>{
        public LauiTableData(int code, int count, String msg, List<T> data) {
            this.code = code;
            this.count = count;
            this.msg = msg;
            this.data = data;
        }

        int code;
        int count;
        String msg;
        List<T> data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<T> getData() {
            return data;
        }

        public void setData(List<T> data) {
            this.data = data;
        }
    }
}
