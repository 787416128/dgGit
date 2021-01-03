package com.dg.vote;

import com.dg.vote.model.Vote;
import com.dg.vote.service.VoteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class voteTest {

    @Autowired
    VoteService voteService;

    @Test
    void contextLoads() {
        List<Vote> vList = new ArrayList<>();
        vList = voteService.queryVote();
        ObjectMapper mapper = new ObjectMapper();
        String vListJson = null;
        try {
            vListJson = mapper.writeValueAsString(vList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(vListJson);
    }
}
