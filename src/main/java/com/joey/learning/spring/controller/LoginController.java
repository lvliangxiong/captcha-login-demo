package com.joey.learning.spring.controller;

import com.joey.learning.spring.pojo.User;
import com.joey.learning.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author: Joey
 * @Date: 20/03/2020 10:13 AM
 */

@Controller
public class LoginController {
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("loginCheck")
    public String loginCheck(User user, String captcha, HttpSession session, Model model) {
        String targetCaptcha = (String) session.getAttribute("captcha");
        if (targetCaptcha.equals(captcha)) {
            if (userService.login(user) != null) {
                // Login successfully
                user.setPassword(null);
                session.setAttribute("user", user);
                // 重定向到 main，进入 main 对应的 Handler Method 进行处理
                return "redirect:/main";
            } else {
                // Username or password unmatched
                model.addAttribute("errorInfo", UserService.USERNAME_PASSWORD_MISMATCHED);
            }
        } else {
            // Captcha uncorrected
            model.addAttribute("errorInfo", UserService.CAPTCHA_WRONG);
        }
        // 为了使用请求转发和不使用自定义的视图解析器，手动加上 forward:/ 前缀
        return "forward:/";
    }
}
