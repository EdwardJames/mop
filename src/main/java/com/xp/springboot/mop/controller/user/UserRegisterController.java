package com.xp.springboot.mop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xp.springboot.mop.facade.UserRegisterFacade;

import lombok.extern.slf4j.Slf4j;
/**
 * 
* @ClassName: UserRegisterController 
* @Description: TODO
* @author peng.xu
* @date 2017年11月23日 下午5:14:00 
*
 */
@Slf4j
@RestController
@RequestMapping("/mop/app/userRegister")
public class UserRegisterController {
    
    @Autowired
    private UserRegisterFacade userRegisterFacade;
    @RequestMapping("/getUserCount")
    public Model getUserCount(Model model){
        log.info("getUserCount start");
        Integer num = 0;
        num = 1;
        log.info("getUserCount 查询出数据结果为:{}",num);
        model.addAttribute("",0);
        return model;
    }
    @RequestMapping("/test2")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
    
}
