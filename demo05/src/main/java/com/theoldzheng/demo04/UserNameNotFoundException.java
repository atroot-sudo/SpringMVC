package com.theoldzheng.demo04;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.4.13 21:17
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "就不给你显示，测试自定义异常")
public class UserNameNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

}
