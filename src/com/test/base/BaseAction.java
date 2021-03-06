package com.test.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.domain.Department;
import com.test.domain.User;
import com.test.service.DepartmentService;
import com.test.service.PrivilegeService;
import com.test.service.RoleService;
import com.test.service.UserService;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	//==================ModelDriven的支持=================
	
	protected T model;
	
	public BaseAction(){
		try {
			//通过反射获得model的真实类型
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz= (Class<T>) pt.getActualTypeArguments()[0];
			//反射创建model的实例
			model=clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public T getModel() {
		return model;
	}
	
	
	//==================所有service实例的声明=================
	
	@Resource
	protected DepartmentService departmentService;
	
	@Resource
	protected RoleService roleService;
	
	@Resource
	protected UserService userService;
	
	@Resource
	protected PrivilegeService privilegeService;
	
	/**
	 * 获取当前登录对象
	 * @return
	 */
	protected User getCurrentUser(){
		return (User) ActionContext.getContext().getSession().get("user");
	}
	
	
	//==================分页信息====================
	
		protected int pageNum = 1;//当前页
		protected int pageSize = 10;//每页显示多少条记录
		
		public int getPageNum() {
			return pageNum;
		}

		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		
}
