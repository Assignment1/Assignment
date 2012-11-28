package com.controller;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

import com.entity.Actor;
import com.entity.IUserDAO;
import com.entity.User;
import com.entity.UserDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogonAction extends ActionSupport{

	private String userName;
	private String password;
	private String code;
    private Actor actor;
	
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public void validate(){
		if("".equals(userName)){
			this.addFieldError("userName", "用户名不能为空");
		}
		if("".equals(password)){
			this.addFieldError("password", "密码不能为空");
		}
		Map session = (Map)ActionContext.getContext().getSession();
		String rightCode = (String)session.get("rand");
		if ( !rightCode.toUpperCase().equals(code.toUpperCase()) )
		{
			this.addFieldError("codereg", "验证码输入有误");
		}
	}
	
	public String test(){
		User test = new User();
		IUserDAO iuserdao=new UserDAO();
		List<User> userlist=iuserdao.findByUserName(userName);
		    Iterator<User> userlist2=userlist.iterator();
		    if(userlist2.hasNext())
		    {
		    	test=userlist2.next();
		        if(test.getPassword().equals(password)){
				Map session = (Map)ActionContext.getContext().getSession();
				session.put("user", userName);
				if(test.getActor()==actor.TEACHER){
					return "teacher";
				}
				else if(test.getActor()==actor.STUDENT){
					if(test.getVerification().equals("0"))
					{
						this.addFieldError("userName", "用户尚未通过验证");
					}
					return "student";
				}
				else return "manager";
			     
		        }
				
			    else{
				     this.addFieldError("password", "密码错误");
				     return "false";
				     }
		        
		   }
		    else {
		    	this.addFieldError("userName", "用户名不存在");
		        return "false";
		        }
		
	
	}
	
	@Override
	public String execute() throws Exception {
		if(test()=="student")
		{return "student";}
		else if(test()=="teacher")
		{  System.out.print("teacher");
			return "teacher";}
		else if(test()=="manager")
		{return "manager";}
		else return INPUT;
	}


}


