package com.xxx.demo.controller.user;

import com.xxx.demo.models.sys.SysUser;
import com.xxx.demo.services.user.SysUserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息
 *
 * @author luomouren
 * @date 2017/6/4
 */
@RestController
@RequestMapping({"/user"})
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SysUserServices sysUserServices;

    @RequestMapping(value = "/findById")
    @ResponseBody
    public String findById(String id) {
        SysUser user = sysUserServices.findById(id);
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");
        return "";
    }

    @RequestMapping(value = "/findById")
    @ResponseBody
    public String login(String userName, String password) {

        return "";
    }

    @RequestMapping(value = "/registeredUser")
    @ResponseBody
    public String registeredUser(String userName, String realName, String cellphone, String emodelId, String password, String email, String description) {

        return "";
    }

    @RequestMapping(value = "/modifyUserInfo")
    @ResponseBody
    public String modifyUserInfo(String userId,String userName,String realName,String cellPhone,String emodelId,String email,String description){
        return "";
    }

    @RequestMapping(value = "/modifyUserPassword")
    @ResponseBody
    public String modifyUserPassword(String userId,String oldPassword,String newPassword){
        return "";
    }

    @RequestMapping(value = "/resetUserPassword")
    @ResponseBody
    public String resetUserPassword(String userid,String newPassword){
        return "";
    }
}


