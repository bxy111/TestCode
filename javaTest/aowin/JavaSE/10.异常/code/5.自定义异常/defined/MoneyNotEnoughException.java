package com.aowin.defined;

public class MoneyNotEnoughException extends RuntimeException{
	public MoneyNotEnoughException() {
		//指定错误信息
		super("钱不够了!!!");
	}
}
