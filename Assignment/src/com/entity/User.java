package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "assignment")
public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userName;
	private String password;
	private String email;
	private String realName;
	private Actor actor = Actor.STUDENT;
	private String studentId;
	private String verification = "0";

	// Constructors

	/** default constructor */
	public User() {
	}

	public User( String userName, String password, String email,
			String realName, String studentId ){
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.realName = realName;
		this.studentId = studentId;
	}
	
	/** full constructor */
	public User(String userName, String password, String email,
			String realName, Actor actor, String studentId, String verification) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.realName = realName;
		this.actor = actor;
		this.studentId = studentId;
		this.verification = verification;
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

	@Column(name = "userName", nullable = false, length = 10)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", nullable = false, length = 16)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "realName", nullable = false, length = 10)
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "actor", nullable = false, length = 7)
	public Actor getActor() {
		return this.actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	@Column(name = "studentId", nullable = false, length = 10)
	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@Column(name = "verification", nullable = false)
	public String getVerification() {
		return this.verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}

}