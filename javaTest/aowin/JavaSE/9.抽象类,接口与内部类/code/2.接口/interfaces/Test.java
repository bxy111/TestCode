package com.aowin.interfaces;

public class Test {
	
	public static void main(String[] args) {
		Mouse m=new Mouse();
		USB.fun3();
		Computer com=new Computer();
		com.use(new Mouse());
	}
}	
