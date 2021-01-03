package com.dg.vote.cotroller.user;

import com.dg.vote.dao.UserMapper;
import com.dg.vote.model.User;
import com.dg.vote.service.UserService;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @RequestMapping("/user/toRegister")
    public String toRegister(){
        return "user/register";
    }

    @PostMapping("/user/register")
    public String register(String nickname, String username, String password, Model model) {
        User user = new User(nickname, username, password);
        System.out.println(user);

        try {
            userService.insertUser(user);
        } catch (Exception e) {
            model.addAttribute("msg", "注册失败");
            return "user/register";
        }

        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());
        return "user/login";
    }
}
