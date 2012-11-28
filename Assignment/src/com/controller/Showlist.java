package com.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.Actor;
import com.entity.IUserDAO;
import com.entity.User;
import com.entity.UserDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Showlist extends ActionSupport{

	private List<User> studentList;
	private List<User> nonveList;
	private List<User> veList;
	
	
	public List<User> getStudentList() {
		return studentList;
	}


	public void setStudentList(List<User> studentList) {
		this.studentList = studentList;
	}


	
	

	public List<User> getNonveList() {
		return nonveList;
	}


	public void setNonveList(List<User> nonveList) {
		this.nonveList = nonveList;
	}


	public List<User> getVeList() {
		return veList;
	}


	public void setVeList(List<User> veList) {
		this.veList = veList;
	}


	@Override
	public String execute() throws Exception {

		
			IUserDAO iuserdao = new UserDAO();
			nonveList = new ArrayList<User>();
			veList = new ArrayList<User>();
	        studentList=iuserdao.findByActor(Actor.STUDENT);
	        User student = new User();
			System.out.print(studentList.size());
			
			for(int i=0;i<studentList.size();i++)
			{
				student = studentList.get(i);
				if(student.getVerification().equals("1"))
				{
					veList.add(student);
				}
				else
			    {
					nonveList.add(student);
			    }
			}
			return "toTrue";
		}
	}
	
	


	
	
	
	
	

