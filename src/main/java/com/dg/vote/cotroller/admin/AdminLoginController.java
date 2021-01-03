package com.dg.vote.cotroller.admin;

import com.dg.vote.model.Admin;
import com.dg.vote.model.User;
import com.dg.vote.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminLoginController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/admin")
    public String adminToLogin() {
        return "admin/login";
    }

    @PostMapping("/admin/login")
    public String adminLogin(String username, String password, Model model, HttpSession session) {
        Admin admin = new Admin(username, password);
        Admin admin1 = null;
        try {
            admin1 = adminService.login(admin);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (admin1 == null){
            model.addAttribute("msg", "用户名或密码错误");
            return "admin/login";
        }else{
            session.setAttribute("loginAdmin",admin1);
            model.addAttribute("admin", admin1.getName());
            return "admin/adminCentral";
        }

    }

    @RequestMapping("/admin/logout")
    public String adminLogout() {
        return "admin/login";
    }
}
