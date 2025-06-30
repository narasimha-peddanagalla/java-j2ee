package com.userapp.model;
//A Java Bean
public class User {
	private int id;
	private String name;
	private String email;
	private String contact;
	private String password;
	
	//Constructor - NO Id - for insert
	
	public User(String name,String email,String contact,String password) {
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.password = password;
	}
	
	//Constructor for fetching the Data
	public User(int id,String name,String email,String contact) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.contact = contact;
	}
	//Constructor to Update the Data
	public User(int id,String name,String email,String pwd,String contact) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = pwd;
		this.contact = contact;
	}
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String pwd) {
		this.password = pwd;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}
