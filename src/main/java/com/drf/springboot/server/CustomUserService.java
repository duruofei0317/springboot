package com.drf.springboot.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.drf.springboot.dao.SysRoleMapper;
import com.drf.springboot.dao.SysUserMapper;
import com.drf.springboot.dao.SysUserRolesMapper;
import com.drf.springboot.domain.SysRole;
import com.drf.springboot.domain.SysRoleExample;
import com.drf.springboot.domain.SysUser;
import com.drf.springboot.domain.SysUserExample;
import com.drf.springboot.domain.SysUserRolesExample;
import com.drf.springboot.domain.SysUserRolesKey;
import com.drf.springboot.domain.UserDetail;

@Service
public class CustomUserService implements UserDetailsService{

	@Autowired
	SysRoleMapper sysRoleMapper;
	@Autowired
	SysUserMapper sysUserMapper;
	@Autowired
	SysUserRolesMapper sysUserRolesMapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUserExample sysUserExample = new SysUserExample();
		sysUserExample.createCriteria().andUsernameEqualTo(username);
		List<SysUser> users= sysUserMapper.selectByExample(sysUserExample);
		if(users==null||users.isEmpty()||users.size()>1)
		{
			throw new UsernameNotFoundException("用户名不存在");
		}
		SysUser user =users.get(0);
		UserDetail userDetail =new UserDetail();
		userDetail.setId(user.getId());
		userDetail.setUsername(user.getUsername());
		userDetail.setPassword(user.getPassword());
		SysUserRolesExample sysUserRolesExample = new SysUserRolesExample();
		sysUserRolesExample.createCriteria().andUserIdEqualTo(user.getId());
		List<SysUserRolesKey> sysUserRolesKeys = sysUserRolesMapper.selectByExample(sysUserRolesExample);
		if(sysUserRolesKeys!=null&&!sysUserRolesKeys.isEmpty())
		{
			List<Integer> roleIds = new ArrayList<Integer>();
			for(SysUserRolesKey sysUserRolesKey:sysUserRolesKeys)
			{
				roleIds.add(sysUserRolesKey.getRoleId());
			}
			SysRoleExample sysRoleExample = new SysRoleExample();
			sysRoleExample.createCriteria().andIdIn(roleIds);
			List<SysRole>  roles=sysRoleMapper.selectByExample(sysRoleExample);
			userDetail.setRoles(roles);
		}
		return userDetail;
	}

}
