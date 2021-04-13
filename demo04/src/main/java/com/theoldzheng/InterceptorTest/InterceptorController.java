package com.theoldzheng.InterceptorTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: 拦截控制器
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.4.13 11:59
 */
@Controller
public class InterceptorController {
    @RequestMapping(value = "/test")
    public void testForInterceptor(){
        System.out.println("test....");
    }
}
