package com.theoldzheng.demo02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: 控制器
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.4.7 9:12
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/hello01")
    public String handler01(){
        System.out.println("handler01 is loading....");
        return "success";
    }

    /**
     * 返回一个 请求转发
     * 这里的请求转发不会调用视图解析器进行拼串，会直接从web路径下开始找对应的转发地址
     * @return
     */
    @RequestMapping(value = "/hello02")
    public String handler02(){
        System.out.println("handler02 is loading....");
        return "forward:/pages/success.jsp";
    }

    /**
     * 请求重定向，SpringMVC的重定向操作，不用写项目地址
     * @return
     */
    @RequestMapping(value = "/hello03")
    public String handler03(){
        System.out.println("handler03 is loading....");
//        return "redirect:https://www.google.com/";
        return "redirect:/hello.jsp";
    }



}
