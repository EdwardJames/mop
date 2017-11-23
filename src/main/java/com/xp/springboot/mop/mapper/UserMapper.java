package com.xp.springboot.mop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xp.springboot.mop.domain.user.User;

public interface UserMapper {
    Integer getUserCount();
    Integer batchInsert(@Param("list")List<User> userList);
}
