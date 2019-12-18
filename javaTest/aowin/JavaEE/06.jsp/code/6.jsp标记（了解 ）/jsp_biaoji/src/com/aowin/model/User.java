package com.aowin.model;

import java.io.Serializable;

public class User implements Serializable{
	private String account;
	private String password;
	private String name;
	private boolean male;
	
	public User() {}
	
	public User(String account, String password, String name, boolean male) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
		this.male = male;
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
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	
	
}
