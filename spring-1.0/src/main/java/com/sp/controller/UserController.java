package com.sp.controller;

import com.sp.pojo.User;
import com.sp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/findAll")
    public String findAll(){
        userService.findAll().forEach(e->{
            System.out.println(e.toString());
        });
        return "index";
    }

    @RequestMapping("/addUser")
    public String addUser(User user){
        System.out.println(user.toString());
        return "add";
    }

    public User findUser(int id){
        return userService.findUser(id);
    }
}
