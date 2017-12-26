package com.drf.springboot.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.drf.springboot.dao.NameMapper;
import com.drf.springboot.dao.UserMapper;
import com.drf.springboot.domain.Name;
import com.drf.springboot.domain.User;

@Service
public class FirstServer 
{
	@Autowired
	NameMapper nameMapper;
	@Autowired
	UserMapper userMapper;
	
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void add()
	{
		User user = new User();
		user.setName1("dd");
		user.setName2("bb");
		userMapper.insert(user);
		Name name = new Name();
		name.setName("sa");
		nameMapper.insert(name);
	}
	@Cacheable(value="accountCache")
	public User get()
	{
		return userMapper.selectByPrimaryKey(6);
	}
}
