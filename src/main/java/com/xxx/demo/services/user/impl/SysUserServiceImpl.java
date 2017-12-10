package com.xxx.demo.services.user.impl;

import com.alibaba.fastjson.JSONObject;
import com.xxx.demo.frame.constants.AppResultConstants;
import com.xxx.demo.frame.util.MD5Util;
import com.xxx.demo.mapper.sys.SysUserMapper;
import com.xxx.demo.models.sys.SysUser;
import com.xxx.demo.services.user.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 系统用户service
 *
 * @author luomouren
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 返回给APP端提示信息
     */
    public final static String USER_ID_ERROR = "用户主键不能为空";
    public final static String USER_ERROR = "用户信息错误";
    public final static String USER_NAME_ERROR = "账号不能为空";
    public final static String REAL_NAME_ERROR = "姓名不能为空";
    public final static String CELL_PHONE_ERROR = "手机号不能为空";
    public final static String EMODEL_ID_ERROR = "所属单位不能为空";
    public final static String PASSWORD_ERROR = "密码不能为空";
    public final static String PASSWORD_WRONG_ERROR = "密码错误";
    public final static String OLD_PASSWORD_ERROR = "原密码不能为空";
    public final static String OLD_PASSWORD_WRONG_ERROR = "原密码不能为空";
    public final static String NEW_PASSWORD_ERROR = "新密码不能为空";
    public final static String SAVE_SUCCESS = "保存成功";
    public final static String LOGIN_SUCCESS = "登录成功";

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findById(String id) {
        return sysUserMapper.findById(id);
    }

    @Override
    public SysUser findByUserName(String userName) {
        return sysUserMapper.findByUserName(userName);
    }

    @Override
    public void save(SysUser bean) {
        sysUserMapper.save(bean);
    }

    @Override
    public void delete(String[] userIds) {
        sysUserMapper.delete(userIds);
    }

    @Override
    public void update(SysUser bean) {
        sysUserMapper.update(bean);
    }

    @Override
    public void updatePassword(String userId, String oldPassword, String newPassword) {
        sysUserMapper.updatePassword(userId, oldPassword, newPassword);
    }

    @Override
    public void reSetPassword(String userId, String newPassword) {
        sysUserMapper.reSetPassword(userId, newPassword);
    }

    @Override
    public JSONObject registeredUser(String userName, String realName, String cellphone, String emodelId, String password, String email, String description) {
        JSONObject jsonObject = new JSONObject();

        // 1.校验参数合法性(userName、realName、cellphone、emodelId、password)
        if (null == userName || "".equalsIgnoreCase(userName)) {
            jsonObject.put(AppResultConstants.MSG, USER_NAME_ERROR);
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
        } else if (null == realName || "".equalsIgnoreCase(realName)) {
            jsonObject.put(AppResultConstants.MSG, REAL_NAME_ERROR);
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
        } else if (null == cellphone || "".equalsIgnoreCase(cellphone)) {
            jsonObject.put(AppResultConstants.MSG, CELL_PHONE_ERROR);
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
        } else if (null == emodelId || "".equalsIgnoreCase(emodelId)) {
            jsonObject.put(AppResultConstants.MSG, EMODEL_ID_ERROR);
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
        } else if (null == password || "".equalsIgnoreCase(password)) {
            jsonObject.put(AppResultConstants.MSG, PASSWORD_ERROR);
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
        } else {
            // AppResultConstants.FAIL_STATUS.保存用户
            // isPassed:APP申请注册账号是否审核通过.1审核通过；0待审核；AppResultConstants.FAIL_STATUS审核不通过
            // 密码加密-修改为前台加密
            // password = MD5Util.md5(password);
            SysUser bean = new SysUser(UUID.randomUUID() + "", userName, realName, password, email, cellphone, true, false, description, true, true, 0);

            //TODO AppResultConstants.FAIL_STATUS.1保存用户与区域的关系
            try {
                save(bean);
                // 3.组织返回信息
                jsonObject.put(AppResultConstants.MSG, SAVE_SUCCESS);
                jsonObject.put(AppResultConstants.STATUS, AppResultConstants.SUCCESS_STATUS);
            } catch (Exception e) {
                logger.error("registeredUser:" + e);
            }
        }
        return jsonObject;
    }

    @Override
    public JSONObject modifyUserInfo(String userId, String userName, String realName, String cellphone, String emodelId, String email, String description) {
        JSONObject jsonObject = new JSONObject();

        // 1.校验参数合法性(userId、userName、realName、cellphone、emodelId)
        if (null == userName || "".equalsIgnoreCase(userName)) {
            jsonObject.put(AppResultConstants.MSG, USER_NAME_ERROR);
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
        } else if (null == realName || "".equalsIgnoreCase(realName)) {
            jsonObject.put(AppResultConstants.MSG, REAL_NAME_ERROR);
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
        } else if (null == cellphone || "".equalsIgnoreCase(cellphone)) {
            jsonObject.put(AppResultConstants.MSG, CELL_PHONE_ERROR);
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
        } else if (null == emodelId || "".equalsIgnoreCase(emodelId)) {
            jsonObject.put(AppResultConstants.MSG, EMODEL_ID_ERROR);
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
        } else if (null == userId || "".equalsIgnoreCase(userId)) {
            jsonObject.put(AppResultConstants.MSG, USER_ID_ERROR);
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
        } else {
            // 更新用户信息
            //TODO 更新用户区域信息
            SysUser bean = new SysUser(userId, userName, realName, email, cellphone, description);
            try {
                update(bean);
                jsonObject.put(AppResultConstants.STATUS, AppResultConstants.SUCCESS_STATUS);
                jsonObject.put(AppResultConstants.MSG, SAVE_SUCCESS);
            } catch (Exception e) {
                logger.error("modifyUserInfo:" + e);
            }
        }
        return jsonObject;
    }

    @Override
    public JSONObject modifyUserPassword(String userId, String oldPassword, String newPassword) {
        JSONObject jsonObject = new JSONObject();
        // 校验参数合法性
        if (null == userId || "".equalsIgnoreCase(userId)) {
            jsonObject.put(AppResultConstants.MSG, USER_ID_ERROR);
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
        } else if (null == oldPassword || "".equalsIgnoreCase(oldPassword)) {
            jsonObject.put(AppResultConstants.MSG, OLD_PASSWORD_ERROR);
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
        } else if (null == newPassword || "".equalsIgnoreCase(newPassword)) {
            jsonObject.put(AppResultConstants.MSG, NEW_PASSWORD_ERROR);
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
        } else {
            try {
                SysUser sysUser = findById(userId);
                if(null!=sysUser && oldPassword.equalsIgnoreCase(sysUser.getUserPassword())){
                    updatePassword(userId, oldPassword, newPassword);
                    jsonObject.put(AppResultConstants.MSG, SAVE_SUCCESS);
                    jsonObject.put(AppResultConstants.STATUS, AppResultConstants.SUCCESS_STATUS);
                }else{
                    jsonObject.put(AppResultConstants.MSG, OLD_PASSWORD_WRONG_ERROR);
                    jsonObject.put(AppResultConstants.STATUS, AppResultConstants.SUCCESS_STATUS);
                }

            } catch (Exception e) {
                logger.error("modifyUserPassword:" + e);
            }
        }
        return jsonObject;
    }

    @Override
    public JSONObject resetUserPassword(String userId, String newPassword) {
        JSONObject jsonObject = new JSONObject();
        // 校验参数合法性
        if (null == userId || "".equalsIgnoreCase(userId)) {
            jsonObject.put(AppResultConstants.MSG, USER_ID_ERROR);
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
        } else if (null == newPassword || "".equalsIgnoreCase(newPassword)) {
            jsonObject.put(AppResultConstants.MSG, NEW_PASSWORD_ERROR);
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
        } else {
            try {
                reSetPassword(userId,newPassword);
                jsonObject.put(AppResultConstants.MSG, SAVE_SUCCESS);
                jsonObject.put(AppResultConstants.STATUS, AppResultConstants.SUCCESS_STATUS);
            } catch (Exception e) {
                logger.error("resetUserPassword:" + e);
            }
        }
        return jsonObject;
    }
}
