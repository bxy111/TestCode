package com.aowin.model;

public class Vote {
	private String mind;//心情
	private int num;//票数
	public Vote(String mind, int num) {
		super();
		this.mind = mind;
		this.num = num;
	}
	public String getMind() {
		return mind;
	}
	public void setMind(String mind) {
		this.mind = mind;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
