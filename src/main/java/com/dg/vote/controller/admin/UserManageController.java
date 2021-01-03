package com.dg.vote.controller.admin;

import com.dg.vote.model.UserVotes;
import com.dg.vote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserManageController {

    @Autowired
    UserService userService;

    @RequestMapping("/admin/userManage")
    public String getVoteList(Model model) {
        List<UserVotes> uList = new ArrayList<>();

        uList = userService.getUVList();
        System.out.println(uList);

        model.addAttribute("uList", uList);
        return "admin/userList";
    }

    @RequestMapping("/admin/userManage/delete")
    public String deleteUser(@RequestParam("nickname") String nickname,Model model) {
        try {
            userService.deleteUser(nickname);
            System.out.println("删除成功");
        } catch (Exception e) {
            model.addAttribute("msg", "删除失败");
            return "redirect:/admin/userList";
        }

        return "redirect:/admin/userList";
    }
}
