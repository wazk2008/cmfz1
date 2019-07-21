package com.baizhi.controller;

import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("admin")
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    @ResponseBody
    public Map<String,Object> login(String username, String password, String enCode, HttpServletRequest request){
        Map<String, Object> map = new HashMap<String,Object>();
        try {
            adminService.login(username,password,enCode,request);
            map.put("status",true);
        } catch (Exception e) {
            map.put("status",false);
            map.put("message",e.getMessage());
        }
        return map;
    }

    @RequestMapping("exit")
    public String exit(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("loginAdmin");
        return "redirect:/login/login.jsp";
    }

}
