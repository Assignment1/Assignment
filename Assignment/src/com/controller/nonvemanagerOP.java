package com.controller;

import java.util.ArrayList;
import java.util.List;
import com.entity.Actor;
import com.entity.EntityManagerHelper;
import com.entity.IUserDAO;
import com.entity.User;
import com.entity.UserDAO;

public class nonvemanagerOP {
	private String[] nonvemanagerValue;
	private String operation;
	private List<User> managerlist;
	private List<User> nonveList;
	private List<User> veList;

	public List<User> getManagerlist() {
		return managerlist;
	}

	public void setManagerlist(List<User> managerlist) {
		this.managerlist = managerlist;
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

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public String[] getNonvemanagerValue() {
		return nonvemanagerValue;
	}

	public void setNonvemanagerValue(String[] nonvemanagerValue) {
		this.nonvemanagerValue = nonvemanagerValue;
	}

	private void pass(){
		IUserDAO iuserdao = new UserDAO();
		User manager = new User();
		EntityManagerHelper.beginTransaction();
		for(String managerId : nonvemanagerValue){
			manager = iuserdao.findById(Integer.parseInt(managerId));
			manager.setVerification("1");
			iuserdao.save(manager);
		}
		EntityManagerHelper.commit();
	}
	
	private void reject(){
		IUserDAO iuserdao = new UserDAO();
		User manager = new User();
		EntityManagerHelper.beginTransaction();
		for(String managerId : nonvemanagerValue){
			manager = iuserdao.findById(Integer.parseInt(managerId));
			iuserdao.delete(manager);
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
		User manager = new User();
		managerlist = iuserdao.findByActor(Actor.MANAGER);
		nonveList = new ArrayList<User>();
		veList = new ArrayList<User>();
		for(int i=0;i<managerlist.size();i++)
		{
			manager = managerlist.get(i);
			if(manager.getVerification().equals("0"))
			{
				nonveList.add(manager);
			}
			else
		    {
				veList.add(manager);
		    }
		}
		return "toTrue";
	}
}
