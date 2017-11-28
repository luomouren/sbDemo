package com.xxx.demo.services.user.impl;

import com.xxx.demo.mapper.sys.SysUserMapper;
import com.xxx.demo.models.sys.SysUser;
import com.xxx.demo.services.user.SysUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luomouren
 */
@Service
public class SysUserServicesImpl implements SysUserServices {
    @Autowired
    private SysUserMapper user;

    @Override
    public SysUser findById(String id) {
        return user.findById(id);
    }


}
