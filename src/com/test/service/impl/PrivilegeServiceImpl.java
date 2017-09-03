package com.test.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.base.BaseDaoImpl;
import com.test.domain.Privilege;
import com.test.service.PrivilegeService;

@SuppressWarnings("unchecked")
@Service
@Transactional
public class PrivilegeServiceImpl extends BaseDaoImpl<Privilege> implements PrivilegeService{

	
	@Override
	public List<Privilege> findTopList() {
		return getSession().createQuery(//
				"FROM Privilege P WHERE P.parent IS NULL")//
				.list();
	}

	@Override
	public Collection<String> getAllPrivilegeUrls() {
		return getSession().createQuery(//
				"SELECT DISTINCT P.url FROM Privilege P WHERE P.url IS NOT NULL")//
				.list();
	}

}
