package com.joey.learning.spring.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Joey
 * @version 1.0
 * @date 6/20/2020 10:51 PM
 */
@Slf4j
public class SecurityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*
         * If you request a login page, the application gives you that page.
         * If you request another page, the application first checks you login status, then decides whether
         * or not show you that page. If not, direct you to the login page.
         * */
        String contextPath = request.getContextPath();
        String requestURI = request.getRequestURI();
        log.debug("Request URI: {}, ContextPath: {}", requestURI, contextPath);
        if (requestURI.endsWith("loginCheck") || requestURI.endsWith("captcha")
                || request.getRequestURI().startsWith(contextPath + "/resources/")) {
            return true;
        } else {
            HttpSession session = request.getSession(false);
            if (session != null && session.getAttribute("user") != null) {
                return true;
            }
        }
        response.sendRedirect("/captcha_login_demo/");
        return false;
    }
}
