package com.xxx.demo.controller.login;

import com.xxx.demo.services.login.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:登录
 * @author:@luomouren.
 * @Date:2017-12-03 16:53
 */
@RestController
@RequestMapping({"/login"})
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LoginService loginService;


    @RequestMapping(value = "login")
    @ResponseBody
    public String login() {

        return "";
    }
}
