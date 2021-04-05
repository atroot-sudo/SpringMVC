package com.theoldzheng.controller;

import com.theoldzheng.pojo.Address;
import com.theoldzheng.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.4.3 12:56
 */
@Controller
@RequestMapping("/test")
public class MyFirstMVC {

    @RequestMapping(value = "/{id}/hello")
    public String test(@PathVariable("id") String id) {
        System.out.println("loading...");
        return "success";
    }


    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public String getBook(@PathVariable("id") String id) {
        System.out.println("查询图书 " + id + " 成功！");
        return "success";
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String addBook() {
        System.out.println("添加成功！");
        return "success";
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("id") String id) {
        System.out.println("删除图书 " + id + " 成功！");
        return "success";
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
    public String updateBook(@PathVariable("id") String id) {
        System.out.println("更新图书 " + id + " 成功！");
        return "success";
    }


    @RequestMapping(value = "/helloWorld")
    public String helloWorld(@RequestParam(value = "username", defaultValue = "没带", required = false) String username,
                             @RequestHeader(value = "User-Agent", defaultValue = "也没带！", required = false) String Header,
                             @CookieValue(value = "JSESSIONID", defaultValue = "它也没带！", required = false) String jid) {
        System.out.println("获取请求参数为：  " + username);
        System.out.println("获取请求头参数为：  " + Header);
        System.out.println("获取Cookie JSESSIONID 为：  " + jid);

        return "success";
    }

    @RequestMapping(value = "/buyBook")
    public String buyBook(Book book) {
        System.out.println(book);
        return "success";
    }

    @RequestMapping(value = "/handle01")
    public String handle(HttpServletRequest req, HttpSession session) {
        req.setAttribute("msg", "二郎神");
        session.setAttribute("msg", "三只眼睛");
        return "success";
    }

    @RequestMapping(value = "/handle02")
    public String handle01(Map<String, String> map) {
        map.put("msg", "map");
        return "success";
    }

    @RequestMapping(value = "/handle03")
    public String handle02(Model model) {
        model.addAttribute("msg", "model");
        return "success";
    }

    @RequestMapping(value = "/handle04")
    public String handle03(ModelMap modelMap) {
        modelMap.put("msg", "map");
        modelMap.addAttribute("msg", "modelMap");
        return "success";
    }

    @RequestMapping(value = "/handle05")
    public ModelAndView handle04() {
        //视图名视图解析器会帮我们最终得到页面的真实地址
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("msg", "modelAndView");
        return modelAndView;
    }

    @ModelAttribute //标记该方法优先执行于目标方法
    public void handle05(Map<String,Object> map){
        Book book = new Book("张三流浪记", "罗翔", "12.6", "10", "22", new Address("黄山", "洪山"));
        map.put("book",book);
        System.out.println("@ModelAttribute...执行，取出数据");
    }
    @RequestMapping(value = "/handle06")
    public void handle06(@ModelAttribute("book") Book book){
        System.out.println(book);
    }
}