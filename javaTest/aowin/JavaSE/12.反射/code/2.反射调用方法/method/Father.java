package com.aowin.method;

public class Father {
	public Father() {
		// TODO Auto-generated constructor stub
	}
	private Father(String name) {
		
	}
	public void eat1() {
		System.out.println("eat1");
	}
	private void eat2() {
		System.out.println("eat2");
	}
	void eat3() {
		System.out.println("eat3");
	}
	protected void eat4() {
		System.out.println("eat4");
	}
}
