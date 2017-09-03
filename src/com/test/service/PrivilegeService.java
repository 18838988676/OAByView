package com.test.service;

import java.util.Collection;
import java.util.List;

import com.test.base.BaseDao;
import com.test.domain.Privilege;

public interface PrivilegeService extends BaseDao<Privilege>{

	/**
	 * 查询所有顶级权限
	 * @return
	 */
	List<Privilege> findTopList();

	/**
	 * 查询所有权限对应的URL集合（不重复）
	 * @return
	 */
	Collection<String> getAllPrivilegeUrls();

}
