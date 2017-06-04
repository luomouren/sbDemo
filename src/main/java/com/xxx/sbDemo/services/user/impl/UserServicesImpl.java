package com.xxx.sbDemo.services.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.sbDemo.mapper.user.UserMapper;
import com.xxx.sbDemo.model.User;
import com.xxx.sbDemo.services.user.UserServices;

/**
 * Created by Amy on 2017/6/4.
 */
@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    private UserMapper user;

    @Override
    public User findById(String id) {
        return user.findById(id);
    }

    @Override
    public void insert(String name, int age) {
    	user.insert(name,age);
    }
}
