package com.test.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class HomeAction extends ActionSupport{

	public String index(){
		System.out.println("HOMEACTION+index");
		return "index";
	}
	public String top(){
		System.out.println("HOMEACTION+top");
		return "top";
	}
	public String bottom(){
		System.out.println("HOMEACTION+bottom");
		return "bottom";
	}
	public String left(){
		System.out.println("HOMEACTION+left");
		return "left";
	}
	public String right(){
		System.out.println("HOMEACTION+right");
		return "right";
	}
	
}
