package com.controller;

import java.util.ArrayList;
import java.util.List;
import com.entity.Actor;
import com.entity.EntityManagerHelper;
import com.entity.IUserDAO;
import com.entity.User;
import com.entity.UserDAO;

public class nonvestudentOp {
	private String[] nonvestudentValue;
	private String operation;
	private List<User> studentList;
	
	public String[] getNonvestudentValue() {
		return nonvestudentValue;
	}

	public void setNonvestudentValue(String[] nonvestudentValue) {
		this.nonvestudentValue = nonvestudentValue;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

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

	private List<User> nonveList;
	private List<User> veList;

	
	private void pass(){
		IUserDAO iuserdao = new UserDAO();
		User student = new User();
		EntityManagerHelper.beginTransaction();
		for(String studentId : nonvestudentValue){
			student = iuserdao.findById(Integer.parseInt(studentId));
			student.setVerification("1");
			iuserdao.save(student);
		}
		EntityManagerHelper.commit();
	}
	
	private void reject(){
		IUserDAO iuserdao = new UserDAO();
		User student = new User();
		EntityManagerHelper.beginTransaction();
		for(String studentId : nonvestudentValue){
			student = iuserdao.findById(Integer.parseInt(studentId));
			iuserdao.delete(student);
		}
		EntityManagerHelper.commit();
	}
	
	public String execute(){
		if(operation.equals("1"))
		{
			pass();
		}
		else if(operation.equals("2"))
		{
			reject();
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
