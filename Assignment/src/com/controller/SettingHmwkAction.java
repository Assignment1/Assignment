package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import com.entity.Assignment;
import com.entity.AssignmentDAO;
import com.entity.EntityManagerHelper;
import com.entity.IAssignmentDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SettingHmwkAction extends ActionSupport {
	
	private String Name;
	private String Start;
	private String End;
	private String Submitcount;
	private String hmwk;
	
	
	public String getName(){
		return Name;
	}
	public void setName(String name){
		this.Name=name;
	}
	
	public String getStart(){
		return Start;
	}
	public void setStart(String start){
		this.Start=start;
	}
	
	public String getEnd(){
		return End;
	}
	public void setEnd(String end){
		this.End=end;
	}
	
	public String getHmwk(){
		return hmwk;
	}
	public void setHmwk(String hmwk){
		this.hmwk=hmwk;
	}
	
	@SuppressWarnings("unchecked")
	private boolean settingHmwk(){
		Assignment assignment=new Assignment();
		assignment.setAssignmentName(Name);
		SimpleDateFormat formater= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
		try {
			Date start = formater.parse(Start);
			Date end=formater.parse(End);
			assignment.setStartTime(start);
			assignment.setDeadline(end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assignment.setAssignmentDescribe(hmwk);
		assignment.setSubmitCount(Integer.getInteger(Submitcount));
		IAssignmentDAO iassignmentdao=new AssignmentDAO();
		EntityManagerHelper.beginTransaction();
		iassignmentdao.save(assignment);
		EntityManagerHelper.commit();
		Map session = (Map)ActionContext.getContext().getSession();
		session.put("assignment", Name);
		return true;
	}
	
	public void validate(){
		if("".equals(Name)){
			this.addFieldError("Name","��ҵ������Ϊ��");
		}
		if("".equals(Start)){
			this.addFieldError("Start","��ʼʱ�䲻��Ϊ��");
		}
		if("".equals(End)){
			this.addFieldError("End","����ʱ�䲻��Ϊ��");
		}
		if("".equals(Submitcount)){
			this.addFieldError("Submitcount","��ҵ�Ų���Ϊ��");
		}
		if("".equals(hmwk)){
			this.addFieldError("hmwk","��ҵ����Ϊ��");
		}
		//Assignment assignement = new Assignment();
		IAssignmentDAO iassignmentdao=new AssignmentDAO();
		List<Assignment> Assignmentlt = iassignmentdao.findByAssignmentName(Name);
		Iterator<Assignment>Assignmentit = Assignmentlt.iterator();
		if(Assignmentit.hasNext())
		{
			this.addFieldError("hmwkName", "��ҵ���Ѵ���");
		}
		Map session = (Map)ActionContext.getContext().getSession();
	}
	
	public String execute() throws Exception{
		if(settingHmwk()){
			System.out .println("���óɹ�");
			return SUCCESS;
		}
			
		else
			return INPUT;
		}

}
