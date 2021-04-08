package com.theoldzheng.ViewResolver;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * Description: 自定义视图解析器
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.4.8 9:19
 */
public class MyViewResolver implements ViewResolver, Ordered {
    private Integer order = 0;

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        if (viewName.startsWith("myView:")) {
            return new MyView();
        } else {
            return null;
        }
    }

    @Override
    public int getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

}
