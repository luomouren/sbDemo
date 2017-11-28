package com.xxx.demo.controller.user;

import com.xxx.demo.models.sys.SysUser;
import com.xxx.demo.services.user.SysUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息
 * @author luomouren
 * @date 2017/6/4
 */
@RestController
@RequestMapping({"/user"})
public class UserController {
    @Autowired
    private SysUserServices sysUserServices;

    @RequestMapping(value="/findById")
    @ResponseBody
    public String findById(String id) {
        SysUser user = sysUserServices.findById(id);

        return "";
    }
}


