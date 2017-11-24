package com.xp.springboot.mop.controller.web;


import javax.servlet.http.HttpServletRequest;

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
* @ClassName: ShowpicController 
* @Description: showPic
* @author peng.xu
* @date 2017年11月23日 下午5:11:46 
*
 */
@Slf4j
@RestController
@RequestMapping("/mop/app/showpic")
public class ShowpicController {
    
    @Autowired
    private UserRegisterFacade userRegisterFacade;
    
    @RequestMapping("/list/picture")
    public Integer listPicture(Model model){
        log.info("picture start");
        Integer num = 0;
        num = 1;
        log.info("picture 查询出数据结果为:{}"+num);
        model.addAttribute("",0);
        return num;
    }
    @RequestMapping("/list/PictureInCache")
    public String listPictureInCache(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
    @PostMapping(value = "/get/test")
    public String test(HttpServletRequest request){
        Integer num = userRegisterFacade.getUserCount();
        return String.valueOf(num);
    }
    
}
