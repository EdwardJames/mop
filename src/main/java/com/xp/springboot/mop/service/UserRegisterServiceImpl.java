package com.xp.springboot.mop.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.xp.springboot.mop.domain.user.User;
import com.xp.springboot.mop.mapper.UserMapper;
@Service("userRegisterService")
public class UserRegisterServiceImpl implements UserRegisterService {
    private Logger logger = LoggerFactory.getLogger(UserRegisterServiceImpl.class);
    
    @Autowired
    private UserMapper userMapper;

    public Integer getUserCount() {
        return userMapper.getUserCount();
    }
    @Transactional(rollbackFor = Exception.class, readOnly = false, timeout = 10)
    @Override
    public Integer batchInsert(List<User> userList) {
        logger.info("batchInsert 批量插入user:{}",JSONObject.toJSON(userList));
        Integer insertResult = userMapper.batchInsert(userList);
        if(insertResult!=null && insertResult>0){
           return insertResult;
        }
        return null;
    }

}
