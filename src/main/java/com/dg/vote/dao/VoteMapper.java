package com.dg.vote.dao;

import com.dg.vote.model.User;
import com.dg.vote.model.Vote;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteMapper {
    //根据用户昵称查询已发起的投票
    List<Vote> queryVoteByUserNickname(String nickname);

    //根据用户昵称查询投票记录
    List<Vote> queryVotedByUserNickname(String nickname);

    //查询所有已发起并审核通过的投票
    List<Vote> queryVote();

    //发起投票
    int addVote(Vote vote);

    //编辑投票
    int updateVote(Vote vote);

    //删除投票
    int deleteVote(Integer id);

    //查询所有投票，包括待审核投票
    List<Vote> queryNotApproveVote();

    //根据Id查投票
    Vote queryVoteById(Integer id);

}
