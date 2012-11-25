package com.controller;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

import com.entity.IUserDAO;
import com.entity.User;
import com.entity.UserDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogonAction extends ActionSupport{

	private String userName;
	private String password;
	private String code;
	
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
			this.addFieldError("userName", "�û�������Ϊ��");
		}
		if("".equals(password)){
			this.addFieldError("password", "���벻��Ϊ��");
		}
		Map session = (Map)ActionContext.getContext().getSession();
		String rightCode = (String)session.get("rand");
		if ( !rightCode.toUpperCase().equals(code.toUpperCase()) )
		{
			this.addFieldError("codereg", "��֤����������");
		}
	}
	
	public boolean test(){
		User test = new User();
		IUserDAO iuserdao=new UserDAO();
		List<User> userlist=iuserdao.findByName(userName);
		    Iterator<User> userlist2=userlist.iterator();
		    if(userlist2.hasNext())
		    {
		    	test=userlist2.next();
		        if(test.getPassword().equals(password)){
				Map session = (Map)ActionContext.getContext().getSession();
				session.put("user", userName);
				return true;
			     }
			    else{
				     this.addFieldError("password", "�������");
				     return false;
				     }
		   }
		    else {
		    	this.addFieldError("userName", "�û���������");
		        return false;
		        }
		
	
	}
	
	@Override
	public String execute() throws Exception {
		if(test())
		{return SUCCESS;}
		else return INPUT;
	}


}


