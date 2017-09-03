package com.test.action;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.base.BaseAction;
import com.test.domain.Privilege;
import com.test.domain.Role;
import com.test.service.RoleService;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{

	private Long[] privilegeIds;
	
	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}
	
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		roleService.delete(model.getId());
		return "toList";
	}
	
	/**
	 * 添加页面
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		return "saveUI";
	}
	
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
//		Role role = new Role();
//		role.setName(model.getName());
//		role.setDescription(model.getDescription());
		roleService.save(model);
		return "toList";
	}
	
	/**
	 * 修改页面
	 * @return
	 * @throws Exception
	 */
	public String editUI() throws Exception {
		//准备回显数据
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	}
	
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception {
		//1.从数据库中获取原对象
		Role role = roleService.getById(model.getId());
		//2.设置要修改的值
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		//3.修改设置的值
		roleService.update(role);
		
		return "toList";
	}
	
	
	/**
	 * 设置权限页面
	 * @return
	 * @throws Exception
	 */
	public String setPrivilegeUI() throws Exception {
		//准备回显数据
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		if(role.getPrivileges() != null){
			privilegeIds =  new Long[role.getPrivileges().size()];
			int index = 0;
			for (Privilege privilege : role.getPrivileges()) {
				privilegeIds[index++] = privilege.getId();
			}
		}
		//准备数据
		List<Privilege> privilegeList = privilegeService.findAll();
		ActionContext.getContext().put("privilegeList", privilegeList);
		return "setPrivilegeUI";
	}
	
	/**
	 * 设置权限
	 * @return
	 * @throws Exception
	 */
	public String setPrivilege() throws Exception {
		//1.从数据库中获取原对象
		Role role = roleService.getById(model.getId());
		//2.设置要修改的值
		List<Privilege> privileges = privilegeService.getByIds(privilegeIds);
		role.setPrivileges(new HashSet<Privilege>(privileges));
		
		//3.修改设置的值
		roleService.update(role);
		
		return "toList";
	}

	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

	
	
}
