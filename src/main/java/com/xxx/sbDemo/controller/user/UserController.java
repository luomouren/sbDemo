package com.xxx.sbDemo.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xxx.sbDemo.model.User;
import com.xxx.sbDemo.services.user.UserServices;

/**
 * Created by Amy on 2017/6/4.
 */
@RestController
@RequestMapping({"/user"})
public class UserController {
    @Autowired
    private UserServices userServices;

    @RequestMapping(value="/findById")
    @ResponseBody
    public String findById(String id) {
        User user = userServices.findById(id);
        System.out.println(user.getName() +"-----"+ user.getAge());
        return user.getName() +"-----"+ user.getAge();
    }
}


