package com.test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.base.BaseDaoImpl;
import com.test.domain.User;
import com.test.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends BaseDaoImpl<User> implements UserService {

	@Override
	public User findByLoginNameAndPassword(String loginName, String password) {
		//使用md5密码的摘要进行对比
//		String md5Digest = DigestUtils.md5Hex(password);
		String md5Digest =password;
		return (User) getSession().createQuery(//
				"FROM User u WHERE u.loginName=? AND u.password=?")//
				.setParameter(0, loginName)//
				.setParameter(1, md5Digest)//
				.uniqueResult();
	}

}
