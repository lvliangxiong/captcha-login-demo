package com.joey.learning.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Joey
 * @version 1.0
 * @date 6/20/2020 11:38 PM
 */
@Controller
public class PageController {
    @RequestMapping("{page}")
    public String main(@PathVariable("page") String page) {
        // 视图解析器将会对此请求转发进行前后缀处理，从而让我们能够到达 /WEB-INF/page/page.jsp
        return page;
    }
}
