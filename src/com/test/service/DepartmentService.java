package com.test.service;

import java.util.List;

import com.test.base.BaseDao;
import com.test.domain.Department;

public interface DepartmentService extends BaseDao<Department>{

	List<Department> findAll();

	void delete(Long id);

	void save(Department department);

	Department getById(Long id);

	void update(Department department);

	/**
	 * 查询部门顶级列表
	 * @return
	 */
	List<Department> findTopList();

	
	/**
	 * 查询子部门列表
	 * @param parentId
	 * @return
	 */
	List<Department> findChildrenList(Long parentId);

	

}
