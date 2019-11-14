package com.aowin.defined;

public class ATM {
	//输入密码正确,就可以取钱
	//钱
	private double money;
	//密码
	private String psw;
	public ATM() {
		psw="123456";
	}
	public double getMoney() {
		return money;
	}
	public void in(String psw,int count) throws PasswordMismatchException, EnvironmentSecurityException {
		if(count==110) {
			throw new EnvironmentSecurityException();
		}
		if(!this.psw.equals(psw)) {
			throw new PasswordMismatchException("密码不正确");
		}else {
			System.out.println("来取钱吧");
		}
		
		
	}
	public void add(double money) {
		if(money<=0) {
			throw new NegativeMoneyException();
		}
		this.money+=money;
	}
	public void get(double money) {
		if(money<=0) {
			throw new NegativeMoneyException();
		}
		if(money>this.money) {
			throw new MoneyNotEnoughException();
		}
		this.money-=money;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	
}
