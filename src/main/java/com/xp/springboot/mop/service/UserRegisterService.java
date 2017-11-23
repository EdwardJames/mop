package com.xp.springboot.mop.service;

import java.util.List;

import com.xp.springboot.mop.domain.user.User;


public interface UserRegisterService {
    Integer getUserCount();
    Integer batchInsert(List<User> userList);
}
