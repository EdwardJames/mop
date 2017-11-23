package com.xp.springboot.mop.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xp.springboot.mop.facade.UserRegisterFacade;
import com.xp.springboot.mop.service.UserRegisterService;
@Service("userRegisterFacade")
public class UserRegisterFacadeImpl implements UserRegisterFacade {
    @Autowired
    private UserRegisterService userRegisterService;
    public Integer getUserCount() {
        Integer count = userRegisterService.getUserCount();
        return count==null?0:count;
        
    }
    

}
