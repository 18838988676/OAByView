package com.test.util;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.test.domain.User;

@SuppressWarnings("serial")
public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
		System.out.println("---------------之前");
		//放行
	/*	System.out.println("arg0.getProxy()"+arg0.getProxy());
		System.out.println(arg0.getAction());
		System.out.println(arg0.getResultCode());
		System.out.println(arg0.getClass());
		System.out.println(arg0.getInvocationContext());
		System.out.println(arg0.getProxy());
		System.out.println(arg0.getResult());
		System.out.println(arg0.getStack());
		*/
		String result = arg0.invoke();
		System.out.println("arg0.invoke()调用："+result+"....");
		
  	System.out.println("---------------之后");
		
		//获取信息
		User user = (User) ActionContext.getContext().getSession().get("user");
		System.out.println("user:"+user);
		
		String nameSpace = arg0.getProxy().getNamespace();
		System.out.println("namespcae:"+nameSpace);
		
		String actionName = arg0.getProxy().getActionName();
		System.out.println("actinname:"+actionName);
		
		String privUrl = nameSpace+actionName;
		System.out.println("privUrl:"+privUrl);
		//如果未登陆，就转到登录页面
		
		if(user == null){
			if(privUrl.startsWith("/user_login")){//  "/user_loginUI", "/user_login"
				//如果是去登录，就放行
				System.out.println("去登录，就放行");
				return arg0.invoke();
			}else{
				//如果不是去登录，就转到登录页面
				System.out.println("去登录，就放1111");
				return "loginUI";
			}
		}
		//如果已登录，就判断权限
		else{
			if(user.hasPrivilegeByUrl(privUrl)){
				//如果有权限，就放行
				return arg0.invoke();
			} else {
				//如果没有权限，就转到提示页面
				return "error";
			}
		}
		
		
	}

}
