package com.test.action;

import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.test.base.BaseAction;
import com.test.domain.Department;
import com.test.domain.Role;
import com.test.domain.User;
import com.test.util.DepartmentUtils;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {


	private Long departmentId;

	private Long[] roleIds;

	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);
		return "list";
	}

	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		userService.delete(model.getId());
		return "toList";
	}

	/**
	 * 添加页面
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		// 准备数据，departmentList
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
		System.out.println("=====)))");
		System.err.println(departmentList.size());
		ActionContext.getContext().put("departmentList", departmentList);

		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "saveUI";
	}

	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		//封装到对象中(当model是实体类型时，也可以使用model，但要设置未封装的属性)
		//设置所属部门
		model.setDepartment(departmentService.getById(departmentId));
		//设置所属岗位
		List<Role> userList = roleService.getByIds(roleIds);
		model.setRoles(new HashSet<Role>(userList));

		//设置初始化密码(要使用md5摘要)
//		String md5Digest = DigestUtils.md5Hex("1234");
		//String md5Digest = "1234";
		//model.setPassword(md5Digest);

		//保存到数据库
		userService.save(model);
		return "toList";
	}

	/**
	 * 修改页面
	 * @return
	 * @throws Exception
	 */
	
	public String editUI() throws Exception {
		// 准备数据，departmentList
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		
		//准备数据，roleList
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		
		//准备回显的数据
		User user = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		if(user.getDepartment()!=null){
			departmentId = user.getDepartment().getId();
		}
		if(user.getRoles()!=null){
			roleIds = new Long[user.getRoles().size()];
			int index = 0;
			for (Role role : user.getRoles()) {
				roleIds[index++] = role.getId();
			}
		}
		return "saveUI";
	}

	
	
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	
	
	public String edit() throws Exception {
		//1.从数据库中取出原对象
		User user = userService.getById(model.getId());
		//2.设置要修改的属性
		user.setLoginName(model.getLoginName());
		user.setName(model.getName());
		user.setPhoneNumber(model.getPhoneNumber());
		user.setGender(model.getGender());
		user.setEmail(model.getEmail());
		user.setDescription(model.getDescription());
		
		//设置用户的部门
		user.setDepartment(departmentService.getById(departmentId));
		//设置用户的岗位
		List<Role> roleList = roleService.getByIds(roleIds);
		user.setRoles(new HashSet<Role>(roleList));
		
		
		//3.更新到数据库
		userService.update(user);
		return "toList";
	}
	
	
	
	
	
	
	
	
	
	

	/**
	 * 初始化密码
	 * @return
	 * @throws Exception
	 */
	public String initPassword() throws Exception {
		User user = userService.getById(model.getId());
		
		//要使用md5摘要
//		String md5Digest = DigestUtils.md5Hex("1234");
		String md5Digest = "1234";
		user.setPassword(md5Digest);
		userService.update(user);
		return "toList";
	}
	
	/**
	 * 登录页面
	 */
	public String loginUI() throws Exception{
		System.out.println("loginUI");
		return "loginUI";
	}
	
	/**
	 * 登录
	 * @return
	 */
	public String login() throws Exception{
		System.out.println("UserAction.login()");
		System.out.println(model.toString());
		User user = userService.findByLoginNameAndPassword(model.getLoginName(),model.getPassword());
		if(user==null){
			addFieldError("login", "用户名或密码不正确！");
			System.out.println("000");
			return "loginUI";
		}else{
			//登录用户
			ActionContext.getContext().getSession().put("user", user);
			System.out.println("++++++++++++登录成功了++++++++++++++++++++++");
			return "toIndex";
		}
	}
	
	/**
	 * 注销
	 * @return
	 */
	public String logout() throws Exception{
		System.out.println("+++++++zhuxiaozhucom.zhy.system_oa.view.action.UserAction.logout()");
		ActionContext.getContext().getSession().remove("user");
		return "logout";
	}

	
	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}



}
