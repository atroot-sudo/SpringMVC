package com.theoldzheng.demo03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.4.8 11:21
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/hello")
    public String handler01(){
        System.out.println("handler01 loading...");
        return "success";
    }
}
