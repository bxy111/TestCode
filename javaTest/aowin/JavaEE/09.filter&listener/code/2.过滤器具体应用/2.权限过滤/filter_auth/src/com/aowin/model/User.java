package com.aowin.model;

public class User {
	private String account;
	private String password;
	private String name;
	private String auth;
	public User(String account, String password, String name,String auth) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
		this.auth=auth;
	}
	
	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
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
