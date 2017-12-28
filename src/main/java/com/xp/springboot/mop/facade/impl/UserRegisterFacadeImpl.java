package com.xp.springboot.mop.facade.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xp.springboot.mop.facade.UserRegisterFacade;
import com.xp.springboot.mop.service.UserRegisterService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service("userRegisterFacade")
public class UserRegisterFacadeImpl implements UserRegisterFacade {
    @Autowired
    private UserRegisterService userRegisterService;

    public Integer getUserCount() {
        log.error("test email-=---------------");
        Integer count = userRegisterService.getUserCount();
        BigDecimal a = new BigDecimal("");
        a.setScale(5);
        return count == null ? 0 : count;

    }

}
