package fang.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView globalException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof Exception) {
            modelAndView.setViewName("");
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            modelAndView.addObject("infos", stackTraceElements);
            modelAndView.addObject("msg", "异常提醒");
        }

        return modelAndView;
    }
}
