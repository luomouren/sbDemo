package com.xxx.demo.services.login.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xxx.demo.frame.constants.AppResultConstants;
import com.xxx.demo.frame.util.TokenUtils;
import com.xxx.demo.mapper.sys.SysUserMapper;
import com.xxx.demo.models.sys.SysUser;
import com.xxx.demo.services.login.LoginService;
import com.xxx.demo.services.user.impl.SysUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:登录接口实现
 * @author:@luomouren.
 * @Date:2017-12-10 12:00
 */
@Service
public class LoginServiceImpl implements LoginService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public JSONObject login(String userName, String password) {
        JSONObject jsonObject = new JSONObject();

        // 判断【用户名】、【密码】参数合法性
        if (null == userName || "".equalsIgnoreCase(userName)) {
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
            jsonObject.put(AppResultConstants.MSG, SysUserServiceImpl.USER_NAME_ERROR);
        } else if (null == password || "".equalsIgnoreCase(password)) {
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
            jsonObject.put(AppResultConstants.MSG, SysUserServiceImpl.PASSWORD_ERROR);
        } else {
            // 查找用户，判断用户账号密码是否正确
            SysUser sysUser = sysUserMapper.findByUserName(userName);
            if (null == sysUser) {
                jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
                jsonObject.put(AppResultConstants.MSG, SysUserServiceImpl.USER_ERROR);
            } else if (!password.equalsIgnoreCase(sysUser.getUserPassword())) {
                jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
                jsonObject.put(AppResultConstants.MSG, SysUserServiceImpl.PASSWORD_WRONG_ERROR);
            } else {
                // 账号密码正确，生成token
                String accessToken = TokenUtils.createJwtToken(userName);
                jsonObject.put(AppResultConstants.DATA, accessToken);
                jsonObject.put(AppResultConstants.STATUS, AppResultConstants.SUCCESS_STATUS);
                jsonObject.put(AppResultConstants.MSG, SysUserServiceImpl.LOGIN_SUCCESS);
            }
        }

        return jsonObject;
    }

    @Override
    public JSONObject logout(String userName) {
        return null;
    }
}
