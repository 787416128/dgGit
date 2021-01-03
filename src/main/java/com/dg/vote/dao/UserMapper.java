package com.dg.vote.dao;


import com.dg.vote.model.User;
import com.dg.vote.model.UserVotes;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {
    User queryUserByName(String name);

    int insertUser(User user);

    int deleteUser(String nickname);

    int updateUser(User user);

    //查询所有用户及已发表投票数
    List<UserVotes> getUVList();
}
