package com.example.user.model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private int age;
	private String phonenumber;
	private String emailid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phonenumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phonenumber = phoneNumber;
	}
	public String getEmailId() {
		return emailid;
	}
	public void setEmailId(String emailId) {
		this.emailid = emailId;
	}	
}
