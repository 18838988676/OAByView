package com.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.base.BaseDaoImpl;
import com.test.domain.Department;
import com.test.service.DepartmentService;

@SuppressWarnings("unchecked")
@Service
@Transactional
public class DepartmentServiceImpl extends BaseDaoImpl<Department> implements DepartmentService {

//	
//	@Resource
//	private DepartmentDao departmentDao;
//	
//	@Override
//	public List<Department> findAll() {
//		return departmentDao.findAll();
//	}
//
//	@Override
//	public void delete(Long id) {
//		departmentDao.delete(id);
//	}
//
//	@Override
//	public void save(Department department) {
//		departmentDao.save(department);
//	}
//
//	@Override
//	public Department getById(Long id) {
//		return departmentDao.getById(id);
//	}
//
//	@Override
//	public void update(Department department) {
//		departmentDao.update(department);
//	}
//
//	
	
	
	public List<Department> findTopList() {
		return getSession().createQuery(
				"FROM Department d WHERE d.parent IS NULL").list();
	}

	
	public List<Department> findChildrenList(Long parentId) {
		return getSession().createQuery(
				"FROM Department d WHERE d.parent.id=?")
				.setParameter(0, parentId)
				.list();
	}

}
