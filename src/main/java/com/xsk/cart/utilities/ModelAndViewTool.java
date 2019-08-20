package com.xsk.cart.utilities;

import org.springframework.web.servlet.ModelAndView;

public class ModelAndViewTool {

    //"redirect:/xxxxx"
    public static ModelAndView redirect(ModelAndView modelAndView, String viewName) {
        String[] components = viewName.split(":");
        String vName = viewName;
        if (components.length == 0) {
            viewName = "redirect:" + components[0];
        }
        modelAndView.setViewName(vName);
        return modelAndView;
    }

}
