package com.theoldzheng.controller;

import com.theoldzheng.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
                             @RequestHeader(value = "User-Agent",defaultValue = "也没带！",required = false) String Header,
                             @CookieValue(value = "JSESSIONID",defaultValue = "它也没带！",required = false) String jid) {
        System.out.println("获取请求参数为：  " + username);
        System.out.println("获取请求头参数为：  " + Header);
        System.out.println("获取Cookie JSESSIONID 为：  " + jid);

        return "success";
    }

    @RequestMapping(value = "/buyBook")
    public String buyBook(Book book){
        System.out.println(book);
        return "success";
    }

}