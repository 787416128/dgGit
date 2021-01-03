package com.dg.vote.cotroller.user;

import com.dg.vote.dao.UserMapper;
import com.dg.vote.model.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    //    //不跳转，只返回
    //    @ResponseBody
    @RequestMapping("/noauth")
    public String unauthorized() {
        return "user/login";
    }

    @RequestMapping("/user/userCentral")
    public String userCentral(Model model) {
        return "user/userCentral";
    }
}
