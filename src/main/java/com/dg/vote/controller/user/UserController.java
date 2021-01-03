package com.dg.vote.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
