package com.test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.base.BaseDaoImpl;
import com.test.domain.Role;
import com.test.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl extends BaseDaoImpl<Role> implements RoleService{



//	@Resource
//	private RoleDao roleDao;
//	
//	@Override
//	public List<Role> findAll() {
//		return roleDao.findAll();
//	}
//
//	@Override
//	public void delete(Long id) {
//		roleDao.delete(id);
//	}
//
//	@Override
//	public void save(Role role) {
//		roleDao.save(role);
//		
//	}
//
//	@Override
//	public Role getById(Long id) {
//		return roleDao.getById(id);
//	}
//
//	@Override
//	public void update(Role role) {
//		roleDao.update(role);
//	}

}
