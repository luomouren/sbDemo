package com.xxx.demo.services.user.impl;

import com.xxx.demo.mapper.sys.SysUserMapper;
import com.xxx.demo.models.sys.SysUser;
import com.xxx.demo.services.user.SysUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统用户service
 * @author luomouren
 */
@Service
public class SysUserServicesImpl implements SysUserServices {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findById(String id) {
        return sysUserMapper.findById(id);
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
        sysUserMapper.updatePassword(userId,oldPassword,newPassword);
    }

    @Override
    public void reSetPassword(String userId, String newPassword) {
        sysUserMapper.reSetPassword(userId,newPassword);
    }

    @Override
    public SysUser findByUserName(String userName) {
        return sysUserMapper.findByUserName(userName);
    }
}
