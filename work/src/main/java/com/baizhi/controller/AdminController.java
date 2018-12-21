package com.baizhi.controller;

import com.baizhi.conf.CreateValidateCode;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    //验证码
    @RequestMapping("/code")
    public String code(HttpServletResponse response, HttpSession session) {
        CreateValidateCode ctv = new CreateValidateCode();
        String code = ctv.getCode();
        session.setAttribute("code", code);
        ServletOutputStream os = null;
        try {
            os = response.getOutputStream();
            ctv.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "login";
    }

    //登录
    @RequestMapping("/login")
    @ResponseBody
    public void login(Admin admin, HttpSession session, HttpServletResponse response, String code) throws IOException {
        session.setAttribute("admin", admin);
        adminService.login(admin.getName(), admin.getPassword());
        PrintWriter out = response.getWriter();
        String number = (String) session.getAttribute("code");
        if (code.equals(number)) {
            out.print("ok");
        }
    }

    //退出
    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        session.removeAttribute("admin");
        return "redirect:/login.jsp";
    }

}
