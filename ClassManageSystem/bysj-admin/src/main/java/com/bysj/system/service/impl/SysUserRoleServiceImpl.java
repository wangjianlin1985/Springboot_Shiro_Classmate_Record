package com.bysj.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bysj.system.domain.SysUserRole; 
import com.bysj.system.mapper.SysUserRoleMapper;
import com.bysj.system.service.ISysUserRoleService;


@Service
public class SysUserRoleServiceImpl implements ISysUserRoleService {

	@Autowired 
	private SysUserRoleMapper userRoleMapper;
	
	
	
	@Override
	public List<SysUserRole> selectUserRoleByUserId(Long userId) {
		// TODO Auto-generated method stub
		return userRoleMapper.selectUserRoleByUserId(userId);
	}

}
