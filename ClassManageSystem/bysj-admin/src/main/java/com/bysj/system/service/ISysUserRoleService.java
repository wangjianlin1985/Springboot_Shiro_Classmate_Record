package com.bysj.system.service;

import java.util.List;

import com.bysj.system.domain.SysUserRole;

public interface ISysUserRoleService {
	/**
     * 通过用户ID查询用户和角色关联
     * 
     * @param userId 用户ID
     * @return 用户和角色关联列表
     */
    public List<SysUserRole> selectUserRoleByUserId(Long userId);
}
