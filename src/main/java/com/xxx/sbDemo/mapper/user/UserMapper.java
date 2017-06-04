package com.xxx.sbDemo.mapper.user;

import org.apache.ibatis.annotations.Param;

import com.xxx.sbDemo.model.User;

public interface UserMapper {

	/**
	 * 根据id查找用户
	 * @param id 用户主键
	 * @return
	 */
	public User findById(@Param("id") String id);

	/**
	 * 插入用户记录
	 * @param name 用户名称
	 * @param age 用户年龄
	 */
	public void insert(@Param("name") String name, @Param("age") int age);
}
