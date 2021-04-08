package com.theoldzheng.ViewResolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:自定义的视图控制器
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.4.8 9:15
 */
@Controller
public class MyViewResolverController {
    @RequestMapping(value = "/handlerPlus")
    public String handler01(Model model) {
        List<String> list = new ArrayList<String>();
        list.add("这是List中要展示的信息！");
        model.addAttribute("内容", list);
        return "myView:/handlerPlus";
    }
}
