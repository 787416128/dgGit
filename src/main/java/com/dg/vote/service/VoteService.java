package com.dg.vote.service;

import com.dg.vote.model.User;
import com.dg.vote.model.Vote;

import java.util.List;

public interface VoteService {
    List<Vote> queryVoteByUser(String nickname);

    List<Vote> queryVote();

    int updateVote(Vote vote);

    Vote queryVoteById(Integer id);

    int deleteVoteById(Integer id);

    int addVote(Vote vote);
}
