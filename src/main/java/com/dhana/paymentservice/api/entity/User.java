package com.dhana.paymentservice.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="USER_DATA")
public class User {
	
	@GeneratedValue
	@Id
	private int id;
	private String userName;
	private String password;
	private String email;
	private int experience;
	private String domain;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String name) {
		this.userName = name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public User(int id, String userName,String password, String email, int experience, String domain) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.experience = experience;
		this.domain = domain;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
