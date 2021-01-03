package com.dg.vote.controller.user;

import com.dg.vote.model.User;
import com.dg.vote.model.Vote;
import com.dg.vote.service.VoteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class VoteController {

    @Autowired
    VoteService voteService;

//    @RequestMapping("/user/voteManager")
//    public String getVoteList(Model model, HttpSession session,
//                              @RequestParam(value = "pn", defaultValue = "1")Integer pn) {
//        User user = (User) session.getAttribute("loginUser");
//        List<Vote> vList = new ArrayList<>();
//
//        PageHelper.startPage(pn ,8);
//        vList = voteService.queryVoteByUser(user.getNickname());
//        PageInfo page = new PageInfo(vList, 8);
//
//        model.addAttribute("vList", page);
//        return "user/voteList";
//    }

    @RequestMapping("/user/voteManage")
    public String getVoteList(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        List<Vote> vList = new ArrayList<>();

        vList = voteService.queryVoteByUser(user.getNickname());

        model.addAttribute("vList", vList);
        return "user/voteList";
    }

    @ResponseBody
    @GetMapping("/vote")
    public String getIndexVote() {
        List<Vote> vList = new ArrayList<>();
        vList = voteService.queryVote();
        ObjectMapper mapper = new ObjectMapper();
        String vListJson = null;
        try {
            vListJson = mapper.writeValueAsString(vList);
        } catch (JsonProcessingException e) {
            vListJson = "[]";
        }
        return vListJson;
    }

    @PostMapping("user/vote/update")
    public String updateVote(@RequestParam("id") Integer id,@RequestParam("subject") String subject,Model model) {
        Vote vote = voteService.queryVoteById(id);
        System.out.println(vote);
        vote.setSubject(subject);
        int count = voteService.updateVote(vote);
        if(count != 0){
            model.addAttribute("msg", "更改成功");
            return "redirect:/user/voteManage";
        }else{
            model.addAttribute("msg", "更改失败");
            return "redirect:/user/voteManage";
        }

    }

    @GetMapping("user/vote/delete")
    public String deleteVote(@RequestParam("id") Integer id,Model model) {
        int count = voteService.deleteVoteById(id);
        if(count != 0){
            model.addAttribute("msg", "删除成功");
            return "redirect:/user/voteManage";
        }else{
            model.addAttribute("msg", "删除失败");
            return "redirect:/user/voteManage";
        }
    }

    @PostMapping("user/vote/add")
    public String addVote(HttpSession session,
                          Model model,
                          @RequestParam("subject") String subject,
                          @RequestParam("start_time") String start_time,
                          @RequestParam("end_time") String end_time,
                          @RequestParam("selection_type") Integer selection_type,
                          @RequestParam("content") String content) throws ParseException {
        Integer userId = ((User)session.getAttribute("loginUser")).getId();
        System.out.println("用户" + userId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start_date = simpleDateFormat.parse(start_time);
        Date end_date = simpleDateFormat.parse(end_time);
        Vote vote = new Vote(subject, content, selection_type, userId, start_date, end_date);
        int count = voteService.addVote(vote);
        if(count != 0){
            model.addAttribute("msg", "创建成功");
            return "redirect:/user/voteManage";
        }else{
            model.addAttribute("msg", "创建失败");
            return "redirect:/user/voteManage";
        }
    }
}
