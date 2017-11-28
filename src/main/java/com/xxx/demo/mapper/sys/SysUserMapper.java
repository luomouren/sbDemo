package com.xxx.demo.mapper.sys;

import com.xxx.demo.models.sys.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息
 * @author luomouren
 */
public interface SysUserMapper {

	/**
	 * 根据id查找用户
	 * @param userId 用户主键
	 * @return
	 */
	public SysUser findById(@Param("userId") String userId);

}
