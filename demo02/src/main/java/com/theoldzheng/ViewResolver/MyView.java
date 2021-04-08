package com.theoldzheng.ViewResolver;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Description: 自定义视图
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.4.8 9:43
 */
public class MyView implements View {
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("render 执行" + model);
        response.setContentType("text/html"); //解决乱码问题
        response.getWriter().write("<h1>This is a test for myViewResolver! </h1> <br/>" + model);
    }
}
