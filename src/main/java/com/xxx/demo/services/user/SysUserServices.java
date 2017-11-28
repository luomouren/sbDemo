package com.xxx.demo.services.user;

import com.xxx.demo.models.sys.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息
 * @author luomouren
 */
public interface SysUserServices {

    /**
     * 根据id查找用户
     * @param id 用户主键
     * @return
     */
    public SysUser findById(@Param("id") String id);


}

