package com.dg.vote;

import com.dg.vote.service.VoteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VoteApplicationTests {

    @Autowired
    VoteService voteService;

    @Test
    void contextLoads() {
        System.out.println(voteService.queryVoteByUser("raydg"));
    }

}
