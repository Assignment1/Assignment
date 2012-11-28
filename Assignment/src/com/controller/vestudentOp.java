package com.controller;

import java.util.ArrayList;
import java.util.List;
import com.entity.Actor;
import com.entity.EntityManagerHelper;
import com.entity.IUserDAO;
import com.entity.User;
import com.entity.UserDAO;

public class vestudentOp {
	private String[] vestudentValue;
	private String operation;
	private List<User> studentList;

	private List<User> nonveList;
	private List<User> veList;
	public String[] getVestudentValue() {
		return vestudentValue;
	}

	public void setVestudentValue(String[] vestudentValue) {
		this.vestudentValue = vestudentValue;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public List<User> getStudentlist() {
		return studentList;
	}

	public void setStudentlist(List<User> studentlist) {
		this.studentList = studentlist;
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


	

	private void cancel(){
		IUserDAO iuserdao = new UserDAO();
		User student = new User();
		EntityManagerHelper.beginTransaction();
		for(String studentId : vestudentValue){
			student = iuserdao.findById(Integer.parseInt(studentId));
			student.setVerification("0");
			iuserdao.save(student);
		}
		EntityManagerHelper.commit();
	}
	
	private void delete(){
		IUserDAO iuserdao = new UserDAO();
		User student = new User();
		EntityManagerHelper.beginTransaction();
		for(String studentId : vestudentValue){
			student = iuserdao.findById(Integer.parseInt(studentId));
			iuserdao.delete(student);
		}
		EntityManagerHelper.commit();
	}
	
	public String execute()
	{
		if(operation.equals("1"))
		{
			cancel();
		}
		else if(operation.equals("2"))
		{
			delete();
		}
		IUserDAO iuserdao = new UserDAO();
		User student = new User();
		studentList = iuserdao.findByActor(Actor.STUDENT);
		nonveList = new ArrayList<User>();
		veList = new ArrayList<User>();
		for(int i=0;i<studentList.size();i++)
		{
			student = studentList.get(i);
			if(student.getVerification().equals("0"))
			{
				nonveList.add(student);
			}
			else
		    {
				veList.add(student);
		    }
		}
		return "toTrue";
	}
}
