package com.joey.learning.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Author: Joey
 * @Date: 20/03/2020 9:04 AM
 */
@Controller
public class CaptchaController {
    Random random = new Random();

    @RequestMapping("captcha")
    public void captcha(HttpServletResponse resp, HttpSession session) throws IOException {
        // 打印流，用于输出字符，与getOutputStream()不能同时使用
        // PrintWriter writer = resp.getWriter();
        // 响应字节流，用于响应二进制文件
        ServletOutputStream os = resp.getOutputStream();

        // 用于存放生成的验证码
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int randomNum = random.nextInt(10);
            sb.append(randomNum);
        }
        BufferedImage image = generateCaptcha(180, 25, sb);

        // 使用工具类输出此图片
        ImageIO.write(image, "jpg", os);

        // 将生成的验证码存放在Session中，当用户登录时可以进行校验
        session.setAttribute("captcha", sb.toString());
    }

    protected BufferedImage generateCaptcha(int width, int height, StringBuilder sb) {
        // 创建一个图片对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 在图片上创建一个画板
        Graphics2D gra = image.createGraphics();
        // 设置画笔颜色
        gra.setColor(Color.WHITE);
        // 填充整个图片为白色
        gra.fillRect(0, 0, width, height);
        // 设置画笔的属性
        int fontSize = 20; // 字体大小
        Font font = new Font("宋体", Font.BOLD | Font.ITALIC, fontSize);
        gra.setFont(font);
        // 产生一个颜色数组，用于生成随机颜色
        Color[] colors = new Color[]{Color.BLACK, Color.BLUE, Color.CYAN, Color.magenta, Color.orange, Color.RED};
        for (int i = 0; i < sb.length(); i++) {
            gra.setColor(colors[random.nextInt(colors.length)]);
            // 通过随机数可以设置验证码的数字的字体、颜色、位置、角度
            gra.drawString(String.valueOf(sb.charAt(i)),
                    (width - 20) / 4 * i + 20, (height + fontSize) / 2);
        }
        // 添加无用信息，防止破解
        gra.setColor(colors[random.nextInt(colors.length)]);
        gra.drawLine(0, random.nextInt(height), width, random.nextInt(height));
        return image;
    }
}
