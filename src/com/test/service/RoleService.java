package com.test.service;

import java.util.List;

import com.test.base.BaseDao;
import com.test.domain.Role;

public interface RoleService extends BaseDao<Role> {

	List<Role> findAll();

	void delete(Long id);

	void save(Role role);

	Role getById(Long id);

	void update(Role role);

}
