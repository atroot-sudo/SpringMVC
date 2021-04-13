package com.theoldzheng.demo04;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Description: HelloController 控制器
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.4.13 10:42
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/test01")
    public String test01(Integer i){
        System.out.println("handler01..");
        System.out.println(10/i);
        return "success";
    }


    @ExceptionHandler(value = ArithmeticException.class)
    public ModelAndView handlerError(Exception e){
        System.out.println("handlerException--->" + e);
        ModelAndView mv = new ModelAndView("errorPage");
        mv.addObject("ex",e);
        return mv;
    }


    @RequestMapping(value = "/handler02")
    public String test02(@RequestParam("username")String username){
        if (!"admin".equals(username)) {
            throw new UserNameNotFoundException();
        }
        return "seccess";
    }



}
