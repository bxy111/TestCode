package com.aowin.defined;

public class NegativeMoneyException extends RuntimeException{
	public NegativeMoneyException() {
		super("钱不能为负数");
	}
}
