package com.theoldzheng.demo04;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Description: 集中处理异常的类
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.4.13 20:50
 */
@ControllerAdvice
public class MyExceptionCollection {
    @ExceptionHandler(value = ArithmeticException.class)
    public ModelAndView handlerError(Exception e){
        System.out.println("handlerException--->" + e);
        ModelAndView mv = new ModelAndView("errorPage");
        mv.addObject("ex",e);
        return mv;
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView handlerError2(Exception e){
        System.out.println("handlerException--->" + e);
        ModelAndView mv = new ModelAndView("errorPage");
        mv.addObject("ex",e);
        return mv;
    }
}
