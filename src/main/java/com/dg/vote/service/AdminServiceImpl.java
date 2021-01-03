package com.dg.vote.service;

import com.dg.vote.dao.AdminMapper;
import com.dg.vote.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) {
        Admin admin1 = adminMapper.queryAdmin(admin);
        return admin1;
    }
}
