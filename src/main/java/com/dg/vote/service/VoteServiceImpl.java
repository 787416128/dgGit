package com.dg.vote.service;

import com.dg.vote.dao.VoteMapper;
import com.dg.vote.model.User;
import com.dg.vote.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService{
    @Autowired
    VoteMapper voteMapper;

    @Override
    public List<Vote> queryVoteByUser(String nickname) {
        return voteMapper.queryVoteByUserNickname(nickname);
    }

    @Override
    public List<Vote> queryVote() {
        return voteMapper.queryVote();
    }

    @Override
    public int updateVote(Vote vote) {
        return voteMapper.updateVote(vote);
    }

    @Override
    public Vote queryVoteById(Integer id) {
        return voteMapper.queryVoteById(id);
    }

    @Override
    public int deleteVoteById(Integer id) {
        return voteMapper.deleteVote(id);
    }

    @Override
    public int addVote(Vote vote) {
        return voteMapper.addVote(vote);
    }
}
