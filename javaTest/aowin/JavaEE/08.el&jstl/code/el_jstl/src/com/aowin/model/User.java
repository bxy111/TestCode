package com.aowin.model;

import java.io.Serializable;

public class User implements Serializable{
	private String account;
	private String password;
	private String name;
	
	public User() {
		super();
	}
	public User(String account, String password, String name) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}