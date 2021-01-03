package com.dg.vote.service;

import com.dg.vote.dao.UserMapper;
import com.dg.vote.model.User;
import com.dg.vote.model.UserVotes;
import com.dg.vote.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public List<UserVotes> getUVList() {
        return userMapper.getUVList();
    }

    @Override
    public int deleteUser(String nickname) {
        return userMapper.deleteUser(nickname);
    }


}
