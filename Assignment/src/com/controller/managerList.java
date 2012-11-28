package com.controller;

import java.util.ArrayList;
import java.util.List;
import com.entity.Actor;
import com.entity.IUserDAO;
import com.entity.User;
import com.entity.UserDAO;

public class managerList {

	private List<User> managerlist;
	private List<User> nonveList;
	private List<User> veList;
	
	public List<User> getManagerlist() {
		return managerlist;
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



	public void setManagerlist(List<User> managerlist) {
		this.managerlist = managerlist;
	}



	public String execute(){
		IUserDAO iuserdao = new UserDAO();
		nonveList = new ArrayList<User>();
		veList = new ArrayList<User>();
		managerlist = iuserdao.findByActor(Actor.MANAGER);
		User manager = new User();
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
