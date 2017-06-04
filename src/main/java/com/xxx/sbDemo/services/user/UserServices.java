package com.xxx.sbDemo.services.user;

import com.xxx.sbDemo.model.User;

/**
 * Created by Amy on 2017/6/4.
 */
public interface UserServices {

    /**
     * 根据id查找用户
     * @param id 用户主键
     * @return
     */
    public User findById(String id);

    /**
     * 插入用户记录
     * @param name 用户名称
     * @param age 用户年龄
     */
    public void insert(String name,int age);
}

