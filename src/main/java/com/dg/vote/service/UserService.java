package com.dg.vote.service;

import com.dg.vote.model.User;
import com.dg.vote.model.UserVotes;
import com.dg.vote.model.Vote;

import java.util.List;

public interface UserService {
    User queryUserByName(String name);

    int insertUser(User user);

    List<UserVotes> getUVList();

    int deleteUser(String nickname);
}
