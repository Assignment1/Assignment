package com.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.entity.Actor;
import com.entity.IUserDAO;
import com.entity.User;
import com.entity.UserDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.entity.EntityManagerHelper;

public class Register extends ActionSupport{
	private String userName;
	private String password1;
	private String password2;
	private String email;
	private String realName;
	private String studentId;
    private String code;
    private String actor;
	public String getActor() {
		return actor;
	}


	public void setActor(String actor) {
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


	public String getPassword1() {
		return password1;
	}


	public void setPassword1(String password1) {
		this.password1 = password1;
	}


	public String getPassword2() {
		return password2;
	}


	public void setPassword2(String password2) {
		this.password2 = password2;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRealName() {
		return realName;
	}


	public void setRealName(String realName) {
		this.realName = realName;
	}


	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public void validate(){
		if("".equals(userName)){
			this.addFieldError("userNamereg","�û�������Ϊ��");
		}
		if("".equals(password1)){
			this.addFieldError("password1reg","���벻��Ϊ��");
		}
		if("".equals(password2)){
			this.addFieldError("password2reg","ȷ�����벻��Ϊ��");
		}
		if("".equals(email)){
			this.addFieldError("emailreg","���䲻��Ϊ��");
		}
		if("".equals(realName)){
			this.addFieldError("realNamereg","ȷ�����벻��Ϊ��");
		}
		if("".equals(studentId)){
			this.addFieldError("studentIdreg","���䲻��Ϊ��");
		}
		if(userName.length()<4||userName.length()>10)
		{
			this.addFieldError("userNamereg", "�û�������Ϊ4~10λ");
		}
		if(!password1.equals(password2)){
			this.addFieldError("password1reg", "������ȷ�����벻һ��");
		}
		if(email.indexOf(".",email.indexOf("@"))==-1)
		{
			this.addFieldError("emailreg", "�����ʽ����");
		}
		IUserDAO iuserdao = new UserDAO();
		List<User> userlt = iuserdao.findByUserName(userName);
		Iterator<User> userit = userlt.iterator();
		if(userit.hasNext())
		{
			this.addFieldError("userNamereg", "�û����Ѵ���");
		}
		userlt = iuserdao.findByEmail(email);
		userit = userlt.iterator();
		if(userit.hasNext())
		{
			this.addFieldError("emailreg", "�������Ѿ�ע��");
		}
		Map session = (Map)ActionContext.getContext().getSession();
		String rightCode = (String)session.get("rand");
		if ( !rightCode.toUpperCase().equals(code.toUpperCase()) )
		{
			this.addFieldError("codereg", "��֤����������");
		}
			
	}

	public boolean write(){
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password1);
		user.setEmail(email);
		user.setRealName(realName);
		user.setStudentId(studentId);
		if(actor.equals("����"))
		{
			user.setActor(Actor.MANAGER);
		}
		IUserDAO iuserdao = new UserDAO();
		EntityManagerHelper.beginTransaction();
		iuserdao.save(user);
		EntityManagerHelper.commit();
		return true;
	}
	
	public String execute(){
		if(write())
		{
			return "toTrue";
		}
		return "input";
	}
}
