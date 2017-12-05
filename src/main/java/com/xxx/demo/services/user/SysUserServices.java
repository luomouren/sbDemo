package com.xxx.demo.services.user;

import com.xxx.demo.models.sys.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息
 *
 * @author luomouren
 */
public interface SysUserServices {

    /**
     * 根据id查找用户
     *
     * @param id 用户主键
     * @return
     */
    SysUser findById(String id);

    /**
     * 根据用户名查找用户
     * @param userName 用户名
     * @return
     */
    SysUser findByUserName(String userName);

    /**
     * 保存用户
     *
     * @param bean 用户bean
     */
    void save(SysUser bean);

    /**
     * 删除用户
     *
     * @param userIds 用户主键数组
     */
    void delete(String[] userIds);

    /**
     * 更新用户（密码不用更新）
     *
     * @param bean 用户bean
     */
    void update(SysUser bean);

    /**
     * 修改用户密码
     *
     * @param userId      用户主键
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     */
    void updatePassword(String userId, String oldPassword, String newPassword);

    /**
     * 重置用户密码
     *
     * @param userId
     * @param newPassword
     */
    void reSetPassword(String userId, String newPassword);
}

