package com.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Assignment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "assignment", catalog = "assignment")
public class Assignment implements java.io.Serializable {

	// Fields

	private Integer id;
	private String assignmentName;
	private Date startTime;
	private Date deadline;
	private Integer submitCount;
	private String assignmentDescribe;

	// Constructors

	/** default constructor */
	public Assignment() {
	}

	/** minimal constructor */
	public Assignment(String assignmentName, Date startTime, Date deadline,
			String assignmentDescribe) {
		this.assignmentName = assignmentName;
		this.startTime = startTime;
		this.deadline = deadline;
		this.assignmentDescribe = assignmentDescribe;
	}

	/** full constructor */
	public Assignment(String assignmentName, Date startTime, Date deadline,
			Integer submitCount, String assignmentDescribe) {
		this.assignmentName = assignmentName;
		this.startTime = startTime;
		this.deadline = deadline;
		this.submitCount = submitCount;
		this.assignmentDescribe = assignmentDescribe;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "assignmentName", nullable = false, length = 50)
	public String getAssignmentName() {
		return this.assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "startTime", nullable = false, length = 10)
	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "deadline", nullable = false, length = 10)
	public Date getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	@Column(name = "submitCount")
	public Integer getSubmitCount() {
		return this.submitCount;
	}

	public void setSubmitCount(Integer submitCount) {
		this.submitCount = submitCount;
	}

	@Column(name = "assignmentDescribe", nullable = false, length = 65535)
	public String getAssignmentDescribe() {
		return this.assignmentDescribe;
	}

	public void setAssignmentDescribe(String assignmentDescribe) {
		this.assignmentDescribe = assignmentDescribe;
	}

}