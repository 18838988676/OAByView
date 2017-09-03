package com.test.base;

import java.util.List;

public interface BaseDao<T> {

	/**
	 * 增加实体
	 * @param entity
	 */
	void save(T entity);
	
	/**
	 * 删除实体
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * 更新实体
	 * @param entity
	 */
	void update(T entity);
	
	/**
	 * 按ID查询
	 * @param id
	 * @return
	 */
	T getById(Long id);
	
	/**
	 * 按IDs查询
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);

	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * 查询分页信息
	 * @param pageNum
	 * @param pageSize
	 * @param hql 查询数据类型的hql
	 * @param parameters 参数列表，其顺序和hql中的问号一一对应
	 * @return
	 */
//	@Deprecated
//	PageBean getPageBean(int pageNum, int pageSize, String hql,List<Object> parameters);
	
	/**
	 * 查询分页信息（4.0）
	 * @param pageNum
	 * @param pageSize
	 * @param queryHelper
	 * 			HQL语句与参数列表		
	 * @return
	 */
	
}
