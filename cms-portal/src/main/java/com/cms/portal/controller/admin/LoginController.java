package com.cms.portal.controller.admin;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class LoginController {
    @Autowired
    private Producer captchaProducer;

    @GetMapping("login.do")
    public String toLogin(){
        return "/admin/login";
    }

    @GetMapping("captcha.do")
    public void doCaptcha(HttpServletResponse response){
        String text = captchaProducer.createText();
        BufferedImage image = captchaProducer.createImage(text);

        try(ServletOutputStream outputStream = response.getOutputStream()){
            ImageIO.write(image,"jpg",outputStream);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
