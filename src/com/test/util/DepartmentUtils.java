package com.test.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.test.domain.Department;

public class DepartmentUtils {

	/**
	 * 遍历部门数。把所有部门遍历出来放到同一个集合众返回，并且其中所有部门的名称都修改了，以表示层次
	 * @param topList
	 * @return
	 */
	public static List<Department> getAllDepartments(List<Department> topList) {
		List<Department> list = new ArrayList<Department>();
		walkDepartmentTreeList(topList, " ┣", list);
		return list;
	}
	
	/**
	 * 遍历部门数,希望把遍历出的部门信息放到指定的集合中
	 * @param toList
	 */
	private static void walkDepartmentTreeList(Collection<Department> toList, String prefix, List<Department> list){
		for (Department department : toList) {
			
			Department copy = new Department();//使用副本，因为原对象在session中
			copy.setId(department.getId());
			copy.setName(prefix + department.getName());
			list.add(copy);
			
			walkDepartmentTreeList(department.getChildren(), "　"+prefix, list);//使用全角空格
		}
		
	}

	
	
}
