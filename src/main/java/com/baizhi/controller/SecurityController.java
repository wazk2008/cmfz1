package com.baizhi.controller;

import com.baizhi.utils.SecurityCode;
import com.baizhi.utils.SecurityImage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RequestMapping("security")
@Controller
public class SecurityController {

    @RequestMapping("getCode")
    public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        得到数字验证码
        String securityCode = SecurityCode.getSecurityCode();
        System.out.println("后台验证码："+securityCode);
//        将数字验证码存到数据库
        request.getSession().setAttribute("securityCode",securityCode);
//        生成图片验证码
        BufferedImage image = SecurityImage.createImage(securityCode);
//        设置相应格式
        response.setContentType("image/png");
//        输出图片验证码
        ImageIO.write(image,"png",response.getOutputStream());
    }


}
