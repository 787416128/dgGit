package com.dg.vote.dao;

import com.dg.vote.model.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    Admin queryAdmin(Admin admin);
}
